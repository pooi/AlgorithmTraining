package d5;

import java.util.ArrayList;
import java.util.Scanner;

public class P1248 {

    public static ArrayList<Tree> tree;
    public static int count;

    static class Tree{
        int parent = 0;
        ArrayList<Integer> child = new ArrayList<>();
    }

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase<=T; testCase++){

            int N = scn.nextInt();
            int V = scn.nextInt();
            int node1 = scn.nextInt();
            int node2 = scn.nextInt();

            count = 0;
            tree = new ArrayList<>();

            for(int i=0; i<N+2; i++){ tree.add(new Tree()); }

            for(int i=1; i<=V; i++){
                int pre = scn.nextInt();
                int post = scn.nextInt();

                tree.get(pre).child.add(post);
                tree.get(post).parent = pre;
            }

            ArrayList<Integer> first = new ArrayList<>();
            Tree temp = tree.get(node1);
            while(temp.parent > 0){
                first.add(temp.parent);
                temp = tree.get(temp.parent);
            }

            ArrayList<Integer> second = new ArrayList<>();
            temp = tree.get(node2);
            while(temp.parent > 0){
                second.add(temp.parent);
                temp = tree.get(temp.parent);
            }

            int minParent = 0;
            for(int k : first){
                if(second.contains(k)){
                    minParent = k;
                    break;
                }
            }

            findChild(minParent);

            System.out.println("#" + testCase + " " + minParent + " " + count);

        }
    }

    public static void findChild(int pos){
        count+=1;
        ArrayList<Integer> child = tree.get(pos).child;
        for(int c : child){
            findChild(c);
        }
    }
}
