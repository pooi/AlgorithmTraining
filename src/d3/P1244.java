package d3;

import java.util.Scanner;

public class P1244 {

    public static int MAX = 0;
    public static int count = 0;
    public static boolean[][] flag;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for(int testCase=1; testCase<=T; testCase++){

            String str = scn.next();
            count = scn.nextInt();

            MAX = 0;
            flag = new boolean[count+1][1000000];

            DFS(str, 0);

            System.out.println("#" + testCase + " " + MAX);

        }

    }

    public static void DFS(String str, int depth){

        flag[depth][Integer.parseInt(str)] = true;
        if(depth == count){
            if(Integer.parseInt(str) > MAX){
                MAX = Integer.parseInt(str);
            }
            return;
        }


        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){

                String temp = str.substring(0, i) + str.charAt(j) + str.substring(i+1, j) + str.charAt(i) + str.substring(j+1, str.length());
                if(!flag[depth+1][Integer.parseInt(temp)])
                    DFS(temp, depth+1);

            }
        }

    }



}
