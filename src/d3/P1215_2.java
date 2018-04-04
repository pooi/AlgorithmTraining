package d3;

import java.util.Scanner;

public class P1215_2 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = 10;
        for(int testCase=1; testCase<=T; testCase++){

            int len = scn.nextInt();
            char [][] map = new char[8][8];

            for(int i=0; i<8; i++){
                String str = scn.next();
                for(int j=0; j<str.length(); j++){
                    map[i][j] = str.charAt(j);
                }
            }

            int count = 0;
            for(int i=0; i<8; i++){
                for(int j=0; j<=8-len; j++) {
                    String str = getStr(map[i], j, j+len);
                    String reverseStr = getReverseStr(map[i], j, j+len);
                    if(str.equals(reverseStr))
                        count+=1;
                }
            }

            for(int i=0; i<8; i++) {
                for (int j = i; j < 8; j++) {
                    char temp = map[i][j];
                    map[i][j] = map[j][i];
                    map[j][i] = temp;
                }
            }

            for(int i=0; i<8; i++){
                for(int j=0; j<=8-len; j++) {
                    String str = getStr(map[i], j, j+len);
                    String reverseStr = getReverseStr(map[i], j, j+len);
                    if(str.equals(reverseStr))
                        count+=1;
                }
            }

            System.out.println(String.format("#%d %d", testCase, count));

        }
    }

    static public String getStr(char [] arr, int start, int finish){
        String str = "";
        for(int i=start; i<finish; i++){
            str += arr[i];
        }
        return str;
    }
    static public String getReverseStr(char [] arr, int start, int finish){
        String str = "";
        for(int i=finish-1; i>=start; i--){
            str += arr[i];
        }
        return str;
    }
}
