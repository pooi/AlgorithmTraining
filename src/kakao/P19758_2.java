package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class P19758_2 {
    public static void main(String[] args){
        String [][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        System.out.println(solution(relation));
    }

    public static Stack<Integer> stack;
    public static int column;

    public static ArrayList<Integer[]> subsets;

    public static int solution(String[][] relation) {

        column = relation[0].length;

        subsets = new ArrayList<>();

        for(int i=1; i<=column; i++){
            stack = new Stack<>();
            dfs(i, 0);
        }

        boolean [] check = new boolean[subsets.size()];

        int answer = 0;
        for(int i=0; i<subsets.size(); i++){
            if(!check[i]){
                HashMap<String, String> keys = new HashMap<>();
                for(String [] row : relation){
                    String key = "";
                    for(int index : subsets.get(i)){
                        key += row[index] + "_";
                    }
                    keys.put(key, "");
                }
                if(relation.length == keys.size()){
                    System.out.println(keys.keySet());
                    answer += 1;
                    boolean [] checkC = new boolean[column];
                    for(int s : subsets.get(i)){
                        checkC[s] = true;
                    }
                    for(int j=0; j<subsets.size(); j++){
                        boolean [] check2 = new boolean[column];
                        for(int s : subsets.get(j)){
                            check2[s] = true;
                        }
                        int sameCount = 0;
                        for(int c=0; c<column; c++){
                            if(checkC[c] && check2[c]){
                                sameCount += 1;
                            }
                        }
                        if(sameCount >= subsets.get(i).length){
                            check[j] = true;
                        }
                    }
                }


            }
        }

        return answer;
    }

    public static void dfs(int depth, int start){
        if(stack.size() == depth){
            Integer [] subset = new Integer[stack.size()];
            int i = 0;
            for(int index : stack){
                subset[i] = index;
                i++;
            }
            subsets.add(subset);
        }else{
            for(int i=start; i<column; i++){
                stack.push(i);
                dfs(depth, i+1);
                stack.pop();
            }
        }
    }

}
