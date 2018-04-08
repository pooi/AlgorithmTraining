package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class P14891 {
    static int N;
    static int [][] list;
    static ArrayList<Integer> [] map;
    static int [][] DIRECT = {
            {0, 1,  1, 2,  2, 3}, // 0
            {1, 0,  1, 2,  2, 3}, // 1
            {2, 3,  2, 1,  1, 0}, // 2
            {3, 2,  2, 1,  1, 0} // 3
    };
    static int [] SCORE = {
            1, 2, 4, 8
    };
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        map = new ArrayList[4];
        for(int i=0; i<4; i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<4; i++){
            String s = scn.next();
            for(int k=0; k<s.length(); k++){
                map[i].add(Integer.parseInt(s.charAt(k)+ ""));
            }
        }
        N = scn.nextInt();
        list = new int[N][2];
        for(int i=0; i<N; i++){
            list[i][0] = scn.nextInt();
            list[i][1] = scn.nextInt();
        }

        for(int i=0; i<N; i++){

            int pre = list[i][0] - 1;
            int direction = list[i][1];

            int [] rotate = new int[4];
            rotate[pre] = direction;

            for(int j=0; j<DIRECT[pre].length; j+=2){
                int stand = DIRECT[pre][j];
                int post = DIRECT[pre][j+1];

                if(stand < post){
                    if(map[stand].get(2) != map[post].get(6)){
                        rotate[post] = rotate[stand] * -1;
                    }
                }else{
                    if(map[stand].get(6) != map[post].get(2)){
                        rotate[post] = rotate[stand] * -1;
                    }
                }
            }

            for(int j=0; j<rotate.length; j++){
                if(rotate[j] == 1){
                    int temp = map[j].get(7);
                    map[j].remove(7);
                    map[j].add(0, temp);
                }else if(rotate[j] == -1){
                    int temp = map[j].get(0);
                    map[j].remove(0);
                    map[j].add(temp);
                }
            }

        }


        int score = 0;
        for(int i=0; i<4; i++){
            if(map[i].get(0) == 1){
                score += SCORE[i];
            }
        }

        System.out.println(score);
    }
}
