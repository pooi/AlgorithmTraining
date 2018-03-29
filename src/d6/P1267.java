package d6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1267 {

    static int [][] graph;
    static boolean [] flag;
    static int V, E;
    static Queue<Integer> queue;
    static ArrayList<Integer> ans;

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=10; testCase++){

            V = scn.nextInt();
            E = scn.nextInt();

            graph = new int[V+1][V+1];
            flag = new boolean[V+1];
            queue = new LinkedList<>();
            ans = new ArrayList<>();

            for(int i=0; i<E; i++){
                int a = scn.nextInt();
                int b = scn.nextInt();
                graph[a][b] = 1;
            }

            search();

            System.out.print("#" + testCase + " ");
            for(int v : ans){
                System.out.print(v + " ");
            }
            System.out.println();

        }

    }

    static void search(){

        for(int i=1; i<=V; i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            int v = queue.remove();
            if(flag[v])
                continue;

            boolean isFinish = true;
            for(int i=0; i<=V; i++){
                if(flag[i])
                    continue;
                if(graph[i][v] == 1 && !flag[i]){
                    isFinish = false;
                    break;
                }
            }
            if(isFinish){
                flag[v] = true;
                ans.add(v);
            }else{
                queue.add(v);
            }


        }
    }
}
