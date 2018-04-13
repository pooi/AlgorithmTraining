package baekjoon;

import java.util.Scanner;

public class P1012 {
    static int N, M, K;
    static int [][] map;
    static Vec [] list;
    static boolean [][] visited;
    static int count = 0;
    static int [][] DIRECTION = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            M = scn.nextInt();
            N = scn.nextInt();
            K = scn.nextInt();
            count = 0;
            map = new int[N][M];
            visited = new boolean[N][M];
            list = new Vec[K];
            for(int i=0; i<K; i++){
                int m = scn.nextInt();
                int n = scn.nextInt();
                list[i] = new Vec(m, n);
                map[n][m] = 1;
            }

            for(Vec v : list){
                if(dfs(v.x, v.y))
                    count += 1;
            }

            System.out.println(count);
        }
    }

    static boolean dfs(int x, int y){
        if(visited[y][x])
            return false;
        visited[y][x] = true;
        for(int i=0; i<DIRECTION.length; i++){
            int cx = x + DIRECTION[i][0];
            int cy = y + DIRECTION[i][1];
            if(0 <= cx && cx < M && 0 <= cy && cy < N && map[cy][cx] == 1){
                dfs(cx, cy);
            }
        }
        return true;
    }

    static class Vec{
        int x, y;
        public Vec(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
