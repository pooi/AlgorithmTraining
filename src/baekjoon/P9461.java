package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class P9461 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        BigInteger[] P = new BigInteger[101];
        P[0] = BigInteger.ZERO;
        P[1] = BigInteger.ONE;
        P[2] = BigInteger.ONE;
        for(int i=3; i<=100; i++){
            P[i] = P[i-3].add(P[i-2]);
        }

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            int n = scn.nextInt();
            System.out.println(P[n]);
        }
    }
}
