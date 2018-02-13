package d4;

import java.util.ArrayList;
import java.util.Scanner;

public class P1219 {

    public static boolean []visited;
    public static int [][]map;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testStep=1; testStep<=10; testStep++){

            map = new int[101][101];
            visited = new boolean[101];

            int step = scn.nextInt();
            int count = scn.nextInt();

            for(int i=0; i<count; i++){
                int pre = scn.nextInt();
                int post = scn.nextInt();

                map[pre][post] = 1;
            }

            boolean result = DFS(0);

            System.out.println("#" + step + " " + (result ? "1" : "0"));

        }

    }

    public static boolean DFS(int index){

        visited[index] = true;

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<100; i++)
            if(map[index][i] == 1)
                list.add(i);

        if(list.contains(99)){
            return true;
        }else {
            for (int in : list) {
                if (!visited[in]) {
                    if(DFS(in)){
                        return true;
                    }
                }
            }
        }

        return false;

    }

}
