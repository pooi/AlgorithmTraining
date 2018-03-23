package d4;

import java.util.Scanner;

public class P1226 {

    static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean isSame(int x, int y){
            return x == this.x && y == this.y;
        }
    }

    public static int[][] map;
    public static boolean[][] flag;
    public static Point start, finish;
    public static Point[] direction ={
            new Point(0, -1),
            new Point(1, 0),
            new Point(0, 1),
            new Point(-1, 0)
    };
//    public static boolean isFound;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=10; testCase++){

            int T = scn.nextInt();
            map = new int[17][17];
            flag = new boolean[17][17];

            for(int y=0; y<16; y++){
                String str = scn.next();
                for(int x=0; x<str.length(); x++){
                    int data = Integer.parseInt(str.charAt(x) + "");
                    map[y][x] = data;
                    if(data == 2)
                        start = new Point(x, y);
                    else if(data == 3)
                        finish = new Point(x, y);

                }
            }

            boolean isFound = search(start.x, start.y);
            System.out.println(String.format("#%d %s", testCase, (isFound ? "1" : "0")));

        }

    }

    public static boolean search(int x, int y){
        if(x < 0 || x > 16 || y < 0 || y > 16)
            return false;
        flag[y][x] = true;
        for(Point p : direction){
            int newX = x + p.x;
            int newY = y + p.y;
            if(finish.isSame(newX, newY)){
                return true;
            }
            if(!flag[newY][newX] && map[newY][newX] == 0){
                if(search(newX, newY)){
                    return true;
                }
            }
        }
        return false;
    }
}
