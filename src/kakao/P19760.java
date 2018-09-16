package kakao;

import java.util.ArrayList;
import java.util.Stack;

public class P19760 {
    public static void main(String[] args){
        int [][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        solution(nodeinfo);
    }

    static Node top;
    static ArrayList<Integer> leftList, rightList;
    static int[][] nodeinfos;

    public static int[][] solution(int[][] nodeinfo) {

        nodeinfos = nodeinfo;

        int maxX = 0, maxY = 0;
        for(int [] node : nodeinfo){
            if(maxX < node[0]){
                maxX = node[0];
            }
            if(maxY < node[1]){
                maxY = node[1];
            }
        }
//
//        boolean [][] map = new boolean[maxY+1][maxX+1];
//        boolean [][] visited = new boolean[maxY+1][maxX+1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<100001; i++){
            list.add(new ArrayList<>());
        }

        top = new Node(0,0);
        for(int [] node : nodeinfo){
            if(!top.isHigher(node)){
                top = new Node(node);
            }
            list.get(node[1]).add(node[0]);
//            map[node[1]][node[0]] = true;
        }

        Stack<Integer> standRight = new Stack<>();
        standRight.push(maxX);

//        Stack<Node> leftStack = new Stack<>();
//        Stack<Node> rightStack = new Stack<>();

//        while(!leftStack.empty() || !rightStack.empty()){
        Node stand = top;
//        while(stand != null){
//
//            if(!stand.finishLeft){
//                stand.finishLeft = true;
//                standRight.push(stand.x);
//                Node child = null;
//                for(int y=stand.y-1; y>=0; y--){
//                    for(int x=stand.x-1; x>=0; x--){
//                        if(!visited[y][x]) {
//                            visited[y][x] = true;
//                            if (map[y][x]) {
//                                child = new Node(x, y);
//                                map[y][x] = false;
//                                break;
//                            }
//                        }else{
//                            y = 0;
//                        }
//                    }
//                    if(child != null){
//                        child.parent = stand;
//                        stand.left = child;
//                        stand = child;
//                        break;
//                    }
//                }
//
//
//            }else if(!stand.finishRight){
//
//                stand.finishRight = true;
//                standRight.pop();
//                Node child = null;
//                for(int y=stand.y-1; y>=0; y--){
//                    for(int x=stand.x+1; x<=standRight.peek(); x++){
//                        if(!visited[y][x]) {
//                            visited[y][x] = true;
//                            if (map[y][x]) {
//                                child = new Node(x, y);
//                                map[y][x] = false;
//                                break;
//                            }
//                        }else{
//                            y = 0;
//                        }
//                    }
//                    if(child != null){
//                        child.parent = stand;
//                        stand.right = child;
//                        stand = child;
//                        break;
//                    }
//                }
//
//
//            }else{
//                stand = stand.parent;
//            }
//
//        }
//
//        leftList = new ArrayList<>();
//        rightList = new ArrayList<>();
//
//        findLeft(top);
//        findRight(top);



        int[][] answer = new int[2][leftList.size()];

        for(int i=0; i<leftList.size(); i++){
            answer[0][i] = leftList.get(i);
            answer[1][i] = rightList.get(i);
        }

        return answer;
    }

    public static void findLeft(Node node){
        if(node != null) {
            leftList.add(findIndex(node));
            findLeft(node.left);
            findLeft(node.right);
        }
    }

    public static void findRight(Node node){
        if(node != null) {
            findRight(node.left);
            findRight(node.right);
            rightList.add(findIndex(node));
        }
    }

    public static int findIndex(Node node){
        for(int i=0; i<nodeinfos.length; i++){
            if(node.isSame(nodeinfos[i])){
                return i+1;
            }
        }
        return 0;
    }

    public static class Node{
        int x, y;
        Node parent;
        Node left, right;
        boolean finishRight, finishLeft;
        public Node(int [] node){
            this.x = node[0];
            this.y = node[1];
        }
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean isHigher(int [] node){
            return node[1] < this.y;
        }
        public boolean isSame(int [] node){
            return this.x == node[0] && this.y == node[1];
        }
    }
}
