package baekjoon;

import java.util.Scanner;

public class P9205 {
    static int N;
    static Vec2[] list;
    static Vec2 HOME;
    static Vec2 FES;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            N = scn.nextInt();
            list = new Vec2[N];
            HOME = new Vec2(scn.nextInt(), scn.nextInt());
            for(int i=0; i<N; i++){
                list[i] = new Vec2(scn.nextInt(), scn.nextInt());
            }
            FES = new Vec2(scn.nextInt(), scn.nextInt());

            if(HOME.getDistance(FES) <= 1000){
                System.out.println("happy");
            }else{
                boolean result = dfs(HOME, 0, new boolean[N]);
                System.out.println(result ? "happy" : "sad");
            }
        }
    }

    static boolean dfs(Vec2 pre, int index, boolean [] visited){
        if(index >= N){
            return false;
        }
        if(pre.getDistance(list[index]) > 1000){
            return false;
        }
        if(FES.getDistance(list[index]) <= 1000){
            return true;
        }
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[index] = true;
                if(dfs(list[index], i, visited)){
                    return true;
                }
                visited[index] = false;
            }
        }
        return false;
    }

    static class Vec2{
        int x, y;
        public Vec2(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getDistance(Vec2 v2){
            Vec2 v1 = this;
            return Math.abs(v1.x-v2.x) + Math.abs(v1.y - v2.y);
        }
    }
}
