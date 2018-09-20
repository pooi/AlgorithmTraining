package training2.d4;

import java.util.Scanner;

public class P1218 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int tc=1; tc<=10; tc++){

            int N = scn.nextInt();
            String str = scn.next();

            CustomStack stack = new CustomStack(N+1);
            boolean isPossible = true;

            for(int i=0; i<str.length(); i++){
                String ch = str.charAt(i) + "";

                if("(".equals(ch) || "[".equals(ch) || "{".equals(ch) || "<".equals(ch)){
                    stack.push(ch);
                }else{
                    String pop = stack.pop();
                    switch (ch){
                        case ")":
                            isPossible = "(".equals(pop);
                            break;
                        case "]":
                            isPossible = "[".equals(pop);
                            break;
                        case "}":
                            isPossible = "{".equals(pop);
                            break;
                        case ">":
                            isPossible = "<".equals(pop);
                            break;
                    }
                }

                if(!isPossible)
                    break;

            }

            System.out.println(String.format("#%d %d", tc, (isPossible ? 1 : 0) ) );

        }

    }

    static class CustomStack{

        String [] list;
        int size;
        int top;

        public CustomStack(int size){
            this.size = size;
            this.list = new String[size];
            this.top = -1;
        }

        public void push(String ch){
            if(top >= size){
                return;
            }
            list[++top] = ch;
        }

        public String pop(){
            if(top < 0){
                return null;
            }
            return list[top--];
        }

        public String peek(){
            if(top < 0){
                return null;
            }
            return list[top];
        }

    }
}
