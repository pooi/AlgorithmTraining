package training2.d4;

import java.util.Scanner;

public class P3316_2 {

    public static String WORD = "ABCD";
    public static int [] numbers = {8, 4, 2, 1};
    public static int [][] binary;
    public static int [] counts;
    public static int [] list;
    public static long ans;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        binary = new int[4][15];
        counts = new int[4];

        for(int i=1; i<16; i++){

            for(int k=0; k<numbers.length; k++){
                if((numbers[k] & i) >= 1){
                    binary[k][counts[k]] = i;
                    counts[k] += 1;
                }
            }

        }

        int T = scn.nextInt();
        for(int tc=1; tc<=T; tc++){
            ans = 0;

            String line = scn.next();
            list = new int[line.length()];
            for(int i=0; i<line.length(); i++) {
                String word = line.charAt(i) + "";
                list[i] = WORD.indexOf(word);
            }

            DFS(0, 8);

            System.out.println("#" + tc +" " + ans);

        }


    }

    public static void DFS(int index, int pre){
        if(index >= list.length){
            ans = (ans + 1) % 1_000_000_007;
        }else{

            int [] f = binary[list[index]];
            int countF = counts[list[index]];

            for(int k=0; k<countF; k++){
                if((pre & f[k]) >= 1){
                    DFS(index+1, f[k]);
                }
            }
        }
    }


}
