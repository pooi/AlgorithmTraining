package d2;

import java.util.Scanner;

public class P1970 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int[] bills = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        int step = scn.nextInt();

        for(int T=1; T<=step; T++){

            int price = scn.nextInt();

            System.out.println("#"+T);
            for(int i=0; i<bills.length; i++){
                System.out.print((price/bills[i]) + " ");
                price = price % bills[i];
            }
            System.out.println();

        }
    }
}
