package d3;

import java.util.ArrayList;
import java.util.Scanner;

public class P1225 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int []arr = {-1,-2,-3,-4,-5};

        for(int testCase=1; testCase<=10; testCase++){

            int T = scn.nextInt();

            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<8; i++){
                list.add(scn.nextInt());
            }

            int count = 0;
            while(true){
                int pop = list.get(0);
                list.remove(0);
                pop = Math.max(0, pop + arr[count%arr.length]);
                list.add(pop);
                if(pop <= 0){
                    break;
                }
                count += 1;
            }

            System.out.print("#" + testCase + " ");
            for(int value : list){
                System.out.print(value + " ");
            }
            System.out.println();

        }

    }
}
