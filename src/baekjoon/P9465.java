package baekjoon;

import java.util.Scanner;

public class P9465 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            int M = scn.nextInt();
            int [][] map = new int[2][M];
            for(int i=0; i<2; i++){
                for(int j=0; j<M; j++){
                    map[i][j] = scn.nextInt();
                }
            }
            for(int i=0; i<M; i++){
                map[0][i] = Math.max(i-1 < 0 ? 0 : map[1][i-1], i-2 < 0 ? 0 : map[1][i-2]) + map[0][i];
                map[1][i] = Math.max(i-1 < 0 ? 0 : map[0][i-1], i-2 < 0 ? 0 : map[0][i-2]) + map[1][i];
            }
            System.out.println(Math.max(map[0][M-1], map[1][M-1]));
        }
    }
}
