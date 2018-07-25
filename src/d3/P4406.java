package d3;

import java.util.Scanner;

public class P4406 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        String [] vowel = {"a", "e", "i", "o", "u"};
        for(int tc=1; tc<=T; tc++){
            String str = scn.next();
            for(String v : vowel){
                str = str.replaceAll(v, "");
            }
            System.out.println("#" + tc + " " + str);
        }
    }
}
