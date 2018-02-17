package d4;

import java.util.Scanner;
import java.util.Stack;

public class P1218 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase = 1; testCase <= 10; testCase++){

            int count = scn.nextInt();
            String tmp = scn.next();

            boolean isPossible = true;
            Stack<String> stack = new Stack<>();
            for(int i=0; i<count; i++){
                String str = tmp.charAt(i) + "";
                if(str.equals("(") || str.equals("<") || str.equals("{") || str.equals("[")){
                    stack.push(str);
                }else{
                    String compareStr = stack.pop();
                    switch (compareStr){
                        case "(":
                            isPossible = str.equals(")");
                            break;
                        case "{":
                            isPossible = str.equals("}");
                            break;
                        case "[":
                            isPossible = str.equals("]");
                            break;
                        case "<":
                            isPossible = str.equals(">");
                            break;
                        default:
                            isPossible = false;
                            break;
                    }
                }
                if(!isPossible)
                    break;
            }
            System.out.println("#" + testCase + " " + (isPossible ? "1" : "0"));

        }

    }

}
