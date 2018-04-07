package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14503 {

    static int N, M;
    static int [][] map;
    static boolean [][] visited;
    static int [][] direction = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };
    static Vec2 robot;
    static int robotDirection;

    static class Vec2{
        int x, y;
        public Vec2(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=1; testCase++){

            N = scn.nextInt();
            M = scn.nextInt();

            int r = scn.nextInt();
            int c = scn.nextInt();
            robot = new Vec2(c, r);
            robotDirection = scn.nextInt();

            map = new int[N+1][M+1];
            visited = new boolean[N+1][M+1];

            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    map[n][m] = scn.nextInt();
                }
            }

            Queue<Vec2> queue = new LinkedList<>();
            queue.add(robot);
            while(!queue.isEmpty()){
                Vec2 v = queue.remove();
                visited[v.y][v.x] = true;

                boolean isGo = false;
                for (int i=0; i<4; i++){
                    robotDirection = (robotDirection+3)%4;
                    int nx = v.x + direction[robotDirection][0];
                    int ny = v.y + direction[robotDirection][1];
                    if(0 <= nx && nx < M && 0 <= ny && ny < N){
                        if(!visited[ny][nx] && map[ny][nx] == 0){

                            Vec2 v2 = new Vec2(nx, ny);
                            robot = v2;
                            queue.add(v2);
                            isGo = true;
                            break;

                        }
                    }
                }

                if(!isGo){
                    int nx = v.x + direction[(robotDirection+2)%4][0];
                    int ny = v.y + direction[(robotDirection+2)%4][1];

                    if(0 <= nx && nx < M && 0 <= ny && ny < N) {
                        if (map[ny][nx] != 1) {
                            Vec2 v2 = new Vec2(nx, ny);
                            robot = v2;
                            queue.add(v2);
                        }
                    }
                }
            }

            int count = 0;
            for(int n=0; n<N; n++) {
                for (int m = 0; m < M; m++) {
                    if(visited[n][m])
                        count += 1;
                }
            }

            System.out.println(count);

        }

    }

}
