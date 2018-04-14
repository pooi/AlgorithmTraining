package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [][] p = new int[1001][10];
        for(int i=0; i<10; i++){
            p[1][i] = 1;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    p[i][j] = (p[i][j] + p[i-1][k]) % 10007;
                }
            }
        }

        int result = 0;
        for(int i=0; i<10; i++){
            result = (result + p[n][i]) % 10007;
        }
        System.out.println(result);
    }
}
