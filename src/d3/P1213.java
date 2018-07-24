package d3;

import java.util.Scanner;

public class P1213 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        for(int testCase=1; testCase<=10; testCase++){
            int T= scn.nextInt();
            String s = scn.next();
            String str = scn.next();
            String str2 = str.replaceAll(s, "");
            int diff = str.length() - str2.length();
            int l = diff / s.length();
            System.out.println("#" + T + " " + (l));
        }
    }
}
