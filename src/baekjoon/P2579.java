package baekjoon;

import java.util.Scanner;

public class P2579 {
    static int N;
    static int [][] step;
    static int [] values;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        step = new int[N+1][N+1];
        values = new int[N];
        for(int i=1; i<=N; i++){
            step[i][0] = scn.nextInt();
        }
        if(N >=2) {
            step[2][1] = step[1][0] + step[2][0];
            for (int i = 3; i <= N; i++) {
                step[i][i - 1] = step[i - 1][i - 3] + step[i][0];
                step[i][i - 2] = Math.max(step[i - 2][i - 3], (i - 4 >= 0 ? step[i - 2][i - 4] : 0)) + step[i][0];
            }
            System.out.println(Math.max(step[N][N - 1], step[N][N - 2]));
        }else{
            System.out.println(step[1][0]);
        }
    }
}
