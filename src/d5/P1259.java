package d5;

import java.util.ArrayList;
import java.util.Scanner;

public class P1259 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){

            int N = scn.nextInt();
            int []map = new int[100001];

            int max = -1;
            for(int i=0; i<N; i++){
                int pre = scn.nextInt();
                int post = scn.nextInt();

                map[pre] = post;
                if(max < pre) max = pre;
            }

            ArrayList<Integer> temp;
            ArrayList<Integer> ans = null;
            for(int j=max; j>=0; j--){
                if(map[j] != 0){

                    temp = new ArrayList<>();
                    int st = j;
                    while(map[st] != 0){
                        temp.add(st);
                        temp.add(map[st]);
                        st = map[st];
                    }

                    if(ans == null || temp.size() > ans.size()){
                        ans = (ArrayList<Integer>)temp.clone();
                    }

                }
            }

            System.out.print("#" + testCase + " ");
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
