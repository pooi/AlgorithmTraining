package d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1258_2 {

    static class Mat implements Comparable{
        int row, col;
        public Mat(int row, int col){
            this.row = row;
            this.col = col;
        }



        @Override
        public String toString(){
            return row + " " + col;
        }

        @Override
        public int compareTo(Object o) {
            Mat m1 = this;
            Mat m2 = (Mat)o;
            int mul1 = m1.row * m1.col;
            int mul2 = m2.row * m2.col;
            if(mul1 == mul2){
                return m1.row - m2.row;
            }
            return mul1 - mul2;
        }
    }

    static public void main(String[] args){
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            int N = scn.nextInt();

            int [][] map = new int[N+1][N+1];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = scn.nextInt();
                }
            }

            ArrayList<Mat> list = new ArrayList<>();

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] != 0){

                        int nx = j;
                        while(true){
                            nx += 1;
                            if(nx >= N || map[i][nx] == 0)
                                break;
                        }

                        int ny = i;
                        while(true){
                            ny += 1;
                            if(ny >= N || map[ny][j] == 0)
                                break;
                        }

                        list.add(new Mat(ny-i, nx-j));

                        for(int y=i; y<ny; y++){
                            for(int x=j; x<nx; x++){
                                map[y][x] = 0;
                            }
                        }
                    }
                }
            }

            Collections.sort(list);

            System.out.print(String.format("#%d %d ", testCase, list.size()));
            for(Mat m : list){
                System.out.print(m + " ");
            }
            System.out.println();

        }
    }
}
