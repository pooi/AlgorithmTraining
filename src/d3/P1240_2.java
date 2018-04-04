package d3;

import java.util.ArrayList;
import java.util.Scanner;

public class P1240_2 {
    static String [] map;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){

            int W, H;
            H = scn.nextInt();
            W = scn.nextInt();

            map = new String[H];

            for(int i=0; i<H; i++){
                map[i] = scn.next();
            }

            String code = "";
            for(int i=0; i<H; i++){
                String str = map[i];
                if(str.indexOf("1") > 0){
                    for(int j=str.length()-1; j>=0; j--){
                        String ch = str.charAt(j) + "";
                        if(ch.equals("1")){
                            code = str.substring((j+1)-56, j+1);
                            break;
                        }
                    }
                }
                if(!code.equals(""))
                    break;
            }

            ArrayList<Integer> codes = new ArrayList<>();
            for(int k=0; k<code.length()-6; k++){
                int num = getCode(code.substring(k, k+7));
                if(num >= 0){
                    codes.add(num);
                    k += 6;
                }
                if(codes.size()>= 8)
                    break;
            }

            int sumOdd = 0, sumEven = 0;
            for(int i=0; i<codes.size(); i++){
                if((i+1) % 2 == 1){
                    sumOdd += codes.get(i);
                }
            }
            for(int i=0; i<codes.size()-1; i++){
                if((i+1) % 2 == 0){
                    sumEven += codes.get(i);
                }
            }
            int result = sumOdd * 3 + sumEven + codes.get(codes.size()-1);
            System.out.println(String.format("#%d %d", testCase, (result % 10 == 0 ? sumOdd + sumEven + codes.get(codes.size()-1) : 0)));

        }

    }

    static int getCode(String str){
        int code = -1;
        switch (str){
            case "0001101":
                code = 0;
                break;
            case "0011001":
                code = 1;
                break;
            case "0010011":
                code = 2;
                break;
            case "0111101":
                code = 3;
                break;
            case "0100011":
                code = 4;
                break;
            case "0110001":
                code = 5;
                break;
            case "0101111":
                code = 6;
                break;
            case "0111011":
                code = 7;
                break;
            case "0110111":
                code = 8;
                break;
            case "0001011":
                code = 9;
                break;
        }
        return code;
    }
}
