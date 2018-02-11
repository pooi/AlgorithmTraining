package d3;

import java.util.ArrayList;
import java.util.Scanner;

public class P1240 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for(int testCase= 1; testCase<=T; testCase++) {

            int row = scn.nextInt();
            int col = scn.nextInt();

            String code = "";
            for (int y = 0; y < row; y++) {
                String temp = scn.next();
                if (!isZeroRow(temp)) {
                    code = temp;
                }
            }

            int flagIndex = 0;
            boolean isContinually = false;
            ArrayList<Integer> codes = new ArrayList<>();
            for (int i = 0; i < code.length() - 7; i++) {
                String str = code.substring(i, i + 7);
                int num = decode(str);
                if(num >= 0 && !isContinually){
                    isContinually = true;
                    flagIndex = i;
                    codes.add(num);
                    i += 6;
                } else if (num < 0 && isContinually) {
                    codes.clear();
                    isContinually = false;
                    i = flagIndex;
                } else {

                    if(num < 0){
                        continue;
                    }else{
                        codes.add(num);
                        i += 6;
                    }
                }
                if(codes.size() >= 8){
                    break;
                }
            }

            int sumOfEven = 0, sumOfOdd = 0;
            for (int i = 0; i < 7; i++) {
                if ((i + 1) % 2 == 0) {
                    sumOfOdd += codes.get(i);
                } else {
                    sumOfEven += codes.get(i);
                }
            }
            int parity = codes.get(7);
            int check = sumOfEven * 3 + sumOfOdd + parity;
            if (check % 10 == 0) {
                int sum = sumOfEven + sumOfOdd + parity;
                System.out.println("#" + testCase + " " + sum);
            } else {
                System.out.println("#" + testCase + " " + 0);
            }
        }
    }

    public static int decode(String s){
        switch (s){
            case "0001101":
                return 0;
            case "0011001":
                return 1;
            case "0010011":
                return 2;
            case "0111101":
                return 3;
            case "0100011":
                return 4;
            case "0110001":
                return 5;
            case "0101111":
                return 6;
            case "0111011":
                return 7;
            case "0110111":
                return 8;
            case "0001011":
                return 9;
        }
        return -1;
    }

    public static boolean isZeroRow(String str){
        return str.indexOf("1") < 0;
    }
}
