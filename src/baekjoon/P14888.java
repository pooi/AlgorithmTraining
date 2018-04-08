package baekjoon;

import java.util.Scanner;

public class P14888 {
    static int N;
    static int [] num;
    static int [] oper = new int[4];
    static String operation = "+-*/";
    static long max = Integer.MIN_VALUE+1;
    static long min = Integer.MAX_VALUE-1;

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        N = scn.nextInt();
        num = new int[N];
        for(int i=0; i<N; i++){
            num[i] = scn.nextInt();
        }
        for(int i=0; i<4; i++){
            oper[i] = scn.nextInt();
        }

        search(num[0], 0);

        System.out.println(max);
        System.out.println(min);

    }

    static long search(long ans, int depth){

        if(depth >= N-1){
            max = Math.max(ans, max);
            min = Math.min(ans, min);
            return ans;
        }

        for(int op=0; op<4; op++){
            if(oper[op] > 0){
                long temp = calc(ans, num[depth+1], operation.charAt(op) + "");
                oper[op] -=1;
                search(temp, depth+1);
                oper[op] += 1;
            }
        }

        return 0;
    }

    static long calc(long a, long b, String op){
        if(op.equals("+")){
            a = a+b;
        }else if(op.equals("-")){
            a = a-b;
        }else if(op.equals("*")){
            a = a*b;
        }else{ // /
            if(a < 0){
                a = -(Math.abs(a)/b);
            }else{
                a = a/b;
            }
        }
        return a;
    }
}
