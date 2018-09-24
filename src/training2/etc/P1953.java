package training2.etc;

import java.util.Scanner;

public class P1953 {

    public static int N, M, L;
    public static int [][] map;
    public static boolean [][] visited;
    public static int ans, queueSize;

    public static int [][] DIRECTION = {
            {0, -1}, // 상
            {1, 0},  // 우
            {0, 1},  // 하
            {-1, 0}  // 좌
    };
    public static boolean [][] TUNNEL = { // 상, 우, 하, 좌
            {true, true, true, true}, // 1
            {true, false, true, false}, // 2
            {false, true, false, true}, // 3
            {true, true, false, false}, // 4
            {false, true, true, false}, // 5
            {false, false, true, true}, // 6
            {true, false, false, true}  // 7
    };

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int tc=1; tc<=T; tc++){

            N = scn.nextInt();
            M = scn.nextInt();

            int startY = scn.nextInt();
            int startX = scn.nextInt();

            L = scn.nextInt();

            map = new int[N][M];
            visited = new boolean[N][M];
            ans = 1;

            for(int y=0; y<N; y++){
                for(int x=0; x<M; x++){
                    int value = scn.nextInt();
                    if(value > 0){
                        queueSize+=1;
                    }
                    map[y][x] = value;
                }
            }

            Vec2 start = new Vec2(startX, startY);
            visited[start.y][start.x] = true;
            CustomQueue queue = new CustomQueue(queueSize);
            queue.add(start);
            BFS(queue, 1);

            System.out.println(String.format("#%d %d", tc, ans));

        }

    }

    public static void BFS(CustomQueue queue, int step){

        if(step >= L || queue.isEmpty()){
            return;
        }

        CustomQueue newQueue = new CustomQueue(queueSize);
        while(!queue.isEmpty()){
            Vec2 pos = queue.remove();
            int value = map[pos.y][pos.x] - 1;

            for(int i=0; i<4; i++){
                int dx = pos.x + DIRECTION[i][0];
                int dy = pos.y + DIRECTION[i][1];
                int d = (i+2) % 4;

                if(0 <= dx && dx < M && 0 <= dy && dy < N && !visited[dy][dx]){
                    int dValue = map[dy][dx] - 1;
                    if(dValue >= 0){
                        if(TUNNEL[value][i] && TUNNEL[dValue][d]){
                            visited[dy][dx] = true;
                            newQueue.add(new Vec2(dx, dy));
                            ans += 1;
                        }
                    }
                }
            }
        }

        BFS(newQueue, step + 1);

    }

    static class Vec2{
        int x, y;
        public Vec2(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class CustomQueue{
        Vec2 [] queue;
        int size;

        int front, rear;

        public CustomQueue(int size){
            this.size = size+1;
            this.front = 0;
            this.rear = 0;
            queue = new Vec2[this.size];
        }

        public boolean isEmpty() {
            return (front == rear);
        }

        public boolean queueIsFull() {
            if ((front + 1) % size == rear){
                return true;
            }
            else{
                return false;
            }
        }

        public boolean add(Vec2 value) {
            if (queueIsFull()) {
                return false;
            }
            queue[front] = value;
            front++;
            if (front >= size){
                front = size;
            }

            return true;
        }

        public Vec2 remove() {
            if (isEmpty()){
                return null;
            }

            Vec2 value = queue[rear];

            rear++;
            if (rear >= size){
                rear = size;
            }
            return value;
        }
    }

}
