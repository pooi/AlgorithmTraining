package d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1227 {

    public static String [][]map;
    public static boolean [][]visited;
    public static int [][]dt = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };

    static class Vec2{
        public int x, y;
        public Vec2(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return this.x == ((Vec2)obj).x && this.y == ((Vec2)obj).y ;
        }

        public boolean equals(int x, int y) {
            return this.x == x && this.y == y ;
        }
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=10; testCase++){

            int T = scn.nextInt();
            map = new String[100][100];
            visited = new boolean[100][100];
            Vec2 start = new Vec2(0,0);
            Vec2 finish = new Vec2(0,0);

            for(int y=0; y<100; y++){
                String temp = scn.next();
                for(int x=0; x<100; x++){
                    String tmp = temp.charAt(x) + "";
                    map[y][x] = tmp;
                    visited[y][x] = tmp.equals("1");
                    if(tmp.equals("2")) start = new Vec2(x, y);
                    if(tmp.equals("3")) finish = new Vec2(x, y);
                }
            }

            Queue<Vec2> queue = new LinkedList<Vec2>();
            queue.add(start);

            boolean check = false;
            while (!queue.isEmpty()){

                Vec2 node = queue.remove();
                for(int i=0; i<dt.length; i++){
                    int nx = node.x + dt[i][0];
                    int ny = node.y + dt[i][1];
                    if(0 <= nx && nx < 100 && 0 <= ny && ny < 100){
                        if(finish.equals(nx, ny)){
                            check = true;
                            queue.clear();
                            break;
                        }
                        if(!visited[ny][nx]){
                            queue.add(new Vec2(nx, ny));
                            visited[ny][nx] = true;
                        }
                    }
                }

            }

            System.out.println("#" + T + " " + (check? "1" : "0"));
        }
    }
}
