package line;

import java.util.Scanner;
import java.util.StringTokenizer;

public class P001 {

    public static void main(String[] args){
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        int m = 20_000;
        boolean isFinish = false;
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            // @todo Write your code here.
            if(!isFinish){
                if(4 <= distance && distance <= 178){
                    int c = cost(distance);
                    if(m-c < 0){
                        isFinish = true;
                    }else {
                        m -= c;
                    }
                }else{
                    isFinish = true;
                }
            }
        }

        System.out.println(m);
        // @todo Write your code here.
    }

    public static int cost(int distance){
        int m = 720;
        if(distance <= 40){
            return m;
        }else{
            m += ((distance-40)/8 + (distance % 8 == 0 ? 0 : 1 )) * 80;
        }
        return m;
    }
}
