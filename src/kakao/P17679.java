package kakao;

public class P17679 {

    public static void main(String[] args){
        String [] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        System.out.println(solution(6, 6, board));
    }

    public static int solution(int m, int n, String[] board) {

        String [][] map = new String[m][n];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length(); j++){
                map[i][j] = board[i].charAt(j) + "";
            }
        }

        int answer = 0;
        while(true){
            boolean isChanged = false;
            boolean [][] check = new boolean[m][n];

            for(int i=0; i<map.length-1; i++){
                for(int j=0; j<map[0].length-1; j++){
                    String standard = map[i][j];
                    if(standard != null && standard.equals(map[i][j+1]) && standard.equals(map[i+1][j]) && standard.equals(map[i+1][j+1])){
                        for(int k=0; k<2; k++){
                            for(int g=0; g<2; g++){
                                check[i+k][j+g] = true;
                            }
                        }
                        isChanged = true;
                    }
                }
            }

            if(!isChanged){
                break;
            }

            String [][] tempMap = new String[m][n];
            for(int x=0; x<n; x++){
                int k=m-1;
                for(int y=m-1; y>=0; y--){
                    if(!check[y][x]) {
                        tempMap[k][x] = map[y][x];
                        k--;
                    }else{
                        answer+=1;
                    }
                }
            }

            map = tempMap;


        }

        return answer;
    }


}


