package kakao;

import java.util.HashMap;

public class P19756 {
    public static void main(String[] args){
        String [] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        for(String s : solution(records)){
            System.out.print(s + " ");
        }
//        System.out.println(solution(records));

    }

    public static String[] solution(String[] record) {

        HashMap<String, String> nick = new HashMap<>();

        int numOfMsg = 0;

        for(String r : record){

            String [] parsingData = r.split(" ");

            switch (parsingData[0]){
                case "Enter":{
                    String uid = parsingData[1];
                    String nickname = parsingData[2];
                    nick.put(uid, nickname);
                    numOfMsg += 1;
                    break;
                }
                case "Leave":{
                    numOfMsg += 1;
                    break;
                }
                case "Change":{
                    String uid = parsingData[1];
                    String nickname = parsingData[2];
                    nick.put(uid, nickname);
                    break;
                }
            }

        }

        String[] answer = new String[numOfMsg];
        int index = 0;
        for(String r : record){
            String [] parsingData = r.split(" ");

            switch (parsingData[0]){
                case "Enter":{
                    String uid = parsingData[1];
                    String nickname = nick.get(uid);
                    answer[index] = String.format("%s님이 들어왔습니다.", nickname);
                    index += 1;
                    break;
                }
                case "Leave":{
                    String uid = parsingData[1];
                    String nickname = nick.get(uid);
                    answer[index] = String.format("%s님이 나갔습니다.", nickname);
                    index += 1;
                    break;
                }
            }
        }
        return answer;
    }
}
