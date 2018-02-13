package d4;

import java.util.ArrayList;
import java.util.Scanner;

public class P1249 {

    public static int size;
    public static int [][]map;
    public static int [][]W;
    public static int [][]D;
    public static int [][]P;
    public static ArrayList<int[]> path;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for(int testCase=1; testCase<= T; testCase++){

            size = scn.nextInt();
            map = new int[size][size];
            W = new int[size*size+1][size*size+1];
            D = new int[size*size+1][size*size+1];
            P = new int[size*size+1][size*size+1];
            path = new ArrayList<>();

            for(int y = 0; y<size; y++){
                String line = scn.next();
                for(int x=0; x<size; x++){
                    int data = Integer.parseInt(line.charAt(x) + "");
                    map[y][x] = data;
                }
            }

            int INF = 100000;
            for (int i = 0; i < size*size; i++) {
                for (int j = 0; j < size*size; j++) {
                    W[i][j] = INF;
                }
            }

            for (int y = 0; y < size; y++) {
                for (int x = 0; x < size; x++) {

                    int node = y*size + x;

                    if (x - 1 >= 0) {
                        int node2 = y*size + (x - 1);
                        W[node][node2] = map[y][x-1];
                    }
                    if (x + 1 < size) {
                        int node2 = y*size + (x + 1);
                        W[node][node2] = map[y][x+1];
                    }
                    if (y - 1 >= 0) {
                        int node2 = (y - 1)*size + x;
                        W[node][node2] = map[y-1][x];
                    }
                    if (y + 1 < size) {
                        int node2 = (y + 1)*size + x;
                        W[node][node2] = map[y+1][x];
                    }

                }

            }

            for (int i = 0; i < size*size; i++) {
                for (int j = 0; j < size*size; j++) {
                    P[i][j] = -1;
                    D[i][j] = W[i][j];
                }
            }
            for (int k = 0; k < size*size; k++) {
                for (int i = 0; i < size*size; i++) {
                    for (int j = 0; j < size*size; j++) {
                        if (D[i][j] > D[i][k] + D[k][j]) {
                            D[i][j] = D[i][k] + D[k][j];
                            P[i][j] = k;
                        }
                    }
                }
            }

            int goalIndex = (size)*(size) - 1;
            storePath(0, goalIndex);

            int weight = 0;
            for(int []vec2 : path){
                weight += map[vec2[0]][vec2[1]];
//                System.out.println(vec2[0] + ", " + vec2[1]);
            }
            System.out.println("#" + testCase + " " + weight);

//            for (int i = 0; i < size*size; i++) {
//                for (int j = 0; j < size*size; j++) {
//                    System.out.print(W[i][j] +" ");
//                }
//                System.out.println();
//            }

        }

    }

    public static void storePath(int a, int b) {
        if (P[a][b] != -1) {	// P[a][b] = -1  "="  a에서 바로 b로 가는 것이 최단거리
            storePath(a, P[a][b]);

            int node = P[a][b];
            int x = node / size;
            int y = node % size;

            int []vec2 = new int[2];
            vec2[0] = x;
            vec2[1] = y;
            path.add(vec2);

            storePath(P[a][b], b);
        }
    }

}
