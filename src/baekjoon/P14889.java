package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class P14889 {

    static int N;
    static int [][] S;
    static int depth;
    static Stack<Integer> stack;
    static int min;

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        N = scn.nextInt();
        S = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                S[i][j] = scn.nextInt();
            }
        }

        min = Short.MAX_VALUE;
        depth = N/2;

        stack = new Stack<>();
        search(depth, 0);

        System.out.println(min);

    }

    static void search(int step, int v){
        if(step <= 0){

            boolean [] team = new boolean[N];
            for(int m : stack){
                team[m] = true;
            }

            ArrayList<Integer> aTeam = new ArrayList<>();
            ArrayList<Integer> bTeam = new ArrayList<>();

            for(int i=0; i<team.length; i++){
                if(team[i])
                    aTeam.add(i);
                else
                    bTeam.add(i);
            }

            int aScore = 0, bScore = 0;
            for(int i=0; i<aTeam.size(); i++){
                for(int j=0; j<aTeam.size(); j++){

                    int a = aTeam.get(i);
                    int b = aTeam.get(j);
                    aScore += S[a][b];

                    a = bTeam.get(i);
                    b = bTeam.get(j);
                    bScore += S[a][b];
                }
            }

            min = Math.min(min, Math.abs(aScore-bScore));

        }else{
            while(v < N-step) {
                stack.push(v);
                search(step - 1, v + 1);
                v+=1;
                stack.pop();
            }
        }
    }
}
