package kakao;

import java.util.ArrayList;
import java.util.Collections;

public class P19757 {
    public static void main(String[] args){

        int [] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        for(int s : solution(5, stages)){
            System.out.print(s + " ");
        }
//        System.out.println(solution(5, stages));

    }

    public static int[] solution(int N, int[] stages) {

        int [] counts = new int[N+2];

        for(int stage : stages){
            counts[stage] += 1;
        }

        int [] dp = new int[N+2];
        dp[N+1] = counts[N+1];
        for(int i=N; i>0; i--){
            dp[i] = dp[i+1] + counts[i];
        }

        class Temp implements Comparable{
            int stage;
            double fail;
            public Temp(int stage, double fail){
                this.stage = stage;
                this.fail = fail;
            }

            @Override
            public int compareTo(Object o) {
                Temp t1 = this;
                Temp t2 = (Temp)o;
                if(t1.fail == t2.fail){
                    return t1.stage - t2.stage;
                }else{
                    if(t2.fail > t1.fail){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        }

        ArrayList<Temp> list = new ArrayList<>();
        for(int i=1; i<N+1; i++){
            double fail = 0;
            if(dp[i] == 0){
                fail = 0;
            }else{
                fail = (double)counts[i] / dp[i];
            }
            list.add(new Temp(i, fail));
        }


        Collections.sort(list);

        int[] answer = new int[N];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).stage;
        }
        return answer;
    }
}
