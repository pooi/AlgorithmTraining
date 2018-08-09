package d3;

import java.util.Scanner;

public class P1206 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++){
            int width = scn.nextInt();
            int [] map = new int[width];
            for(int i=0; i<width; i++){
                map[i] = scn.nextInt();
            }

            int sum = 0;
            for(int i=2; i<width-2; i++){
                int left = Math.max(map[i-2], map[i-1]);
                int right = Math.max(map[i+1], map[i+2]);

                int diffLeft = map[i] - left;
                int diffRight = map[i] - right;

                int count = Math.min(diffLeft, diffRight);
                if(count > 0){
                    sum += count;
                }
            }

            System.out.println("#" + tc + " " + sum);
        }
    }
}
