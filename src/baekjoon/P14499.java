package baekjoon;

import java.util.Scanner;

public class P14499 {
    static int N, M, K;
    static int diceX, diceY;
    static int [][] map;
    static int [] operation;
    static Dice dice;
    static int [][] DIRECTION = {
            {0, 0},
            {1, 0}, // 1
            {-1, 0}, // 2
            {0, -1}, // 3
            {0, 1}  // 4
    };

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        M = scn.nextInt();
        diceY = scn.nextInt();
        diceX = scn.nextInt();
        K = scn.nextInt();
        dice = new Dice();

        map = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = scn.nextInt();
            }
        }

        operation = new int[K];
        for(int i=0; i<K; i++){
            operation[i] = scn.nextInt();
        }

        for(int i=0; i<K; i++){
            int direction = operation[i];
            int cx = diceX + DIRECTION[direction][0];
            int cy = diceY + DIRECTION[direction][1];
            if(0 <= cx && cx < M && 0 <= cy && cy < N){
                diceX = cx;
                diceY = cy;
                dice.moveDice(direction);
                if(map[diceY][diceX] == 0){
                    map[diceY][diceX] = dice.getBottomValue();
                }else{
                    dice.setBottomValue(map[diceY][diceX]);
                    map[diceY][diceX] = 0;
                }

                System.out.println(dice.getTopValue());
            }

        }

    }

    static class Dice{
        int top, right, front;
        int [] face;
        public Dice(){
            face = new int[7];
            top = 1;
            right = 3;
            front = 2;
        }
        public void moveDice(int direction){
            switch (direction){
                case 1: { // 동
                    int temp = 7 - right;
                    right = top;
                    top = temp;
                    break;
                }
                case 2: { // 서
                    int temp = 7 - top;
                    top = right;
                    right = temp;
                    break;
                }
                case 3: { // 북
                    int temp = 7-front;
                    front = top;
                    top = temp;
                    break;
                }
                case 4: { // 남
                    int temp = 7-top;
                    top = front;
                    front = temp;
                    break;
                }
            }
        }
        public void setBottomValue(int value){
            int bottomIndex = 7-top;
            face[bottomIndex] = value;
        }
        public int getBottomValue(){
            int bottomIndex = 7-top;
            return face[bottomIndex];
        }
        public int getTopValue(){
            return face[top];
        }
    }
}
