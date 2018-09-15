package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class P17680 {

    public static void main(String[] args){
        String [] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(solution(0, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        if(cacheSize == 0){
            answer = cities.length * 5;
        }else {
            for (String c : cities) {
                String city = c.toLowerCase();
                if (queue.size() < cacheSize) {
                    if (queue.contains(city)) {
                        answer += 1;
                        int index = ((LinkedList<String>) queue).indexOf(city);
                        ((LinkedList<String>) queue).remove(index);
                        queue.add(city);
                    } else {
                        queue.add(city);
                        answer += 5;
                    }
                } else {

                    if (queue.contains(city)) {
                        answer += 1;
                        int index = ((LinkedList<String>) queue).indexOf(city);
                        ((LinkedList<String>) queue).remove(index);
                        queue.add(city);
                    } else {
                        answer += 5;
                        queue.remove();
                        queue.add(city);
                    }

                }
            }
        }
        return answer;
    }

}
