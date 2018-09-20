//
//  P1218.cpp
//  AlgorithmTraining
//
//  Created by 유태우 on 19/09/2018.
//  Copyright © 2018 유태우. All rights reserved.
//

#include <iostream>

using namespace std;

class CustomStack{
private:
    char * list;
    int size;
    int top;
public:
    CustomStack(){
    }
    
    CustomStack(int size){
        this->list = new char[size+1];
        this->size = size;
        this->top = -1;
    }
    
    void push(char ch){
        if(top >= size){
            return;
        }
        this->list[++top] = ch;
    }
    
    char pop(){
        if(top < 0){
            return NULL;
        }
        return list[top--];
    }
};

int main(int argc, const char * argv[]) {
    
    for(int tc=1; tc<=10; tc++){
        int N;
        string str;
        
        cin >> N;
        cin >> str;
        
        CustomStack stack = *new CustomStack(N+1);
        bool isPossible = true;
        
        for(int i=0; i<N; i++){
            char ch = str.at(i);
            if(ch == '(' || ch == '[' || ch == '{' || ch == '<'){
                stack.push(ch);
            }else{
                char pop = stack.pop();
                
                switch (ch) {
                    case ')':
                        isPossible = (pop == '(');
                        break;
                    case ']':
                        isPossible = (pop == '[');
                        break;
                    case '}':
                        isPossible = (pop == '{');
                        break;
                    case '>':
                        isPossible = (pop == '<');
                        break;
                    default:
                        isPossible = false;
                        break;
                }
            }
            if(!isPossible)
                break;
        }
        
        cout << "#" << tc << " " << (isPossible ? "1" : "0") << "\n";
    }
    
    return 0;
}
