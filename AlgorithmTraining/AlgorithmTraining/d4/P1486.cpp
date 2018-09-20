//
//  P1486.cpp
//  AlgorithmTraining
//
//  Created by 유태우 on 18/09/2018.
//  Copyright © 2018 유태우. All rights reserved.
//

#include <iostream>

#define MIN(a, b) (a < b) ? (a) : (b)

using namespace std;

int N, B;
int *H;

bool * visited;
int ans;

void DFS(int sum, int index){
    
    if(sum > ans){
        return;
    }
    
    if(sum >= B){
        ans = MIN(sum, ans);
        return;
    }
    
    for(int i=index; i<N; i++){
        if(!visited[i]){
            visited[i] = true;
            sum += H[i];
            DFS(sum, i+1);
            sum -= H[i];
            visited[i] = false;
        }
    }
    
}

int main(int argc, const char * argv[]) {
    
    int T;
    cin >> T;
    
    for(int tc=1; tc<=T; tc++){
        cin >> N >> B;
        H = new int[N];
        visited = new bool[N];
        ans = 2000000000;
        
        for(int i=0; i<N; i++){
            cin >> H[i];
        }
        
        DFS(0, 0);
        
        cout << "#" << tc << " " << ans-B << "\n";
        
    }
    
    return 0;
}

