package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P002 {

    public static String DIR = "FRLB";
    public static int F = 0;
    public static int R = 1;
    public static int L = 2;
    public static int B = 3;

    public static int [][] map;
    public static int [][] dMap;

    public static boolean [][][] visited;

    public static int [][] TABLE = {
            {F, R, L, B},
            {R, B, F, L},
            {L, F, B, R},
            {B, L, R, F}
    };

    public static int [][] DIRECTION = {
            {0, -1},
            {1, 0},
            {-1, 0},
            {0, 1}
    };

    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            dMap = new int[n][n];
            visited = new boolean[n][n][4];
            for (int i = 0; i < n; i++) {
                int x = 0;
                for(String str : br.readLine().split(" ")){
                    int v = DIR.indexOf(str.charAt(0));
                    int w = Integer.parseInt(str.charAt(1) + "");
                    map[i][x] = v;
                    dMap[i][x] = w;
                    x += 1;
                }
            }

            boolean found = false;
            int x = 0, y = 0;
            int d = B;
            while(!found){
//                System.out.println(y + " " + x);
                int value = map[y][x];
                int nextD = TABLE[d][value];
                d = nextD;
                if(!visited[y][x][nextD]){
                    visited[y][x][nextD] = true;

                    int w = dMap[y][x];
                    for(int i=0; i<w; i++){
                        x += DIRECTION[nextD][0];
                        y += DIRECTION[nextD][1];
                    }
                }else{
                    found = true;
                }
            }

            // @todo Write your code here.
            System.out.println(x + " " + y);
        }
    }


}
