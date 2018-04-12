package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P2533 {
    static int N;
    static Tree [] tree;
    static boolean [] visited;
    static int [][] dp;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        tree = new Tree[N+2];
        visited = new boolean[N+2];
        dp = new int[N+2][2];
        for(int i=0; i<N-1; i++){
            int parentIndex = scn.nextInt();
            int childIndex = scn.nextInt();
            if(tree[parentIndex] == null)
                tree[parentIndex] = new Tree();
            if(tree[childIndex] == null)
                tree[childIndex] = new Tree();
            tree[parentIndex].tree.add(childIndex);
            tree[childIndex].tree.add(parentIndex);
        }

        search(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void search(int pos){

        visited[pos] = true;

        dp[pos][1] += 1;

        for(int child : tree[pos].tree){
            if(!visited[child]){

                search(child);

                dp[pos][0] += dp[child][1];
                dp[pos][1] += Math.min(dp[child][0], dp[child][1]);

            }
        }

    }

    static class Tree{
        ArrayList<Integer> tree;
        public Tree(){
            tree = new ArrayList<>();
        }
    }
}
