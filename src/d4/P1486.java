package d4;

import java.util.Scanner;

public class P1486 {

    static int N, B;
    static int [] H;
    static boolean [] visited;

    static int tempAns;
    static int ans;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for(int testCase=1; testCase<=T; testCase++){

            N = scn.nextInt();
            B = scn.nextInt();

            H = new int[N];
            visited = new boolean[N];

            tempAns = H[0];
            ans = Integer.MAX_VALUE;

            for(int i=0; i<N; i++){
                H[i] = scn.nextInt();
            }

            DFS(0, 0);

            System.out.println(String.format("#%d %d", testCase, ans-B));

        }

    }

    public static void DFS(int sum, int index){

        if(sum > ans){
            return;
        }

        if(sum >= B){
            if(sum < ans){

                ans = sum;

            }
            return;
        }

        for(int i=index; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                sum += H[i];
                DFS(sum, i+1);
                sum -= H[i];
                visited[i] = false;
            }
        }

    }

}
