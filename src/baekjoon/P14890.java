package baekjoon;

import java.util.*;

public class P14890 {
    static int N, L;
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        L = scn.nextInt();

        int [][] map = new int[N][N];
        for(int y=0; y<N; y++){
            for(int x=0; x<N; x++){
                map[y][x] = scn.nextInt();
            }
        }

        int count = 0;
        for(int k=0; k<N; k++){
            Queue<Integer> queue = new LinkedList<>();
            for(int i=0; i<N; i++){
                queue.add(map[k][i]);
            }

            if(search(queue)){
                count += 1;
//                System.out.println("True");
            }

            queue = new LinkedList<>();
            for(int i=0; i<N; i++){
                queue.add(map[i][k]);
            }

            if(search(queue)){
                count += 1;
//                System.out.println("True");
            }

        }

        System.out.println(count);

    }

    static boolean search(Queue<Integer> queue){
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty() || list.size() > 0){

            while(list.size() < L+1 && !queue.isEmpty()){
                list.add(queue.remove());
            }

            if(list.size() < L+1){

                if(list.size() < 2){
                    break;
                }else {

                    if (list.get(0) == list.get(1)) {
                        list.remove(0);
                    } else {
                        return false;
                    }

                }

            }else {
                if (isPossible(list)) {
                    if (!queue.isEmpty() && list.get(list.size() - 1) != queue.peek()) {
                        if(L == 1 && list.get(0) > list.get(1) && list.get(1) < queue.peek()){
                            return false;
                        }
                        int temp = list.get(list.size() - 1);
                        list.clear();
                        list.add(temp);
                        continue;
                    }else{
                        list.clear();
                    }
                } else {
                    if (list.get(0) == list.get(1)) {
                        list.remove(0);
                    } else {
                        return false;
                    }
                }
            }

        }

        return true;
    }

    static boolean isSameRow(int [] list){
        boolean check = true;
        for(int i=0; i<list.length-1; i++){
            if(list[i] != list[i+1]){
                check = false;
                break;
            }
        }
        return check;
    }

    static boolean isPossible(ArrayList<Integer> list){

        int stand1, stand2;
        stand1 = list.get(0);
        stand2 = list.get(list.size()-1);

        boolean check = true;
        for(int i=1; i<list.size()-1; i++){
            if(list.get(i) != list.get(i+1)){
                check = false;
                break;
            }
        }
        if(check && stand1-1 == list.get(1)){
            return true;
        }

        check = true;
        for(int i=0; i<list.size()-2; i++){
            if(list.get(i) != list.get(i+1)){
                check = false;
                break;
            }
        }
        if(check && stand2-1 == list.get(0)){
            return true;
        }

        return false;

    }
}
