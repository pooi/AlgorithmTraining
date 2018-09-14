package kakao;

import java.util.ArrayList;

public class P17681 {

    public static int LEN = 0;

    public static void main(String[] args){
        int n = 5;
        int [] arr1 = {9, 20, 28, 18, 11};
        int [] arr2 = {30, 1, 21, 17, 28};
        solution(n, arr1, arr2);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        boolean [][] map1 = makeMap(n, arr1);
        boolean [][] map2 = makeMap(n, arr2);

        for(int i=0; i<n; i++){
            String str = "";
            for(int j=LEN-1; j>=0; j--){
                if(map1[i][j] || map2[i][j]){
                    str += "#";
                }else{
                    str += " ";
                }
            }
            answer[i] = str;
        }

        for(String str : answer){
            System.out.print(str + " ");
        }

        return answer;
    }

    public static boolean[][] makeMap(int n, int [] arr){

        int len = (int)Math.pow(2, n);
        boolean [][] map = new boolean[n][len];

        for(int i=0; i<n; i++){
            int num = arr[i];
            ArrayList<Integer> list = new ArrayList<>();
            binary(num, list);

            if(LEN < list.size()){
                LEN = list.size();
            }

            for(int j=0; j<len; j++){
                if(j < list.size()){
                    map[i][j] = list.get(j) == 1;
                }else{
                    map[i][j] = false;
                }
            }

        }

        return map;

    }


    public static void binary(int num, ArrayList<Integer> list){
        if(num <= 0){
            return;
        }else{
            list.add(num%2);
            binary(num/2, list);
        }
    }

}
