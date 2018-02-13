package d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1249_2 {

    public static int size;
    public static int [][]map;
    public static int [][]dist;
    public static int [][]dt = {
            {0, -1},
            {1, 0},
            {0, 1},
            {-1, 0}
    };

    static class Vec2{
        public int x, y, sum;
        public Vec2(int x, int y, int sum){
            this.x = x;
            this.y = y;
            this.sum = sum;
        }

    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for(int testCase=1; testCase<= T; testCase++){

            size = scn.nextInt();
            map = new int[size][size];
            dist = new int[size][size];

            for(int y = 0; y<size; y++){
                String line = scn.next();
                for(int x=0; x<size; x++){
                    int data = Integer.parseInt(line.charAt(x) + "");
                    map[y][x] = data;
                    dist[y][x] = Integer.MAX_VALUE - 2;
                }
            }

            Queue<Vec2> queue = new LinkedList<Vec2>();
            queue.add(new Vec2(0,0,0));

            dist[0][0] = 0;
            while(!queue.isEmpty()){

                Vec2 node = queue.remove();
                for(int d=0; d<4; d++){
                    int dx = node.x + dt[d][0];
                    int dy = node.y + dt[d][1];
                    if(dx < 0 || dx >= size || dy < 0 || dy >= size){ continue; }
                    int sum = node.sum + map[dy][dx];
                    if(sum < dist[dy][dx]){
                        dist[dy][dx] = sum;
                        queue.add(new Vec2(dx, dy, sum));
                    }
                }
            }

            System.out.println(String.format("#%d %d", testCase, dist[size-1][size-1]));

        }

    }



}
