package d5;

import java.util.Scanner;

public class P1247 {

    public static class Point{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int distance(Point p){
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }
    }

    public static int N;
    public static Point company, home;
    public static Point []list;
    public static boolean []flag;
    public static int min;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){

            N = scn.nextInt();

            min = Integer.MAX_VALUE-1;
            list = new Point[N];
            flag = new boolean[N];

            company = new Point(scn.nextInt(), scn.nextInt());
            home = new Point(scn.nextInt(), scn.nextInt());

            for(int i=0; i<N; i++)
                list[i] = new Point(scn.nextInt(), scn.nextInt());

            find(0, 0, 0);

            System.out.println(String.format("#%d %d", testCase, min));

        }
    }

    public static void find(int depth, int distance, int pre){
        if(depth == N){
            distance += home.distance(list[pre]);
            if(distance < min)
                min = distance;
            return;
        }
        for(int i=0; i<N; i++){
            if(!flag[i]){
                int newDistance = distance;
                if(depth == 0)
                    newDistance += company.distance(list[i]);
                else
                    newDistance += list[pre].distance(list[i]);
                if(newDistance > min)
                    continue;
                flag[i] = true;
                find(depth+1, newDistance, i);
                flag[i] = false;
            }
        }
    }
}
