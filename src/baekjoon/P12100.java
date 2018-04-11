package baekjoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class P12100 {
    static int N;
    static int [][] MAP;
    static int max = 0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        MAP = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                MAP[i][j] = scn.nextInt();
            }
        }
        dfs(0, MAP);
        System.out.println(max);
    }

    static void dfs(int depth, int [][] map){
        if(depth >= 5){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j] > max){
                        max = map[i][j];
                    }
                }
            }
        }else{
            for(int i=0; i<4; i++){ // 상하좌우
                int [][] newMap = moveData(map, i);
                dfs(depth + 1, newMap);
            }
        }
    }
    static int [][] moveData(int [][] map, int direction){
        int [][] newMap = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                newMap[i][j] = map[i][j];
            }
        }
        if(direction == 0){ // up
            for(int x=0; x<N; x++){
                Stack<Integer> stack = new Stack<>();
                for(int y=N-1; y>=0; y--){
                    if(newMap[y][x] != 0){
                        stack.add(newMap[y][x]);
                    }
                }
                Queue<Integer> queue = getMoveValue(stack);
                for(int y=0; y<N; y++){
                    if(queue.isEmpty()){
                        newMap[y][x] = 0;
                    }else{
                        newMap[y][x] = queue.remove();
                    }
                }
            }
        }else if(direction == 1){ // down
            for(int x=0; x<N; x++){
                Stack<Integer> stack = new Stack<>();
                for(int y=0; y<N; y++){
                    if(newMap[y][x] != 0){
                        stack.add(newMap[y][x]);
                    }
                }
                Queue<Integer> queue = getMoveValue(stack);
                for(int y=N-1; y>=0; y--){
                    if(queue.isEmpty()){
                        newMap[y][x] = 0;
                    }else{
                        newMap[y][x] = queue.remove();
                    }
                }
            }
        }else if(direction == 2){ // left
            for(int y=0; y<N; y++){
                Stack<Integer> stack = new Stack<>();
                for(int x=N-1; x>=0; x--){
                    if(newMap[y][x] != 0){
                        stack.add(newMap[y][x]);
                    }
                }
                Queue<Integer> queue = getMoveValue(stack);
                for(int x=0; x<N; x++){
                    if(queue.isEmpty()){
                        newMap[y][x] = 0;
                    }else{
                        newMap[y][x] = queue.remove();
                    }
                }
            }
        }else{ // right
            for(int y=0; y<N; y++){
                Stack<Integer> stack = new Stack<>();
                for(int x=0; x<N; x++){
                    if(newMap[y][x] != 0){
                        stack.add(newMap[y][x]);
                    }
                }
                Queue<Integer> queue = getMoveValue(stack);
                for(int x=N-1; x>=0; x--){
                    if(queue.isEmpty()){
                        newMap[y][x] = 0;
                    }else{
                        newMap[y][x] = queue.remove();
                    }
                }
            }
        }

        return newMap;
    }
    static Queue<Integer> getMoveValue(Stack<Integer> stack){
        Queue<Integer> queue = new LinkedList<>();
        while(!stack.isEmpty()){
            int value = stack.pop();
            if(!stack.isEmpty()){
                int compareValue = stack.peek();
                if(value == compareValue){
                    int newValue = value + compareValue;
                    queue.add(newValue);
                    stack.pop();
                }else{
                    queue.add(value);
                }
            }else{
                queue.add(value);
            }
        }
        return queue;
    }

}
