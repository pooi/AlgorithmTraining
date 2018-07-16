package d4;

import java.util.Scanner;

public class P3347 {

    public static int N, M;
    public static int [] A, B;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){

            N = scn.nextInt(); M = scn.nextInt();
            A = new int[N];
            B = new int[M];

            for(int i=0; i<N; i++)
                A[i] = scn.nextInt();

            for(int i=0; i<M; i++)
                B[i] = scn.nextInt();

            int [] count = new int[N];
            int [] hash = new int[1002];
            for(int i=0; i<1001; i++)
                hash[i] = 1001;

            for(int i=0; i<N; i++){
                int a = A[i];
                if(i < hash[a]){
                    for(int j=a; j<1001; j++){
                        if(hash[j] < i){
                            break;
                        }else{
                            hash[j] = i;
                        }
                    }
                }
            }

            for(int i=0; i<M; i++){
                count[hash[B[i]]] += 1;
            }

            int max = 0;
            int pos = 0;
            for(int i=0; i<N; i++){
                if(count[i] > max){
                    max = count[i];
                    pos = i;
                }
            }

            System.out.println(String.format("#%d %d", testCase, pos+1));


        }


    }

}
