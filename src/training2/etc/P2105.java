package training2.etc;

import java.util.Scanner;

public class P2105 {

    static int N;
    static int [][] map;
    static int ans;
    static boolean [] DESSERT;

    static int [][] DIRECTION = {
            {-1, 1},
            {1, 1},
            {1, -1},
            {-1, -1}
    };

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();
        for(int tc=1; tc<=T; tc++){
            N = scn.nextInt();
            map = new int[N][N];
            ans = -1;
            DESSERT = new boolean[101];

            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    map[y][x] = scn.nextInt();
                }
            }

            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    DFS(new Vec2(x, y), new Vec2(x, y), 0, 0);
                }
            }

            System.out.println(String.format("#%d %d", tc, ans));


        }

    }

    public static void DFS(Vec2 start, Vec2 current, int step, int cnt){

        if(step == 3){

            if(start.equal(current)){
                ans = Math.max(ans, cnt);
                return;
            }else{
                if(start.isEndable(current)){
                    int x = current.x, y = current.y;
                    int dx = x + DIRECTION[step][0];
                    int dy = y + DIRECTION[step][1];

                    int value = map[dy][dx];
                    if(!DESSERT[value]){
                        DESSERT[value] = true;
                    }else{
                        return;
                    }
                    DFS(start, new Vec2(dx, dy), step, cnt+1);
                    DESSERT[value] = false;

                }else{
                    return;
                }
            }

        }else {
            int x = current.x, y = current.y;
            int dx, dy;
            int numOfD = 0;
            while (true) {
                dx = x + DIRECTION[step][0];
                dy = y + DIRECTION[step][1];

                if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
                    break;
                }

                int value = map[dy][dx];
                if(!DESSERT[value]){
                    DESSERT[value] = true;
                    numOfD += 1;
                }else{
                    break;
                }
                DFS(start, new Vec2(dx, dy), step + 1, cnt+numOfD);

                x = dx;
                y = dy;
            }

            int tempStep = (step + 2) % 4;
            for(int i=0; i<numOfD; i++){
                dx += DIRECTION[tempStep][0];
                dy += DIRECTION[tempStep][1];
                int value = map[dy][dx];
                DESSERT[value] = false;
            }
        }

    }

    public static class Vec2{
        int x, y;
        public Vec2(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean isEndable(Vec2 v2){
            Vec2 v1 = this;
            int dx = v2.x - v1.x;
            int dy = v2.y - v1.y;
            return (dx == dy);
        }

        public boolean equal(Vec2 v2){
            Vec2 v1 = this;
            return (v1.x == v2.x && v1.y == v2.y);
        }
    }
}
