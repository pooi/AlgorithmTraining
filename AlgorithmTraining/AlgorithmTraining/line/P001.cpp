#include <iostream>
// #include <cstdio>  // uncomment to use scanf/printf instead of cin/cout
#include <sstream>
#include <string>

using namespace std;

int cost(int distance){
    int m = 720;
    if(distance <= 40){
        return m;
    }else{
        m += ((distance-40)/8 + (distance % 8 == 0 ? 0 : 1 )) * 80;
    }
    return m;
}

int main() {
    string line;
    getline(cin, line);
    stringstream ss(line);
    int m = 20000;
    bool isFinish = false;
    for (int distance; !(ss >> distance).fail(); ) {
        // @todo Write your code here.
        if(!isFinish){
            if(4 <= distance && distance <= 178){
                int c = cost(distance);
                if(m-c < 0){
                    isFinish = true;
                }else {
                    m -= c;
                }
            }else{
                isFinish = true;
            }
        }
    }
    // @todo Write your code here.
    cout << m << endl;
    return 0;
}
