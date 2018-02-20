package d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1238 {

    public static int [][]map;
    public static boolean []visited;
    public static int []depths;
    public static int ans;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=10; testCase++){

            map = new int[101][101];
            visited = new boolean[101];
            depths = new int[101];
            ans = -1;

            int total = scn.nextInt();
            int start = scn.nextInt();

            for(int i=0; i<total/2; i++){
                int pre = scn.nextInt();
                int post = scn.nextInt();

                map[pre][post] = 1;
            }
            search(start);

            System.out.println("#" + testCase + " " + ans);

        }

    }

    public  static void search(int pos){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(pos);
        visited[pos] = true;
        ans = pos;
        while (!queue.isEmpty()){
            int size = queue.size();
            int max = -1;
            for(int i=0; i<size; i++){
                int num = queue.remove();
                for(int k=0; k<101; k++){
                    if(visited[k])
                        continue;
                    if(map[num][k] == 1){
                        queue.add(k);
                        visited[k] = true;
                        max = Math.max(max, k);
                    }

                }
            }
            if(!queue.isEmpty()){
                ans = max;
            }
        }
    }
}
