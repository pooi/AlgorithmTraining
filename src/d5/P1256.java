package d5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1256 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            int num = scn.nextInt();
            String str = scn.next();
            ArrayList<String> list = new ArrayList<>();
            for(int i=0; i<str.length(); i++){
                list.add(str.substring(i, str.length()));
            }
            Collections.sort(list);
            System.out.println("#" + testCase + " " + list.get(num-1));
        }

    }
}
