package d4;

import java.util.*;

public class P1232 {

    static class Node{
        Integer pre, post;
        String value;
    }

    public static Queue<String> queue;
    public static Node [] tree;


    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        for(int testCase=1; testCase<=10; testCase++){

            int row = scn.nextInt();
            tree = new Node[row+1];

            for(int i=0; i<row+1; i++){
                String line = scn.nextLine();
                line = line.trim();
                String [] tempList = line.split(" ");
                Node node = new Node();
                if(tempList.length >= 2){
                    tree[Integer.parseInt(tempList[0])] = node;
                    node.value = tempList[1];
                }
                if (tempList.length >= 3) {
                    node.pre = Integer.parseInt(tempList[2]);
                }
                if(tempList.length >= 4){
                    node.post = Integer.parseInt(tempList[3]);
                }
            }

            queue = new LinkedList<>();
            search(tree[1]);

            Stack<Double> stack = new Stack<>();
            String operation = "+-*/";

            while(!queue.isEmpty()){
                String s = queue.remove();
                if(operation.indexOf(s) < 0){ // num
                    stack.push(Double.parseDouble(s));
                }else{
                    Double post = stack.pop();
                    Double pre = stack.pop();
                    stack.push(calc(s, pre, post));
                }
            }

            System.out.println(String.format("#%d %.0f", testCase, stack.pop()));

        }

    }

    public static Double calc(String op, Double pre, Double post){
        Double result;
        switch (op){
            case "+":
                result = pre + post;
                break;
            case "-":
                result = pre - post;
                break;
            case "*":
                result = pre * post;
                break;
            case "/":
                result = pre / post;
                break;
            default:
                result = 0.0;
                break;
        }
        return result;
    }

    public static void search(Node node){
        if(node == null)
            return;
        if(node.pre != null)
            search(tree[node.pre]);
        if(node.post != null)
            search(tree[node.post]);
        queue.add(node.value);
    }
}
