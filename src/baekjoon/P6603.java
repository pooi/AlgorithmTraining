package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class P6603 {
    static int N;
    static int [] map;
    static Stack<Integer> stack;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while(true){
            N = scn.nextInt();
            if(N == 0)
                break;
            map = new int[N];
            for(int i=0; i<N; i++){
                map[i] = scn.nextInt();
            }
            stack = new Stack<>();
            dfs(5, 0);
            System.out.println();
        }
    }
    static void dfs(int depth, int index){
        if(depth < 0){
            for(int s : stack){
                System.out.print(s + " ");
            }
            System.out.println();
            return;
        }else{
            for(int i=index; i<N-depth; i++){
                stack.push(map[i]);
                dfs(depth-1, i+1);
                stack.pop();
            }
        }
    }
}
