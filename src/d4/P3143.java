package d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3143 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            String A = scn.next();
            String B = scn.next();
            int count = 0;
            Queue<String> queue = new LinkedList<>();
            for(int i=0; i<A.length(); i++){
                queue.add(A.charAt(i) + "");
            }
            String temp = "";
            while(!queue.isEmpty()){
                while(temp.length() < B.length()){
                    if(!queue.isEmpty()){
                        temp += queue.remove();
                    }else{
                        break;
                    }
                }
                if(temp.equals(B)){
                    temp = "";
                    count += 1;
                }else{
                    if(temp.length() >= B.length()){
                        temp = temp.substring(1, temp.length());
                        count += 1;
                    }
                }
            }
            count += temp.length();
            System.out.println(String.format("#%d %d", testCase, count));
        }
    }
}
