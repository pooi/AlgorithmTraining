package d4;

import java.util.ArrayList;
import java.util.Scanner;

public class P1211 {

    static int [][] direction = {
            {1, 0},
            {-1, 0},
            {0, 1}
    };

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=10; testCase++){

            int T = scn.nextInt();

            int [][] map = new int[101][101];

            ArrayList<Integer> sList = new ArrayList<>();

            for(int y=0; y<100; y++){
                for(int x=0; x<100; x++){
                    map[y][x] = scn.nextInt();
                    if(y == 0 && map[y][x] == 1){
                        sList.add(x);
                    }
                }
            }

            int resultX=-1, min=Integer.MAX_VALUE-1;
            for(int startX : sList){
                int px = startX;
                int py = 0;
                int len = 0;
                boolean [][] flag = new boolean[101][101];

                while(py < 99){
                    flag[py][px] = true;
                    len += 1;
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
                if(len <= min){
                    min = len;
                    if(startX >resultX)
                        resultX = startX;
                }
            }
            System.out.println(String.format("#%d %d", testCase, resultX));

        }

    }
}
