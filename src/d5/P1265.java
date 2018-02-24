package d5;

import java.util.Scanner;

public class P1265 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){

            int A = scn.nextInt();
            int group = scn.nextInt();

            int N = A/group;
            int R = A%group;

            long mul = (long)Math.pow(N, group - R) * (long)Math.pow(N+1, R);

            System.out.println("#" + testCase + " " + mul);

        }
    }
}
