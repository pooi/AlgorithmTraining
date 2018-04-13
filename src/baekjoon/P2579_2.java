package baekjoon;

import java.util.Scanner;

public class P2579_2 {
    static int N;
    static int [] step;
    static int [] values;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        step = new int[N+1];
        values = new int[N+1];
        for(int i=1; i<=N; i++){
            step[i] = scn.nextInt();
        }
        values[1] = step[1];
        values[2] = step[2] + step[1];
        for (int i = 3; i <= N; i++) {
            values[i] = Math.max(values[i-2] + step[i], values[i-3] + step[i-1] + step[i]);
        }
        System.out.println(values[N]);
    }
}
