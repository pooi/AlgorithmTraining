package d3;

import java.util.Scanner;

public class P3431 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int T =scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            int L = scn.nextInt();
            int U = scn.nextInt();
            int X = scn.nextInt();

            int ans = 0;
            if(L <= X && X <= U){
                ans = 0;
            }else if(X < L){
                ans = L - X;
            }else if(X > U){
                ans = -1;
            }

            System.out.println(String.format("#%d %d", testCase, ans));
        }
    }
}
