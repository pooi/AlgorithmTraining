package training2.etc;

import java.util.Scanner;

public class P1949 {

    static int [][] DIRECTION = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };

    static int N, K;
    static int [][] map;
    static boolean [][] visited;
    static boolean isK;
    static int ans;

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int tc=1; tc<=T; tc++){
            N = scn.nextInt();
            K = scn.nextInt();
            isK = false;
            ans = 0;

            map = new int[N][N];
            visited = new boolean[N][N];

            int max = 0;

            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    int value = scn.nextInt();
                    map[y][x] = value;
                    if(value > max)
                        max = value;
                }
            }

            Vec2 [] startPoints = new Vec2[5];
            int numOfSP = 0;

            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    if(map[y][x] == max){
                        startPoints[numOfSP++] = new Vec2(x, y);
                    }
                }
            }

            for(int i=0; i<numOfSP; i++){
                visited[startPoints[i].y][startPoints[i].x] = true;
                DFS(1, startPoints[i]);
                visited[startPoints[i].y][startPoints[i].x] = false;
            }

            System.out.println(String.format("#%d %d", tc, ans));

        }
    }

    public static void DFS(int sum, Vec2 pos){
        if(sum > ans){
            ans = sum;
        }

        for(int i=0; i<DIRECTION.length; i++){
            int dx = pos.x + DIRECTION[i][0];
            int dy = pos.y + DIRECTION[i][1];

            if(0 <= dx && dx < N && 0 <= dy && dy < N){
                int value = map[pos.y][pos.x];
                int dValue = map[dy][dx];
                if(!visited[dy][dx]){
                    if(dValue < value) {
                        visited[dy][dx] = true;
                        DFS(sum + 1, new Vec2(dx, dy));
                        visited[dy][dx] = false;
                    }else{
                        if(!isK) {
                            int diff = dValue - value + 1;
                            if (diff <= K) {
                                isK = true;
                                map[dy][dx] -= diff;
                                visited[dy][dx] = true;
                                DFS(sum + 1, new Vec2(dx, dy));
                                visited[dy][dx] = false;
                                map[dy][dx] += diff;
                                isK = false;
                            }
                        }
                    }
                }
            }
        }

    }

    static class Vec2{
        int x, y;
        public Vec2(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
