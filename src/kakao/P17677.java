package kakao;

public class P17677 {

    public static void main(String[] args){

        System.out.println(solution("FRANCE", "french"));

    }

    public static int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        String ALPHA = "abcdefghijklmnopqrstuvwxyz";

        int [][] map1 = new int[28][28];
        int [][] map2 = new int[28][28];
//        int [][] intersection = new int[28][28];

        for(int i=0; i<str1.length()-1; i++){
            String a = str1.charAt(i) + "";
            String b = str1.charAt(i+1) + "";

            if(ALPHA.contains(a) && ALPHA.contains(b)){
                int indexA = ALPHA.indexOf(a);
                int indexB = ALPHA.indexOf(b);

                map1[indexA][indexB] += 1;
            }
        }

        for(int i=0; i<str2.length()-1; i++){
            String a = str2.charAt(i) + "";
            String b = str2.charAt(i+1) + "";

            if(ALPHA.contains(a) && ALPHA.contains(b)){
                int indexA = ALPHA.indexOf(a);
                int indexB = ALPHA.indexOf(b);

                map2[indexA][indexB] += 1;
            }
        }

        int numOfIntersection = 0;
        int numOfUnion = 0;

        for(int i=0; i<=27; i++){
            for(int j=0; j<=27; j++){
                numOfIntersection += Math.min(map1[i][j], map2[i][j]);
                numOfUnion += Math.max(map1[i][j], map2[i][j]);
            }
        }

        if(numOfIntersection == 0 && numOfUnion == 0){
            return 65536;
        }

        int answer = (int)((double)numOfIntersection / numOfUnion * 65536);
        return answer;
    }
}