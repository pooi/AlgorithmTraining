package d3;

import java.util.ArrayList;
import java.util.Scanner;

public class P1215 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase = 0; testCase < 10; testCase++){

            int targetLen = scn.nextInt();

            String[][] arr = new String[8][8];
            for(int i=0; i<8; i++){
                String temp = scn.next();
                for(int j=0; j<8; j++){
                    arr[i][j] = temp.charAt(j) + "";
                }
            }

            int count = 0;
            for(int i=0; i<8; i++){
                String str = String.join("", arr[i]);
                count = checkMaxPalindrome(targetLen, count, str);

            }

            arr = transpose(arr);
            for(int i=0; i<8; i++){
                String str = String.join("", arr[i]);
                count = checkMaxPalindrome(targetLen, count, str);

            }

            System.out.println("#" + testCase + " " + count);
//            System.out.println(MAXIMUM);

        }

    }

    public static String[][] transpose(String[][] arr){

        for(int i=0; i<8; i++){
            for(int j=i; j<8; j++){

                String temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }

        return arr;

    }

    public static int checkMaxPalindrome(int targetLen, int count, String str){

        ArrayList<Integer> indexA = new ArrayList<>();
        ArrayList<Integer> indexB = new ArrayList<>();
        ArrayList<Integer> indexC = new ArrayList<>();

        for(int j=0; j<8; j++){
            String temp = str.charAt(j) + "";
            if(temp.equals("A"))
                indexA.add(j);
            else if(temp.equals("B"))
                indexB.add(j);
            else
                indexC.add(j);
        }

        ArrayList<Integer> indexList = (ArrayList<Integer>)indexA.clone();
        for(int k1=0; k1<indexList.size()-1; k1++){
            for(int k2=k1+1; k2<indexList.size(); k2++){

                if(indexList.get(k2) - indexList.get(k1) + 1 != targetLen){
                    continue;
                }

                int index1 = indexList.get(k1);
                int index2 = indexList.get(k2);

                int len = isPalindrome(str.substring(index1, index2+1));
                if(len > 0){
                    count += 1;
                }

            }
        }

        indexList = (ArrayList<Integer>)indexB.clone();
        for(int k1=0; k1<indexList.size()-1; k1++){
            for(int k2=k1+1; k2<indexList.size(); k2++){

                if(indexList.get(k2) - indexList.get(k1) + 1 != targetLen){
                    continue;
                }

                int index1 = indexList.get(k1);
                int index2 = indexList.get(k2);

                int len = isPalindrome(str.substring(index1, index2+1));
                if(len > 0){
                    count += 1;
                }

            }
        }

        indexList = (ArrayList<Integer>)indexC.clone();
        for(int k1=0; k1<indexList.size()-1; k1++){
            for(int k2=k1+1; k2<indexList.size(); k2++){

                if(indexList.get(k2) - indexList.get(k1) + 1 != targetLen){
                    continue;
                }

                int index1 = indexList.get(k1);
                int index2 = indexList.get(k2);

                int len = isPalindrome(str.substring(index1, index2+1));
                if(len > 0){
                    count += 1;
                }

            }
        }

        return count;

    }

    public static int isPalindrome(String str){

        int len = str.length();
        for(int i=0; i<len/2; i++){

            String pre = str.charAt(i) + "";
            String post = str.charAt(len-i-1) + "";

            if(!pre.equals(post))
                return 0;

        }


        return len;

    }

}
