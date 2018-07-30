package d4;

import java.util.Scanner;

public class P4613 {
    public static final int W = 0;
    public static final int B = 1;
    public static final int R = 2;
    static int N, M;
    static int [][] map;
    static int MIN;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int tc=1; tc<=T; tc++){
            N = scn.nextInt();
            M = scn.nextInt();
            MIN = Integer.MAX_VALUE-1;
            map = new int[N][M];
            for(int i=0; i<N; i++){
                String str = scn.next();
                for(int j=0; j<str.length(); j++){
                    String ch = str.charAt(j) + "";
                    switch(ch){
                        case "W":
                            map[i][j] = W;
                            break;
                        case "B":
                            map[i][j] = B;
                            break;
                        case "R":
                            map[i][j] = R;
                            break;
                    }
                }
            }

            for(int i=0; i<N-2; i++){
                for(int j=i+1; j<N-1; j++){
                    DFS(i, j);
                }
            }

            System.out.println(String.format("#%d %d", tc, MIN));

        }


    }

    public static void DFS(int a, int b){
        int temp = 0;
        for(int i=0; i<=a; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != W){
                    temp += 1;
                }
            }
            if(temp > MIN)
                return;
        }

        for(int i=a+1; i<=b; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != B){
                    temp += 1;
                }
            }
            if(temp > MIN)
                return;
        }

        for(int i=b+1; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != R){
                    temp += 1;
                }
            }
            if(temp > MIN)
                return;
        }

        if(temp < MIN)
            MIN = temp;
    }

}

