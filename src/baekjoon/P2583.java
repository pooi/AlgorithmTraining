package baekjoon;

import java.util.*;

public class P2583 {
    static int N, M, K;
    static boolean [][] map;
    static ArrayList<Integer> ans;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        ans = new ArrayList<>();
        M = scn.nextInt();
        N = scn.nextInt();

        map = new boolean[M][N];
        K = scn.nextInt();
        for(int k=0; k<K; k++){
            int x1, y1;
            x1 = scn.nextInt();
            y1 = scn.nextInt();
            int x2, y2;
            x2 = scn.nextInt()-1;
            y2 = scn.nextInt()-1;

            for(int y=y1; y<=y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    map[y][x] = true;
                }
            }
        }

        for(int y=0; y<M; y++){
            for(int x=0; x<N; x++){
                if(!map[y][x])
                    BFS(x, y);
            }
        }

        Collections.sort(ans);

        System.out.println(ans.size());
        for(int a : ans){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void BFS(int px, int py){
        Queue<Vec2> queue = new LinkedList<>();
        queue.add(new Vec2(px, py));
        int size = 1;
        map[py][px] = true;
        while(!queue.isEmpty()){

            Vec2 vec = queue.remove();

            for(int i=0; i<4; i++){
                Vec2 move = vec.move(i);
                if(0 <= move.x && move.x < N && 0  <= move.y && move.y < M && !map[move.y][move.x]){
                    map[move.y][move.x] = true;
                    size += 1;
                    queue.add(move);
                }
            }
        }
        ans.add(size);
    }

    static class Vec2{
        int x, y;
        static Vec2 [] DIRECTION = {
                new Vec2(0, -1),
                new Vec2(1, 0),
                new Vec2(0, 1),
                new Vec2(-1, 0),
        };
        public Vec2(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Vec2 move(int direction){
            int x2, y2;
            x2 = this.x + DIRECTION[direction].x;
            y2 = this.y + DIRECTION[direction].y;
            return new Vec2(x2, y2);
        }
    }
}
