//
//  P1949.cpp
//  AlgorithmTraining
//
//  Created by 유태우 on 21/09/2018.
//  Copyright © 2018 유태우. All rights reserved.
//

#include <iostream>

using namespace std;

int DIRECTION[4][2] = {
    {0, -1},
    {1, 0},
    {0, 1},
    {-1, 0}
};

int N, K;
int **map;
bool **visited;
bool isK;
int ans;

void DFS(int sum, int x, int y);

int main(int argc, const char * argv[]) {
    
    int T;
    cin >> T;
    for(int tc=1; tc<=T; tc++){
        
        cin >> N >> K;
        map = new int*[N];
        for(int i=0; i<N; i++){
            map[i] = new int[N];
        }
        
        visited = new bool*[N];
        for(int i=0; i<N; i++){
            visited[i] = new bool[N];
        }
        
        isK = false;
        ans = 0;
        
        int max = 0;
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                int value;
                cin >> value;
                map[y][x] = value;
                if(value > max)
                    max = value;
            }
        }
        
        int startPoints[5][2];
        int numOfSP = 0;
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                if(map[y][x] == max){
                    startPoints[numOfSP][0] = x;
                    startPoints[numOfSP][1] = y;
                    numOfSP+=1;
                }
            }
        }
        
        for(int i=0; i<numOfSP; i++){
            visited[startPoints[i][1]][startPoints[i][0]] = true;
            DFS(1, startPoints[i][0], startPoints[i][1]);
            visited[startPoints[i][1]][startPoints[i][0]] = false;
        }
        
        cout << "#" << tc << " " << ans << "\n";
    }
    
    return 0;
}

void DFS(int sum, int x, int y){
    if(sum > ans)
        ans = sum;
    
    for(int i=0; i<4; i++){
        int dx = x + DIRECTION[i][0];
        int dy = y + DIRECTION[i][1];
        
        if(0 <= dx && dx < N && 0 <= dy && dy < N){
            int value = map[y][x];
            int dValue = map[dy][dx];
            
            if(!visited[dy][dx]){
                if(dValue < value){
                    visited[dy][dx] = true;
                    DFS(sum + 1, dx, dy);
                    visited[dy][dx] = false;
                }else{
                    if(!isK) {
                        int diff = dValue - value + 1;
                        if (diff <= K) {
                            isK = true;
                            map[dy][dx] -= diff;
                            visited[dy][dx] = true;
                            DFS(sum + 1, dx, dy);
                            visited[dy][dx] = false;
                            map[dy][dx] += diff;
                            isK = false;
                        }
                    }
                }
            }
            
        }
        
    }
}
