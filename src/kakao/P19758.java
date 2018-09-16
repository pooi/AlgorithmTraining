package kakao;

import java.util.HashMap;
import java.util.Stack;

public class P19758 {
    public static void main(String[] args){
        String [][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        System.out.println(solution(relation));
    }

    public static int count = 0;
    public static boolean [] check;
    public static boolean [] tempCheck;
    public static Stack<Integer> stack;
    public static String [][] relations;
    public static int column;

    public static int solution(String[][] relation) {

        relations = relation;
        column = relation[0].length;

        check = new boolean[column];


        for(int i=1; i<=column; i++){
            stack = new Stack<>();
            tempCheck = new boolean[column];
            dfs(i, 0);
            for(int j=0; j<tempCheck.length; j++){
                if(tempCheck[j]){
                    check[j] = true;
                }
            }
        }

        int answer = count;
        return answer;
    }

    public static void dfs(int depth, int start){
        if(stack.size() == depth){
            HashMap<String, String> keys = new HashMap<>();
            for(String [] row : relations){
                String key = "";
                for(int index : stack){
                    key += row[index] + "_";
                }
                keys.put(key, "");
            }
            if(relations.length == keys.size()){
                for(int index : stack){
                    tempCheck[index] = true;
                }
                count += 1;
            }
        }else{
            for(int i=start; i<column; i++){
                if(!check[i]){
                    stack.push(i);
                    dfs(depth, i+1);
                    stack.pop();
                }
            }
        }
    }

}
