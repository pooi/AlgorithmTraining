package d4;

import java.util.Scanner;

public class P1861 {

    static int N;
    static int [][] map;
    static boolean [][] visit;
    static int [][] move = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };
    static int minPos, ans, pos;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            N = scn.nextInt();
            minPos = N*N+1;
            map = new int[N][N];
            visit = new boolean[N][N];
            ans = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = scn.nextInt();
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    pos = map[i][j];
                    DFS(i, j, 1);
                }
            }

            System.out.println(String.format("#%d %d %d", testCase, minPos, ans));

        }

    }

    static void DFS(int i, int j, int m){
        if(m > ans){
            ans = m;
            minPos = pos;
        }else if(m == ans){
            minPos = Math.min(minPos, pos);
        }

        int item = map[i][j];
        visit[i][j] = true;
        for(int k=0; k<move.length; k++){
            int moveI = i + move[k][0];
            int moveJ = j + move[k][1];

            if(0 <= moveI && moveI < N && 0 <= moveJ && moveJ < N && !visit[moveI][moveJ] && item+1 == map[moveI][moveJ]){
                DFS(moveI, moveJ, m+1);
            }
        }
        visit[i][j] = false;

    }
}
