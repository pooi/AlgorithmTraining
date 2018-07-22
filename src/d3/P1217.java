package d3;

import java.util.Scanner;

public class P1217 {
    static int a, b;
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        for(int testCase=1; testCase<=10; testCase++){
            int T = scn.nextInt();
            a = scn.nextInt();
            b = scn.nextInt();
            int value = calc(a, b);
            System.out.println(String.format("#%d %d", T, value));
        }
    }

    public static int calc(int a, int b){
        if(b < 1){
            return 1;
        }else{
            return a * calc(a, b-1);
        }
    }
}
