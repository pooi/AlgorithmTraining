package d4;

import java.util.Scanner;
import java.util.Stack;

public class P1224 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase = 1; testCase <= 10; testCase++){
            int len = scn.nextInt();
            String operation = scn.next();

            Stack<String> stack1 = new Stack<>();
            Stack<String> stack2 = new Stack<>();

            for(int i=0; i<operation.length(); i++){
                String str = operation.charAt(i) + "";
                if(str.equals("(")){
                    stack2.push(str);
                }else  if(str.equals(")")){
                    while (!stack2.empty()){
                        String s = stack2.pop();
                        if(s.equals("("))
                            break;
                        stack1.push(s);
                    }
                }else if(str.equals("+")){
                    while (!stack2.empty()){
                        String s = stack2.pop();
                        if(s.equals("(")) {
                            stack2.push("(");
                            break;
                        }
                        stack1.push(s);
                    }
                    stack2.push(str);
                }else if(str.equals("*")){
                    stack2.push(str);
                }else{
                    stack1.push(str);
                }
            }

            while(!stack2.empty())
                stack1.push(stack2.pop());

            Stack<String> newStack = new Stack<>();
            while (!stack1.empty()){
                newStack.push(stack1.pop());
            }

            stack1 = new Stack<>();
            while (!newStack.empty()){
                String str = newStack.pop();
                if(str.equals("+")){
                    String oper1 = stack1.pop();
                    String oper2 = stack1.pop();
                    String sum = (Integer.parseInt(oper1) + Integer.parseInt(oper2)) + "";
                    stack1.push(sum);
                }else if(str.equals("*")){
                    String oper1 = stack1.pop();
                    String oper2 = stack1.pop();
                    String mul = (Integer.parseInt(oper1) * Integer.parseInt(oper2)) + "";
                    stack1.push(mul);
                }else{
                    stack1.push(str);
                }
            }

            System.out.println(String.format("#%d %s", testCase, stack1.pop()));

        }

    }
}
