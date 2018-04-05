package d5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1248_2 {

    static class MyTree{
        int parent = -1;
        int left = -1, right = -1;
        public void addChild(int num){
            if(left < 0)
                left = num;
            else
                right = num;
        }
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){

            int V = scn.nextInt();
            int E = scn.nextInt();
            int num1 = scn.nextInt();
            int num2 = scn.nextInt();

            MyTree [] map = new MyTree[V+1];
            for(int i=0; i<map.length; i++){
                map[i] = new MyTree();
            }

            for(int i=0; i<E; i++){
                int pa = scn.nextInt();
                int ch = scn.nextInt();

                map[pa].addChild(ch);
                map[ch].parent = pa;
            }

            boolean [] parents1 = new boolean[V+1];
            boolean [] parents2 = new boolean[V+1];
//            ArrayList<Integer> parents1 = new ArrayList<>();
//            ArrayList<Integer> parents2 = new ArrayList<>();

            MyTree temp = map[num1];
            while(temp.parent > 0){
                parents1[temp.parent] = true;
//                parents1.add(temp.parent);
                temp = map[temp.parent];
            }

            temp = map[num2];
            while(temp.parent > 0){
                parents2[temp.parent] = true;
//                parents2.add(temp.parent);
                temp = map[temp.parent];
            }

            int max = 0;
            for(int i=parents1.length-1; i>=0; i--){
                if(parents1[i] && parents2[i]){
                    max = i;
                    break;
                }
            }

            System.out.println(String.format("#%d %d", testCase, max));

        }

    }
}
