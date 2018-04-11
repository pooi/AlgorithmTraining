package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3190 {
    static int [][] DIRECTION = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    }; // D = +1, L = +3 % 4
    static int N, K, L;
    static int [][] map;
    static ArrayList<Body> snack;
    static int time;
    static int [] lastMove;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        K = scn.nextInt();
        map = new int[N][N];
        for(int i=0; i<K; i++){
            int ny = scn.nextInt()-1;
            int nx = scn.nextInt()-1;
            map[ny][nx] = 1;
        }

        int currentDirection = 0;
        Queue<int []> queue = new LinkedList<>();
        L = scn.nextInt();
        int index = 0;
        for(int i=0; i<L; i++){
            int n = scn.nextInt();
            String direct = scn.next();
            for(int j=index; j<n; j++)
                queue.add(DIRECTION[currentDirection]);

            index = n;
            if(direct.equals("D"))
                currentDirection = (currentDirection+1)%4;
            else
                currentDirection = (currentDirection+3)%4;

        }

        snack = new ArrayList<>();
        Body head =new Body(0,0,queue);
        snack.add(head);
        time = 0;
        boolean isFinish = false;
        lastMove = DIRECTION[currentDirection];
        while(true){

            time += 1;

            int [] move;
            if(!head.moves.isEmpty())
                move = head.moves.peek();
            else
                move = lastMove;

            int head_cx = head.x + move[0];
            int head_cy = head.y + move[1];
            if(head_cx < 0 || head_cx >= N || head_cy < 0 || head_cy >= N || isConflict(head_cx, head_cy)){
                break;
            }

            Body body = null;
            if(map[head_cy][head_cx] == 1){
                map[head_cy][head_cx] = 0;
                Body temp = snack.get(snack.size()-1);
                body = new Body(temp.x, temp.y, temp.copyQueue());
            }
            for(int i=0; i<snack.size(); i++){
                if(!snack.get(i).move()){
                    isFinish = true;
                    break;
                }
            }

            if(isFinish)
                break;

            if(body != null) // 꼬리 추가
                snack.add(body);

        }

        System.out.println(time);

    }

    static boolean isConflict(int x, int y){
        for(Body body : snack){
            if(body.x == x && body.y == y)
                return true;
        }
        return false;
    }

    static class Body{
        Queue<int []> moves;
        int x, y;
        public Body(int x, int y, Queue queue){
            this.x = x;
            this.y = y;
            this.moves = queue;
        }
        boolean move(){
            int [] move;
            if(this.moves.isEmpty())
                move = lastMove;
            else
                move = this.moves.remove();
            int cx = this.x + move[0];
            int cy = this.y + move[1];
            if(0 <= cx && cx < N && 0 <= cy && cy < N){
                this.x = cx;
                this.y = cy;
                return true;
            }else{
                return false;
            }
        }
        Queue<int []> copyQueue(){
            Queue<int []> queue = new LinkedList<>();
            for(int [] move : moves){
                queue.add(move);
            }
            return queue;
        }
    }

}
