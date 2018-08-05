package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P1032 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(scn.next());
        }
        int [] count = new int[list.get(0).length()];

        ArrayList<String> temp = new ArrayList<>();
        for(int i=0; i<count.length; i++){
            temp.clear();
            for(String s : list){
                String word = s.charAt(i) + "";
                if(!temp.contains(word)){
                    temp.add(word);
                }
            }
            count[i] = temp.size();
        }

        String std = list.get(0);
        for(int i=0; i<count.length; i++){
            if(count[i] > 1) {
                System.out.print("?");
            }else{
                System.out.print(std.charAt(i) + "");
            }
        }
        System.out.println();
    }
}
