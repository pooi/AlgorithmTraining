package d4;

import java.util.Scanner;

public class P1210 {

    static int [][] map;
    static boolean [][] flag;
    static int finishX;
    static int [][] direction = {
            {1, 0},
            {-1, 0},
            {0, -1}
    };

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=10; testCase++){

            int T = scn.nextInt();

            map = new int[101][101];
            flag = new boolean[101][101];

            for(int y=0; y<100; y++){
                for(int x=0; x<100; x++){
                    map[y][x] = scn.nextInt();
                    if(map[y][x] == 2){
                        finishX = x;
                    }
                }
            }

            int px = finishX, py = 99;
            while(py > 0){
                flag[py][px] = true;
                for(int i=0; i<direction.length; i++){
                    int nx = px + direction[i][0];
                    int ny = py + direction[i][1];
                    if(0 <= nx && nx < 100 && 0 <= ny && ny < 100 && map[ny][nx] == 1 && !flag[ny][nx]){
                        px = nx;
                        py = ny;
                        break;
                    }
                }
            }
            System.out.println(String.format("#%d %d", testCase, px));

        }

    }
}
