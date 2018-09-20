package training2.d4;

import java.util.Scanner;

public class P1486 {

    public static int N, B;
    public static int [] H;
    public static boolean [] visited;
    public static int ans;

    public static void main(String [] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for(int tc=1; tc<=T; tc++){

            ans = Integer.MAX_VALUE-1;

            N = scn.nextInt();
            B = scn.nextInt();

            H = new int[N];
            visited = new boolean[N];
            for(int i=0; i<N; i++){
                H[i] = scn.nextInt();
            }

            DFS(0, 0);

            System.out.println(String.format("#%d %d", tc, ans-B));

        }

    }

    public static void DFS(int sum, int index){

        if(sum > ans){
            return;
        }

        if(sum >= B){
            ans = Math.min(sum, ans);
        }

        for(int i=index; i<N; i++){
            if(!visited[i]){
                sum += H[i];
                visited[i] = true;
                DFS(sum, i+1);
                visited[i] = false;
                sum -= H[i];
            }
        }

    }


}
