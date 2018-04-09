package baekjoon;

import java.util.Scanner;

public class P14501 {
    static class Schedule{
        int T, P;
        public Schedule(int T, int P){
            this.T = T;
            this.P = P;
        }
    }
    static int N;
    static Schedule [] list;
    static int max;
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        list = new Schedule[N];
        max = 0;
        for(int i=0; i<N; i++){
            list[i] = new Schedule(scn.nextInt(), scn.nextInt());
        }
        search(0, 0);

        System.out.println(max);
    }

    static void search(int depth, int value){
        if(depth >= N){
            if(value > max)
                max = value;
        }else{
            for(int i=depth; i<N; i++){
                if(i + list[i].T <= N){
                    search(i + list[i].T, value + list[i].P);
                }else{
                    search(i + list[i].T, value);
                }

            }
        }
    }
}
