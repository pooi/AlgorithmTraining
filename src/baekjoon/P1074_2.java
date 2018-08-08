package baekjoon;

import java.util.Scanner;

public class P1074_2 {
    static int [][] DIRECTION = {
            {0, 0},
            {1, 0},
            {0, 1},
            {1, 1}
    };
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();

        int size = (int)Math.pow(2, n);

//        int [][] map = new int[size][size];

        int cc = 0;
        for(int y=0; y<size; y+=2){
            for(int x=0; x<size; x+=2){
                for(int [] d : DIRECTION){
                    int rx = x + d[0];
                    int ry = y + d[1];
//                    map[ry][rx] = cc;
                    if(ry == r && rx == c){
                        System.out.println(cc);
                        return;
                    }
                    cc+=1;
                }
            }
        }

    }
}
