package d6;

import java.util.*;

public class P1257 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for(int testCase=1; testCase<=T; testCase++){

            int index = scn.nextInt();
            String str = scn.next();

            ArrayList<String> list = new ArrayList<>();
            ArrayList<String> tempList;

            int len = str.length();
            for(int i=1; i<=len; i++){
                tempList = new ArrayList<>();
                for(int j=0; j<len-(i-1); j++){
                    String s =str.substring(j, j+i);
                    if(!tempList.contains(s)) {
                        list.add(s);
                        tempList.add(s);
                    }
                }
            }

            Collections.sort(list);

            System.out.println(String.format("#%d %s", testCase, (index > list.size() ? "none" : list.get(index-1))));

        }

    }
}
