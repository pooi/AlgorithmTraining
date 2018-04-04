package d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1225_2 {

    static int [] values = {
            -1, -2, -3, -4, -5
    };

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int T = 10;
        for(int testCase=1; testCase<=T; testCase++){
            int num = scn.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<8; i++){
                queue.add(scn.nextInt());
            }

            int index = 0;
            while(true){
                int c = queue.remove();
                c += values[index];
                if(c <= 0){
                    queue.add(0);
                    break;
                }
                queue.add(c);
                index = (index + 1) % values.length;
            }

            System.out.print("#" + testCase + " ");
            while (!queue.isEmpty()){
                System.out.print(queue.remove() + " ");
            }
            System.out.println();

        }
    }
}
