package d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1249_3 {

    static int [][] map;
    static int [][] dist;
    static int [][] direction = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };
    static class Vec2{
        int x, y, len;
        public Vec2(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){

            int N = scn.nextInt();
            map = new int[N+1][N+1];
            dist = new int[N+1][N+1];

            for(int i=0; i<N; i++){
                String str = scn.next();
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(str.charAt(j) + "");
                    dist[i][j] = Short.MAX_VALUE;
                }
            }

            Queue<Vec2> queue = new LinkedList<>();
            queue.add(new Vec2(0, 0, 0));
            dist[0][0] = 0;
            while(!queue.isEmpty()){
                Vec2 v = queue.remove();

                for(int i=0; i<direction.length; i++){

                    int nx = v.x + direction[i][0];
                    int ny = v.y + direction[i][1];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N){
                        continue;
                    }
                    int len = v.len + map[ny][nx];

                    if(len < dist[ny][nx]){
                        dist[ny][nx] = len;
                        queue.add(new Vec2(nx, ny, len));
                    }

                }
            }

            System.out.println(String.format("#%d %d", testCase, dist[N-1][N-1]));


        }

    }
}
