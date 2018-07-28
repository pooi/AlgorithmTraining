package d3;

import java.util.Scanner;

public class P3142 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int tc=1; tc<=T; tc++){
            int N = scn.nextInt();
            int M= scn.nextInt();
            int a = N-M;
            int b = M-a;
            System.out.println(String.format("#%d %d %d", tc, b, a));
        }
    }
}
