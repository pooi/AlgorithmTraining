package d4;

import java.util.ArrayList;
import java.util.Scanner;

public class P1251 {

    static class Point{
        int x, y;
        public Point(int x){
            this.x = x;
            this.y = 0;
        }
        public Double distance(Point p){
            return (Math.pow(this.x-p.x, 2) + Math.pow(this.y-p.y, 2));
        }
    }

    static Double [][] W;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase <= T; testCase++){

            ArrayList<Point> list = new ArrayList<>();

            int N = scn.nextInt();
            for(int i=0; i<N; i++){
                list.add(new Point(scn.nextInt()));
            }
            for(int i=0; i<N; i++){
                list.get(i).y = scn.nextInt();
            }

            Double E = scn.nextDouble();

            W = new Double[N+1][N+1];
            int [] nearest = new int[N+1];
            Double [] distance = new Double[N+1];

            for(int j=0; j<N; j++){
                for(int i=0; i<N; i++){
                    Point p1 = list.get(j);
                    Point p2 = list.get(i);
                    W[j][i] = E * p1.distance(p2);
                }
            }

            for(int i=1; i<N; i++){
                nearest[i] = 0;
                distance[i] = W[0][i];
            }

            Double min;
            int vnear = N;
            Double total = 0.0;
            for(int j=0; j<N-1; j++){
                min = Double.MAX_VALUE-1;
                for(int i=1; i<N; i++){
                    if(0<=distance[i] && distance[i]<=min){
                        min = distance[i];
                        vnear = i;
                    }
                }
                total += min;
                distance[vnear] = -1.0;
                for(int i=1; i<N; i++){
                    if(W[i][vnear] < distance[i]){
                        distance[i] = W[i][vnear];
                        nearest[i] = vnear;
                    }
                }
            }

            System.out.println(String.format("#%d %.0f", testCase, total));

        }

    }
}
