package d5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1242 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for(int testCase= 1; testCase<=T; testCase++) {

            int row = scn.nextInt();
            int col = scn.nextInt();

            ArrayList<String> codes = new ArrayList<>();

            for (int y = 0; y < row; y++) {
                String temp = scn.next();
                if (!isZeroRow(temp)) {
                    for(String code : codes){
                        temp = temp.replaceAll(code, "");
                    }

                    temp = temp.replaceAll("0", " ");
                    temp = temp.trim();
                    temp = temp.replaceAll(" ", "0");

                    if("".equals(temp))
                        continue;

                    String code2 = temp.replaceAll("0000", " ");
                    code2 = code2.trim();
                    String empty = "";
                    for(char c : code2.toCharArray()){
                        if (" ".equals(c + ""))
                            empty += " ";
                    }

                    if("".equals(empty)){
                        if(!temp.equals(""))
                            codes.add(temp);
                    }else {
                        for (String s : code2.split("\\s+")) {
                            String tmp = s + "";
                            tmp = tmp.replaceAll("0", " ");
                            tmp = tmp.trim();
                            tmp = tmp.replaceAll(" ", "0");
                            if (!tmp.equals(""))
                                codes.add(tmp);
                        }
                    }

                }
            }

            for(int i=0; i<codes.size(); i++){
                for(int j=0; j<codes.size(); j++){
                    if(j != i){
                        String temp = codes.get(i);
                        temp = temp.replaceAll(codes.get(j), "");
                        temp = temp.replaceAll("0", " ");
                        temp = temp.trim();
                        temp = temp.replaceAll(" ", "0");
                        codes.set(i, temp);
                    }
                }
            }

            for(int i=0; i<codes.size(); i++){
                String binary = hexToBinary(codes.get(i));
                codes.set(i, binary);
            }


            ArrayList<ArrayList<Integer>> convertedCodes = new ArrayList<>();
            for(String code : codes) {
                int len = 0;
                int count = code.length()/56;
                len = count * 7;
                int flagIndex = 0;
                boolean isContinually = false;
                ArrayList<Integer> foundCode = new ArrayList<>();
                for (int i = 0; i < code.length() - len; i++) {
                    String str = code.substring(i, i + len);
                    int num = decode(str);
                    if (num >= 0 && !isContinually) {
                        isContinually = true;
                        flagIndex = i;
                        foundCode.add(num);
                        i += (len-1);
                    } else if (num < 0 && isContinually) {
                        foundCode.clear();
                        isContinually = false;
                        i = flagIndex;
                    } else {

                        if (num < 0) {
                            continue;
                        } else {
                            foundCode.add(num);
                            i += (len-1);
                        }
                    }
                    if (foundCode.size() >= 8) {
                        break;
                    }
                }
                if(foundCode.size() > 0)
                    convertedCodes.add(foundCode);
            }

            int sum = 0;
            for(ArrayList<Integer> list : convertedCodes){
                int sumOfEven = 0, sumOfOdd = 0;
                for (int i = 0; i < 7; i++) {
                    if ((i + 1) % 2 == 0) {
                        sumOfOdd += list.get(i);
                    } else {
                        sumOfEven += list.get(i);
                    }
                }
                int parity = list.get(7);
                int check = sumOfEven * 3 + sumOfOdd + parity;
                if (check % 10 == 0) {
                    for(int i : list){
                        sum += i;
                    }
                }
            }

            System.out.println("#" + testCase + " " + sum);


        }
    }

    public static String hexToBinary(String hex){
        String binaryStr = new BigInteger(hex, 16).toString(2);
        int count = Math.round((float)binaryStr.length()/8 + 0.5f);
        String temp = "";
        for(int i=0; i<count/2; i++){ temp += "0"; }
        return temp + binaryStr + temp;
    }

    public static int decode(String s){
        int len = s.length()/7;
        String t1 = "";
        String t2 = "";
        for(int i=0; i<len; i++){
            t1 += "0";
            t2 += "1";
        }
        String convertedCode = s.replaceAll(t1, "0").replaceAll(t2, "1");
        switch (convertedCode){
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
        return str.replaceAll("0", "").length() <= 0;
    }
}
