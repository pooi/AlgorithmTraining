package d3;

import java.util.ArrayList;
import java.util.Scanner;

public class P1229 {

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=10; testCase++){

            int len = scn.nextInt();
            ArrayList<Integer> list = new ArrayList<>();

            for(int i=0; i<len; i++){
                list.add(scn.nextInt());
            }

            int lenOfInst = scn.nextInt();

            for(int i=0; i<lenOfInst; i++){

                String instruction = scn.next();

                if(instruction.equals("I")){

                    int insertIndex = scn.nextInt();
                    int numOfInsert = scn.nextInt();

                    ArrayList<Integer> tempList = new ArrayList<>();
                    for(int k=0; k<numOfInsert; k++){
                        tempList.add(scn.nextInt());
                    }

                    list.addAll(insertIndex, tempList);

                }else{

                    int delIndex = scn.nextInt();
                    int numOfDel = scn.nextInt();

                    for(int k=0; k<numOfDel; k++){
                        list.remove(delIndex);
                    }

                }

            }

            System.out.print("#" + testCase + " ");
            for(int i=0; i<10; i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();

        }

    }
}
