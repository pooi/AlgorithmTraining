package baekjoon;

import java.math.BigInteger;
import java.util.Scanner;

public class P13458 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int [] list = new int[N];
        for(int i=0; i<N; i++){
            list[i] = scn.nextInt();
        }
        int B = scn.nextInt();
        int C = scn.nextInt();

        BigInteger count = BigInteger.ZERO;
        for(int i=0; i<N; i++){
            int num = list[i];
            num = num - B;
            if(num > 0){
                int numOfC;
                if(num % C == 0){
                    numOfC = (int) Math.round(((double) num / C));
                }else {
                    numOfC = (int) Math.round(((double) num / C) + 0.5);
                }
                count = count.add(BigInteger.valueOf(numOfC));
            }
            count = count.add(BigInteger.ONE);
        }
        System.out.println(count.toString());
    }
}
