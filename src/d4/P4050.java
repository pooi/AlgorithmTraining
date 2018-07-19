package d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class P4050 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            int N = scn.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<N; i++){
                list.add(scn.nextInt());
            }
            Collections.sort(list);
            for(int i : list){
                stack.push(i);
            }
            list.clear();

            int total = 0;
            int step = 0;
            while(!stack.empty()){
                int pop = stack.pop();
                step += 1;
                if(step % 3 != 0){
                    total += pop;
                }
            }
            System.out.println(String.format("#%d %d", testCase, total));
        }
    }
}
