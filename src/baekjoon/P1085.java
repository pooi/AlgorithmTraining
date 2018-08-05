package baekjoon;

import java.util.Scanner;

public class P1085 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int y = scn.nextInt();
        int w = scn.nextInt();
        int h = scn.nextInt();

        int left = x;
        int right = w-x;
        int top = y;
        int bottom = h-y;

        System.out.println(Math.min(Math.min(left, right), Math.min(top, bottom)));
    }
}
