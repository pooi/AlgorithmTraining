package d2;

import java.util.ArrayList;
import java.util.Scanner;

public class P1946 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int width = 10;

        int step = scn.nextInt();
        for(int T=1; T<=step; T++){

            int line = scn.nextInt();
            ArrayList<String> list = new ArrayList<>();

            for(int k=0; k<line; k++){
                String chr = scn.next();
                chr.replaceAll(" ", "");
                int num = scn.nextInt();

                for(int i=0; i<num; i++){
                    list.add(chr);
                }
            }

            System.out.print("#" + T);
            for(int i=0; i<list.size(); i++){
                if(i % width == 0){
                    System.out.println();
                }
                System.out.print(list.get(i));
            }
            System.out.println();

        }
    }
}