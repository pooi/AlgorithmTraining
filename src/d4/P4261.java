package d4;

import java.util.HashMap;
import java.util.Scanner;

public class P4261 {

    public static void main(String[] args){

        HashMap<String, String>  map = new HashMap<>();
        map.put("a", "2");
        map.put("b", "2");
        map.put("c", "2");
        map.put("d", "3");
        map.put("e", "3");
        map.put("f", "3");
        map.put("g", "4");
        map.put("h", "4");
        map.put("i", "4");
        map.put("j", "5");
        map.put("k", "5");
        map.put("l", "5");
        map.put("m", "6");
        map.put("n", "6");
        map.put("o", "6");
        map.put("p", "7");
        map.put("q", "7");
        map.put("r", "7");
        map.put("s", "7");
        map.put("t", "8");
        map.put("u", "8");
        map.put("v", "8");
        map.put("w", "9");
        map.put("x", "9");
        map.put("y", "9");
        map.put("z", "9");

        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            String S = scn.next();
            int N = scn.nextInt();

            String [] texts = new String[N];
            for(int i=0; i<N; i++){
                texts[i] = scn.next();
            }

            int count = 0;
            for(String text : texts){
                String ans = "";
                for(int i=0; i<text.length(); i++){
                    String a = text.charAt(i) + "";
                    ans += map.get(a);
                }
                if(S.equals(ans))
                    count += 1;
            }

            System.out.println(String.format("#%d %d", testCase, count));
        }
    }
}
