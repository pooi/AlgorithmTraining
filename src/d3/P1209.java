package d3;

import java.util.ArrayList;
import java.util.Scanner;

public class P1209 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        for(int tc=1; tc<=10; tc++){
            int testCase = scn.nextInt();
            int [][] map = new int[100][100];
            for(int y=0; y<100; y++){
                for(int x=0; x<100; x++){
                    map[y][x] = scn.nextInt();
                }
            }
            ArrayList<Integer> list = new ArrayList<>();
            for(int y=0; y<100; y++){
                int sum = 0;
                for(int x=0; x<100; x++){
                    sum += map[y][x];
                }
                list.add(sum);
            }
            for(int x=0; x<100; x++){
                int sum = 0;
                for(int y=0; y<100; y++){
                    sum += map[y][x];
                }
                list.add(sum);
            }

            int sum1 = 0, sum2=0;
            for(int c=0; c<100; c++){
                sum1 += map[c][c];
                sum2 += map[100-c-1][c];
            }
            list.add(sum1);
            list.add(sum2);

            int max = 0;
            for(int l : list){
                if(l > max)
                    max = l;
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
