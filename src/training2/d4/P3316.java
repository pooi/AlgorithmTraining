package training2.d4;

import java.util.Scanner;

public class P3316 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        String words = "ABCD";
        int [] numbers = {8, 4, 2, 1};
        int [][] binary = new int[4][15];
        int [] counts = new int[4];

        for(int i=1; i<16; i++){

            for(int k=0; k<numbers.length; k++){
                if((numbers[k] & i) >= 1){
                    binary[k][counts[k]] = i;
                    counts[k] += 1;
                }
            }

        }

        System.out.println(3&8);

//        long te = 629756071;
//        long te2 = 8;
//        long temp = (te * te2) % 1_000_000_007;
//        System.out.println(temp);

        int T = scn.nextInt();
        for(int tc=1; tc<=T; tc++){
            long ans = 1;
            String line = scn.next();
            for(int i=0; i<line.length()-1; i++){

                long num = 0;

                int addition = 15;
                if(i == 0)
                    addition = 8;

                String first = line.charAt(i) + "";
                String second = line.charAt(i+1) + "";

                int [] f = binary[words.indexOf(first)];
                int countF = counts[words.indexOf(first)];
                int [] s = binary[words.indexOf(second)];
                int countS = counts[words.indexOf(second)];

                for(int k=0; k<countF; k++){
                    for(int g=0; g<countS; g++){
                        if ( ((f[k] & addition) >= 1) && (( f[k] & s[g] ) >= 1) ) {
//                            System.out.println(f[k] + "/" + s[g]);
                            num += 1;
                        }
                    }
                }

                System.out.println(num);
                ans = (ans * num) % 1_000_000_007;
            }
            System.out.println("#" + tc + " " + ans);
        }


    }

}
