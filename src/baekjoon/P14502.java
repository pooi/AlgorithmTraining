package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P14502 {

    static int N, M;
    static int [][] map;
    static int [][] tempMap;
    static boolean [][] visited;
    static ArrayList<Vec2> vList;
    static ArrayList<Vec2> eList;
    static int [][] direction = {
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
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=1; testCase++){

            N = scn.nextInt();
            M = scn.nextInt();

            map = new int[N+1][M+1];
            tempMap = new int[N+1][M+1];
            vList = new ArrayList<>();
            eList = new ArrayList<>();

            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    map[n][m] = scn.nextInt();
                    if(map[n][m] == 2){
                        vList.add(new Vec2(m, n));
                    }else if(map[n][m] == 0){
                        eList.add(new Vec2(m, n));
                    }
                }
            }

            int min = 0;


            for(int i=0; i<eList.size()-2; i++){
                for(int j=i+1; j<eList.size()-1; j++){
                    for(int k=j+1; k<eList.size(); k++){

                        visited = new boolean[N+1][M+1];
                        tempMap = new int[N+1][M+1];
                        for(int n=0; n<N; n++){
                            for(int m=0; m<M; m++){
                                tempMap[n][m] = map[n][m];
                            }
                        }

                        Vec2 vi = eList.get(i);
                        Vec2 vj = eList.get(j);
                        Vec2 vk = eList.get(k);
                        tempMap[vi.y][vi.x] = 1;
                        tempMap[vj.y][vj.x] = 1;
                        tempMap[vk.y][vk.x] = 1;

                        min = Math.max(min, fillVirus(tempMap));

                    }
                }
            }

            System.out.println(min);

        }

    }

    static public int fillVirus(int [][] cmap){

        Queue<Vec2> queue = new LinkedList<>();
        for(Vec2 v : vList){
            queue.add(v);
        }

        while(!queue.isEmpty()){

            Vec2 v = queue.remove();
            visited[v.y][v.x] = true;

            for(int i=0; i<direction.length; i++){
                int nx = v.x - direction[i][0];
                int ny = v.y - direction[i][1];
                if(0 <= nx && nx < M && 0<= ny && ny < N){
                    if(!visited[ny][nx] && cmap[ny][nx] == 0){
                        cmap[ny][nx] = 2;
                        queue.add(new Vec2(nx, ny));
                    }
                }
            }

        }

        int count = 0;
        for(int n=0; n<N; n++){
            for(int m=0; m<M; m++){
                if(cmap[n][m] == 0)
                    count += 1;
            }
        }

        return count;

    }

}
