package d3;

import java.util.Scanner;
import java.util.Stack;

public class P1234 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int T = 10;
        for (int testCase = 1; testCase <= T; testCase++) {
            int len = scn.nextInt();
            String str = scn.next();

            Stack<String> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                String s = str.charAt(i) + "";
                if (stack.empty()) {
                    stack.push(s);
                } else {
                    String temp = stack.pop();
                    if(!temp.equals(s)){
                        stack.push(temp);
                        stack.push(s);
                    }
                }
            }

            String ans = "";
            while(!stack.empty()){
                String pop = stack.pop();
                ans = pop + ans;
            }
            System.out.println(String.format("#%d %s", testCase, ans));
        }

    }
}
