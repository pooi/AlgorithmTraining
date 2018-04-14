package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9205_2 {
    static int N;
    static Vec2[] list;
    static int MAX = 102;
    static int [][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int testCase=1; testCase<=T; testCase++){
            N = Integer.parseInt(br.readLine());
            list = new Vec2[N+2];
            for(int i=0; i<=N+1; i++){
                st = new StringTokenizer(br.readLine());
                list[i] = new Vec2(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            d = new int[MAX][MAX];
            for(int i=0; i<MAX; i++){
                for(int j=0; j<MAX; j++){
                    if(i != j)
                        d[i][j] = MAX;
                }
            }

            int n = N+2;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(i!=j){
                        Vec2 v1 = list[i];
                        Vec2 v2 = list[j];

                        if(v1.getDistance(v2) <= 1000)
                            d[i][j] = 1;
                    }
                }
            }

            for(int k=0; k<n; k++){
                for(int i=0; i<n; i++) {
                    for (int j = 0; j < n; j++) {
                        if(d[i][j] > d[i][k] + d[k][j]){
                            d[i][j] = d[i][k] + d[k][j];
                        }
                    }
                }
            }

            if(0 < d[0][N+1] && d[0][N+1] < MAX){
                System.out.println("happy");
            }else{
                System.out.println("sad");
            }
        }
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
