//
//  P1953.cpp
//  AlgorithmTraining
//
//  Created by 유태우 on 23/09/2018.
//  Copyright © 2018 유태우. All rights reserved.
//

#include <iostream>

using namespace std;

int N, M, L;
int ** map;
bool ** visited;
int ans, queueSize;

int DIRECTION[4][2] = {
    {0, -1}, // 상
    {1, 0},  // 우
    {0, 1},  // 하
    {-1, 0}  // 좌
};

bool TUNNEL[7][4] = { // 상, 우, 하, 좌
    {true, true, true, true},   // 1
    {true, false, true, false}, // 2
    {false, true, false, true}, // 3
    {true, true, false, false}, // 4
    {false, true, true, false}, // 5
    {false, false, true, true}, // 6
    {true, false, false, true}  // 7
};

typedef struct Vec2{
    int x;
    int y;
}Vec2;

class CustomQueue{
private:
    Vec2 * queue;
    int size;
    int front, rear;
public:
    CustomQueue(int size){
        this->size = size+1;
        this->front = 0;
        this->rear = 0;
        queue = new Vec2[this->size];
    }
    
    bool isEmpty(){
        return (front == rear);
    }
    bool queueIsFull(){
        if ((front + 1) % size == rear){
            return true;
        }
        else{
            return false;
        }
    }
    
    bool add(Vec2 value) {
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
    
    Vec2 remove() {
        if (isEmpty()){
            Vec2 vec;
            return vec;
        }
        
        Vec2 value = queue[rear];
        
        rear++;
        if (rear >= size){
            rear = size;
        }
        return value;
    }
};

void BFS(CustomQueue queue, int step);

int main(int argc, const char * argv[]) {
    
    int T;
    cin >> T;
    
    for(int tc=1; tc<=T; tc++){
        
        Vec2 start;
        cin >> N >> M >> start.y >> start.x >> L;
        
        map = new int*[N];
        visited = new bool*[N];
        for(int i=0; i<N; i++){
            map[i] = new int[M];
            visited[i] = new bool[M];
        }
        
        ans = 1;
        
        for(int y=0; y<N; y++){
            for(int x=0; x<M; x++){
                int value;
                cin >> value;
                if(value > 0){
                    queueSize+=1;
                }
                map[y][x] = value;
            }
        }
        
        visited[start.y][start.x] = true;
        CustomQueue queue = *new CustomQueue(queueSize);
        queue.add(start);
        BFS(queue, 1);
        
        cout << "#" << tc << " " << ans << "\n";
        
    }
    
    return 0;
}

void BFS(CustomQueue queue, int step){
    
    if(step >= L || queue.isEmpty()){
        return;
    }
    
    CustomQueue newQueue = *new CustomQueue(queueSize);
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
                        Vec2 vec;
                        vec.x = dx; vec.y = dy;
                        newQueue.add(vec);
                        ans += 1;
                    }
                }
            }
        }
    }
    
    BFS(newQueue, step + 1);
    
}
