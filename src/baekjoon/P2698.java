package baekjoon;

import java.util.Scanner;

public class P2698 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int [][][] dp = new int[101][100][2];

        dp[1][0][0] = 1;
        dp[1][0][1] = 1;

        for(int n=2; n<=100; n++){
            for(int k=0; k<n; k++){

                dp[n][k][0] += dp[n-1][k][0] + dp[n-1][k][1];
                if(k-1 < 0)
                    dp[n][k][1] += dp[n-1][k][0];
                else
                    dp[n][k][1] += dp[n-1][k][0] + dp[n-1][k-1][1];

            }
        }

        int T = scn.nextInt();
        for(int i=0; i<T; i++){
            int n = scn.nextInt();
            int k = scn.nextInt();
            System.out.println(dp[n][k][0] + dp[n][k][1]);
        }

    }
}
