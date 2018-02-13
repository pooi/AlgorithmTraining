package d4;

import java.util.Scanner;

public class P1231 {

    public static String []tree;
    public static int count;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=10; testCase++){

            count = scn.nextInt();

            tree = new String[count+1];

            for(int i=0; i<count; i++){
                int index = scn.nextInt();
                String str = scn.next();
                tree[index] = str;
                if(index*2 <= count) { int temp1 = scn.nextInt(); }
                if(index*2+1 <= count) { int temp = scn.nextInt(); }
            }

            System.out.print("#" + testCase + " ");
            inorder(1);
            System.out.println();
        }

    }

    public static void inorder(int index){

        if(index > count){
            return;
        }

        inorder(index*2);
        System.out.print(tree[index]);
        inorder(index*2+1);

    }

}
