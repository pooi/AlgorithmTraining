package kakao;

public class P19759 {

    public static void main(String [] args){
        int [] food_times = {3, 1, 2};
        System.out.println(solution(food_times, 5));
    }

    public static int solution(int[] food_times, long k) {

        int index = 0;
        int time = 0;
        boolean isAll = false;
        while(k > 0){
//            if(time == food_times.length){
//                isAll = true;
//                break;
//            }
            if(food_times[index] <= 0){
//                time += 1;
                continue;
            }else {
                time = 0;
                food_times[index] -= 1;
//                index = (index+1)%food_times.length;
                k-=1;
            }
            index = (index+1)%food_times.length;
        }

        if(!isAll) {
            while (true) {
                index = (index+1)%food_times.length;
                if(food_times[index] > 0){
                    break;
                }
            }
        }else{
            index = -1;
        }

        int answer = index;
        return answer;
    }

}
