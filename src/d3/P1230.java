package d3;

import java.util.ArrayList;
import java.util.Scanner;

public class P1230 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        for(int testCase=1; testCase<=10; testCase++) {
            int N = scn.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(scn.nextInt());
            }

            int O = scn.nextInt();
            for (int i = 0; i < O; i++) {
                String op = scn.next();
                switch (op) {
                    case "I": {
                        int x = scn.nextInt();
                        int y = scn.nextInt();
                        ArrayList<Integer> tempList = new ArrayList<>();
                        for (int k = 0; k < y; k++) {
                            tempList.add(scn.nextInt());
                        }
                        list.addAll(x, tempList);
                        break;
                    }
                    case "D": {
                        int x = scn.nextInt();
                        int y = scn.nextInt();
                        for (int k = 0; k < y; k++) {
                            list.remove(x);
                        }
                        break;
                    }
                    case "A": {
                        int y = scn.nextInt();
                        for (int k = 0; k < y; k++) {
                            list.add(scn.nextInt());
                        }
                        break;
                    }
                }
            }

            System.out.print("#" + testCase + " ");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) +  " ");
            }
            System.out.println();
        }
    }
}
