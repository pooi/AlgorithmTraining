//
//  P2105.cpp
//  AlgorithmTraining
//
//  Created by 유태우 on 25/09/2018.
//  Copyright © 2018 유태우. All rights reserved.
//

#include <iostream>

#define MAX(a, b) (a > b) ? (a) : (b)

using namespace std;

int N;
int ** map;
int ans;
bool * DESSERT;

int DIRECTION[4][2] = {
    {-1, 1},
    {1, 1},
    {1, -1},
    {-1, -1}
};

typedef struct Vec2{
    int x;
    int y;
}Vec2;

void DFS(Vec2 start, Vec2 current, int step, int cnt);

int main(int argc, const char * argv[]) {
    
    int T;
    cin >> T;
    for(int tc=1; tc<=T; tc++){
        cin >> N;
        map = new int*[N];
        for(int i=0; i<N; i++){
            map[i] = new int[N];
        }
        ans = -1;
        DESSERT = new bool[101];
        
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                int value;
                cin >> value;
                map[y][x] = value;
            }
        }
        
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                Vec2 vec;
                vec.x = x; vec.y = y;
                DFS(vec, vec, 0, 0);
            }
        }
        
        cout << "#" << tc << " " << ans << "\n";
    }
    
    return 0;
}

bool isEndable(Vec2 v1, Vec2 v2){
    int dx = v2.x - v1.x;
    int dy = v2.y - v1.y;
    return (dx == dy);
}

void DFS(Vec2 start, Vec2 current, int step, int cnt){
    if(step == 3){
        
        if(start.x == current.x && start.y == current.y){
            ans = MAX(ans, cnt);
            return;
        }else{
            if(isEndable(start, current)){
                int x = current.x, y = current.y;
                int dx = x + DIRECTION[step][0];
                int dy = y + DIRECTION[step][1];
                
                int value = map[dy][dx];
                if(!DESSERT[value]){
                    DESSERT[value] = true;
                }else{
                    return;
                }
                Vec2 newV;
                newV.x = dx; newV.y = dy;
                DFS(start, newV, step, cnt+1);
                DESSERT[value] = false;
                
            }else{
                return;
            }
        }
        
    }else {
        int x = current.x, y = current.y;
        int dx, dy;
        int numOfD = 0;
        while (true) {
            dx = x + DIRECTION[step][0];
            dy = y + DIRECTION[step][1];
            
            if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
                break;
            }
            
            int value = map[dy][dx];
            if(!DESSERT[value]){
                DESSERT[value] = true;
                numOfD += 1;
            }else{
                break;
            }
            Vec2 newV;
            newV.x = dx; newV.y = dy;
            DFS(start, newV, step + 1, cnt+numOfD);
            
            x = dx;
            y = dy;
        }
        
        int tempStep = (step + 2) % 4;
        for(int i=0; i<numOfD; i++){
            dx += DIRECTION[tempStep][0];
            dy += DIRECTION[tempStep][1];
            int value = map[dy][dx];
            DESSERT[value] = false;
        }
    }
}
