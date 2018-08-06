package baekjoon;

import java.util.Scanner;

public class P1074 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextInt();
        long r = scn.nextInt();
        long c = scn.nextInt();

        long size = (long)Math.pow(2, n) / 2;

        long x = c/2;
        long y= r/2;

        long start = 4*(x+(size*y));
        long modX = c%2;
        long modY = r%2;

        long value = start + modX + modY*2;
        System.out.println(value);
    }
}
