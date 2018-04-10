package baekjoon;

import java.util.Scanner;

public class P13460 {
    static int N, M;
    static int map[][];
    static Vec2 RED;
    static Vec2 BLUE;
    static Vec2 GOAL;
    static int min;
    static int [][] DIRECTION = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };
    static class Vec2{
        int x, y;
        public Vec2(int x, int y){
            this.x = x;
            this.y = y;
        }
        boolean isSame(int x, int y){
            return x == this.x && y == this.y;
        }
        boolean isSame(Vec2 v){
            return v.x == this.x && v.y == this.y;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        M = scn.nextInt();
        map = new int[N][M];
        for(int i=0; i<N; i++){
            String str = scn.next();
            for(int j=0; j<M; j++){
                String s = str.charAt(j) + "";
                if(s.equals("#")){
                    map[i][j] = 1;
                }else if(s.equals("O")){
                    map[i][j] = 2;
                    GOAL = new Vec2(j,i);
                }else if(s.equals("R")){
                    RED = new Vec2(j, i);
                }else if(s.equals("B")){
                    BLUE = new Vec2(j, i);
                }else{
                    map[i][j] = 0;
                }
            }
        }

        min = Integer.MAX_VALUE-1;
        if(search(0, RED, BLUE)){
            System.out.println(min);
        }else{
            System.out.println("-1");
        }

    }

    static boolean search(int depth, Vec2 red, Vec2 blue){
        if(depth > min)
            return false;
        if(red.isSame(GOAL) && blue.isSame(GOAL)){
            return false;
        }else if(red.isSame(GOAL)){
            min = Math.min(min, depth);
            return true;
        }
        boolean result = false;
        if(depth >= 10){
            return false;
        }else{
            for(int i=0; i<DIRECTION.length; i++){
                Vec2 newRed = move(red, red, blue, DIRECTION[i][0], DIRECTION[i][1]);
                Vec2 newBlue = move(blue, newRed, blue, DIRECTION[i][0], DIRECTION[i][1]);
                newRed = move(newRed, newRed, newBlue, DIRECTION[i][0], DIRECTION[i][1]);

                result = result | search(depth + 1, newRed, newBlue);
            }
        }
        return result;
    }

    static Vec2 move(Vec2 v, Vec2 r, Vec2 b, int rx, int ry){
        if(map[v.y][v.x] == 2)
            return v;

        Vec2 vec = new Vec2(v.x, v.y);
        while(true){
            int cx = vec.x + rx;
            int cy = vec.y + ry;
            if(0 <= cx && cx < M && 0 <= cy && cy < N && map[cy][cx] == 2) {
                vec.x = cx;
                vec.y = cy;
                break;
            }
            if(0 <= cx && cx < M && 0 <= cy && cy < N && map[cy][cx] == 0 && !r.isSame(cx, cy) && !b.isSame(cx, cy)){
                vec.x = cx;
                vec.y = cy;
            }else
                break;

        }
        return vec;
    }
}
