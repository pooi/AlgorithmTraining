package d6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class P1268 {

    static class Vec{
        int x, y;
        public Vec(int x, int y){
            this.x = x;
            this.y = y;
        }
        String calc(Vec v2){
            Vec v1 = this;

            String directionX, directionY;
            if(v2.x >= v1.x){
                directionX = "p";
            }else{
                directionX = "m";
            }
            if(v2.y >= v1.y){
                directionY = "p";
            }else{
                directionY = "m";
            }

            int _y = v2.y - v1.y;
            int _x = v2.x - v1.x;
            if(_x == 0)
                return directionX + directionY + "0.0";

            Double d = (double)_y/_x;
            return directionX + directionY + String.format("%.3f", d);
        }
    }
    static ArrayList<Vec> list;
    static boolean [][] flag;
    static int [] A;
    static int [] B;
    static int [] C;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T= scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            int size, N, K;
            size = scn.nextInt();
            N = scn.nextInt();
            K = scn.nextInt();

            list = new ArrayList<>();
            A = new int[2*(N+1)];
            B = new int[2*(N+1)];
            C = new int[2*(N+1)];
//            A2 = new int[2*(N+1)];

            flag = new boolean[size+1][size+1];
            for(int i=0; i<N; i++){
                int y = scn.nextInt();
                int x = scn.nextInt();
                list.add(new Vec(x, y));
                flag[y][x] = true;
            }

            int total = 0;
            for(int i=0; i<list.size(); i++){
                HashMap<String, String> map = new HashMap<>();
                Vec v1 = list.get(i);
                for(int j=0; j<list.size(); j++){
                    if(i != j) {
                        Vec v2 = list.get(j);
                        String d = v1.calc(v2);
                        map.put(d, "1");
                    }
                }
                A[i+1] = map.size();
                total += A[i+1];
            }

            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    A[j] = ((A[j] * K + j) % N) + 1;
                    A[N + j] =((A[j] * j + K) % N) + 1;
                }
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=1; j<=2*N; j++){
                    temp.add(A[j]);
                }
                //정렬
                Collections.sort(temp);
                for(int j=0; j<2*N; j++){
                    A[j+1] = temp.get(j);
                }
                B[0] = 1;
                for(int j=1; j<=2*N; j++){
                    B[j] = ((B[j-1]* A[j] + j) % N) + 1;
                }
                C[i] = B[2*N];
            }
            int sum = 0;
            for(int i=1; i<=N; i++){
                sum += C[i];
            }

            System.out.println(String.format("#%d %d %d", testCase, total, sum));

        }

    }
}
