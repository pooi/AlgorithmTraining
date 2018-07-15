package d3;

import java.util.Scanner;

public class P1220 {
    static int N;
    static int [][] map;
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        for(int testCase=1; testCase<=10; testCase++){

            N = scn.nextInt();
            map = new int[N][N];

            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    map[y][x] = scn.nextInt();
                }
            }

            while(true) {
                boolean isMove = false;
                for (int y = 0; y < N; y++) {
                    for (int x = 0; x < N; x++) {
                        int item = map[y][x];
                        if(item == 1){
                            int y2 = y + 1;
                            if(0 <= y2 && y2 < N && map[y2][x] == 0){
                                map[y][x] = 0;
                                map[y2][x] = item;
                                isMove = true;
                            }else if(y2 >= N){
                                map[y][x] = 0;
                                isMove = true;
                            }
                        }else if(item == 2){
                            int y2 = y - 1;
                            if(0 <= y2 && y2 < N && map[y2][x] == 0){
                                map[y][x] = 0;
                                map[y2][x] = item;
                                isMove = true;
                            }else if(y2 < 0){
                                map[y][x] = 0;
                                isMove = true;
                            }
                        }
                    }
                }
                if(!isMove){
                    break;
                }
            }

            int count = 0;
            for(int x=0; x<N; x++){
                int temp = 0;
                for(int y=0; y<N; y++){
                    switch (temp){
                        case 0:{
                            if(map[y][x] == 1){
                                temp = 1;
                            }
                            break;
                        }
                        case 1:{
                            if(map[y][x] == 2){
                                temp = 2;
                            }
                            break;
                        }
                        case 2:{
                            if(map[y][x] == 0 || map[y][x] == 1){
                                count += 1;
                                temp = map[y][x];
                            }
                            break;
                        }
                    }
                }
                if(temp == 2){
                    count += 1;
                }
            }

            System.out.println(String.format("#%d %d", testCase, count));

        }
    }
    static class Vec2{
        int x, y;
        public Vec2(int x, int y){
            this.x = x; this.y = y;
        }
    }
}
