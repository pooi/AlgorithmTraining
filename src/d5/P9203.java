package d5;

import java.util.Scanner;

public class P9203 {

    static int X, Y;
    static Vec2 start, finish;
    static int [][] map;
    static int [][] dp;
    static boolean [][] check;
    static int [][] DIRECTION = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };

    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int tc=1; tc<=T; tc++){
            X = scn.nextInt();
            Y = scn.nextInt();
            start = new Vec2(scn.nextInt(), scn.nextInt());
            finish = new Vec2(scn.nextInt(), scn.nextInt());

            map = new int[Y][X];
            dp = new int[Y][X];
            check = new boolean[Y][X];

            for(int y=0; y<Y; y++){
                for(int x=0; x<X; x++){
                    map[y][x] = scn.nextInt();
                }
            }

            dp[start.y][start.x] = 1;

            Vec2 [] list = {start};
            BPS(list, 1);

            for(int y=0; y<Y; y++){
                for(int x=0; x<X; x++){
                    System.out.print(dp[y][x] + " ");
                }
                System.out.println();
            }

            int answer = dp[finish.y][finish.x];
            if(answer == 0){
                System.out.println("#" + tc + " Sorry, princess XD");
            }else{
                System.out.println("#" + tc + " " + answer);
            }

        }
    }

    static void BPS(Vec2 [] list, int total){
        int newListCount = 0;
        Vec2 [] newList = new Vec2[total*4];

        for(int i=0; i<total; i++) {
            Vec2 vec2 = list[i];
            int current = vec2.getValue(map);
            for(int d=0; d<DIRECTION.length; d++) {
                int x2 = vec2.x + DIRECTION[d][0];
                int y2 = vec2.y + DIRECTION[d][1];
                if (0 <= x2 && x2 < X && 0 <= y2 && y2 < Y) {
                    int value = map[y2][x2];
                    if(current < 0 && value < 0){
                        continue;
                    }else{
                        if(abs(current) > abs(value)){
                            dp[vec2.y][vec2.x] += dp[y2][x2];
                        }
                    }
                }
            }
        }

        for(int i=0; i<total; i++){
            Vec2 vec2 = list[i];
            int current = vec2.getValue(map);
            check[vec2.y][vec2.x] = true;

            for(int d=0; d<DIRECTION.length; d++){
                int x2 = vec2.x + DIRECTION[d][0];
                int y2 = vec2.y + DIRECTION[d][1];
                if(0 <= x2 && x2 < X && 0 <= y2 && y2 < Y && !check[y2][x2]){
                    int value = map[y2][x2];
                    if(current < 0 && value < 0){
                        continue;
                    }else{
                        if(abs(current) < abs(value)){
                            newList[newListCount] = new Vec2(x2, y2);
                            newListCount += 1;
                            check[y2][x2] = true;
                        }

                    }
                }
            }
        }
        if(newListCount > 0)
            BPS(newList, newListCount);
    }

    static int abs(int value){
        if(value < 0){
            return -value;
        }
        return value;
    }

    static class Vec2{
        int x, y;
        public Vec2(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getValue(int [][] map){
            return map[this.y][this.x];
        }
    }

}
