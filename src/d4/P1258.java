package d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1258 {

    public static int [][]map;
    public static boolean [][]checked;
    public static ArrayList<Matrix> list;

    static class Matrix implements Comparable{
        public int row, col;
        public Matrix(int row, int col){
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Object o) {
            Matrix m1 = this, m2 = (Matrix)o;
            int a = m1.row * m1.col;
            int b = m2.row * m2.col;

            if(a == b)
                return m1.row - m2.row;
            else
                return (a-b);
        }

        @Override
        public String toString(){
            return row + " " + col;
        }
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){
            int size = scn.nextInt();
            map = new int[size][size];
            checked = new boolean[size][size];
            list = new ArrayList<>();

            for(int y=0; y<size; y++)
                for(int x=0; x<size; x++)
                    map[y][x] = scn.nextInt();

            for(int y=0; y<size; y++){
                for(int x=0; x<size; x++){
                    if(!checked[y][x]){
                        if(map[y][x] > 0){

                            int maxCol = x;
                            int maxRow = y;
                            for(int x2=maxCol; x2<size; x2++){
                                if(map[y][x2] <=0) break;
                                maxCol=x2;
                            }
                            for(int y2=maxRow; y2<size; y2++){
                                if(map[y2][x] <=0) break;
                                maxRow=y2;
                            }
                            mark(x, y, maxCol, maxRow);
                            list.add(new Matrix(maxRow-y+1, maxCol-x+1));

                        }
                    }
                }
            }

            Collections.sort(list);
            System.out.print("#" + testCase + " " + list.size() + " ");
            for(Matrix m : list)
                System.out.print(m + " ");
            System.out.println();
        }
    }

    public static void mark(int x1, int y1, int x2, int y2){
        for(int y=y1; y<=y2; y++)
            for(int x=x1; x<=x2; x++)
                checked[y][x] = true;
    }
}
