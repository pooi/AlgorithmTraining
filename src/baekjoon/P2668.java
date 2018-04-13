package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P2668 {
    static int N;
    static int [] map;
    static int [] visited;
    static ArrayList<Integer> ans;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        ans = new ArrayList<>();
        map = new int[N+1];
        visited = new int[N+1];
        for(int i=1; i<=N; i++){
            map[i] = scn.nextInt();
        }
        for(int i=1; i<=N; i++){
            if(visited[i] != 2){
                visited[i] = 1;
                dfs(map[i], i);
            }
        }

        for(int i=1; i<=N; i++){
            if(visited[i] == 2)
                ans.add(i);
        }

        System.out.println(ans.size());
        for(int a : ans){
            System.out.println(a);
        }
    }
    static void dfs(int index, int finishIndex){

        if(index == finishIndex){

            for(int i=1; i<=N; i++){
                if(visited[i] == 1)
                    visited[i] = 2;
            }

        }
        if(visited[index] > 0){
            for(int i=1; i<=N; i++){
                if(visited[i] == 1){
                    visited[i] = 0;
                }
            }
            return;
        }
        visited[index] = 1;
        dfs(map[index], finishIndex);

    }
}
