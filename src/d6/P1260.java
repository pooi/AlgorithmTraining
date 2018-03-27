package d6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1260 {

    static class Mat{
        int row, col;
        public Mat(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static ArrayList<Mat> matrixList;
    static int [][] M;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for(int testCase=1; testCase<=T; testCase++){

            int N = scn.nextInt();
            int [][] map = new int[N+1][N+1];
            Queue<Mat> list = new LinkedList<>();


            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    map[y][x] = scn.nextInt();
                }
            }

            int [] count = new int[N+1];
            int maxRow = 0, maxCol = 0;
            for(int y=0; y<N; y++){
                for(int x=0; x<N; x++){
                    if(map[y][x] != 0){
                        int row = 0, col=0;
                        int x2=x, y2=y;
                        while(x2 < N && map[y][x2] != 0){
                            x2++;
                        }
                        while(y2 < N && map[y2][x] != 0){
                            y2++;
                        }
                        for(int y3=y; y3<y2; y3++){
                            for(int x3=x; x3<x2; x3++){
                                map[y3][x3] = 0;
                            }
                        }
                        row = y2-y;
                        col = x2-x;
                        count[row] += 1;
                        count[col] += 1;
                        if(row > maxRow)
                            maxRow = row;
                        if(col > maxCol)
                            maxCol = col;
                        list.add(new Mat(row, col));
                    }
                }
            }

            matrixList = new ArrayList<>();
            matrixList.add(list.remove());

            while(!list.isEmpty()){
                Mat m = list.remove();

                boolean isAdded = false;
                for(int i=0; i<matrixList.size(); i++){
                    Mat m2 = matrixList.get(i);
                    if(m2.row == m.col){
                        isAdded = true;
                        matrixList.add(i, m);
                        break;
                    }
                    if(m2.col == m.row){
                        isAdded = true;
                        matrixList.add(i+1, m);
                        break;
                    }
                }
                if(!isAdded){
                    list.add(m);
                }
            }

            int len = matrixList.size();
            M = new int[len + 1][len + 1];
            for(int i=1; i<len; i++){
                for(int j=0; j<len-i; j++){
                    int x1 = j;
                    int x2 = j+i;
                    M[x1][x2] = minMul(x1, x2);
                }
            }

            System.out.println(String.format("#%d %d", testCase, M[0][matrixList.size()-1]));

        }

    }

    public static int minMul(int x1, int x2){

        int min = Integer.MAX_VALUE - 1;
        for(int i=x1; i<x2; i++){
            int value = M[x1][i] + M[i+1][x2] + (matrixList.get(x1).row * matrixList.get(i+1).row * matrixList.get(x2).col);
            if(value < min)
                min = value;
        }

        return min;
    }
}
