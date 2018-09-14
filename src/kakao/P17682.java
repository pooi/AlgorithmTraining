package kakao;

import java.util.Stack;

public class P17682 {

    public static void main(String[] args){
        String [] dartResults = {
                "1S2D*3T",
                "1D2S#10S",
                "1D2S0T",
                "1S*2T*3S",
                "1D#2S*3S",
                "1T2D3D#",
                "1D2S3T*"
        };
        for(String dartResult : dartResults){
            System.out.println(solution(dartResult));
        }
    }

    public static int solution(String dartResult) {

        String NUM = "0123456789";
        String SDT = "SDT";
        String OPT = "*#";

        Stack<Integer> stack = new Stack<>();
        for(int idx=0; idx < dartResult.length(); idx++){

            String ch = dartResult.charAt(idx) + "";
            if(NUM.contains(ch)){

                String ch2 = dartResult.charAt(idx+1) + "";
                if(NUM.contains(ch2)){
                    ch += ch2;
                    idx += 1;
                }

                stack.push(Integer.parseInt(ch));

            }else if(SDT.contains(ch)){

                int num = stack.pop();
                switch (ch){
                    case "S":
                        num = (int)Math.pow(num, 1);
                        break;
                    case "D":
                        num = (int)Math.pow(num, 2);
                        break;
                    case "T":
                        num = (int)Math.pow(num, 3);
                        break;
                }
                stack.push(num);

            }else if(OPT.contains(ch)){

                switch (ch){
                    case "*": {
                        int count = 0;
                        Stack<Integer> tempStack = new Stack<>();
                        while(!stack.empty()){
                            if(count >= 2){
                                break;
                            }
                            int num = stack.pop();
                            num *= 2;
                            tempStack.push(num);
                            count++;
                        }
                        while(!tempStack.empty()){
                            stack.push(tempStack.pop());
                        }
                        break;
                    }
                    case "#": {
                        int num = stack.pop();
                        num *= -1;
                        stack.push(num);
                        break;
                    }
                }

            }

        }

        int answer = 0;
        while(!stack.empty()){
            answer += stack.pop();
        }

        return answer;
    }

}
