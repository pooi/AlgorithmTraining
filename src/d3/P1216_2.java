package d3;

import java.util.Scanner;

public class P1216_2 {

    static public void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int T = 10;
        for(int testCase=1; testCase<=T; testCase++){
            int num = scn.nextInt();
            char [][] map = new char[100][100];

            for(int i=0; i<100; i++){
                String str = scn.next();
                for(int j=0; j<str.length(); j++){
                    map[i][j] = str.charAt(j);
                }
            }

            int max = 1;
            int step = 1;
            for(int i=0; i<100; i++){
                step = max;
                for(int k=step; k<100; k++){
                    for(int j=0; j<100-k; j++){
                        String str = getStr(map[i], j, j+k);
                        String reverseStr = getReverseStr(map[i], j, j+k);
                        if(str.equals(reverseStr)){
                            if(str.length() > max){
                                max = str.length();
                                k = max;
                                break;
                            }
                        }

                    }
                }
            }

            for(int i=0; i<100; i++) {
                for (int j = i; j < 100; j++) {
                    char temp = map[i][j];
                    map[i][j] = map[j][i];
                    map[j][i] = temp;
                }
            }

            for(int i=0; i<100; i++){
                step = max;
                for(int k=step; k<100; k++){
                    for(int j=0; j<100-k; j++){
                        String str = getStr(map[i], j, j+k);
                        String reverseStr = getReverseStr(map[i], j, j+k);
                        if(str.equals(reverseStr)){
                            if(str.length() > max){
                                max = str.length();
                                k = max;
                                break;
                            }
                        }

                    }
                }
            }

            System.out.println(String.format("#%d %d", testCase, max));

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
