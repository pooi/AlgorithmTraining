package d6;

import java.util.Scanner;

public class P1264 {

    public static int len;
    public static String pre, post;
    public static int [][] mark;

    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for(int testCase=1; testCase <= T; testCase++){

            len = scn.nextInt();
            pre = scn.next();
            post = scn.next();
            mark = new int[1000][1000];
            for(int i=0; i<1000; i++)
                for(int j=0; j<1000; j++)
                    mark[i][j] = -1;

            float matched = search(0, 0);

            System.out.println(String.format( "#%d %.2f", testCase, (matched / len) * 100 ) );

        }

    }

    public static int search(int pos1, int pos2){

        if(pos1 == len)
            return 0;
        if(mark[pos1][pos2] != -1)
            return mark[pos1][pos2];
        mark[pos1][pos2] = 0;
        for(int j=pos2; j<len; j++){
            if((pre.charAt(pos1) + "").equals((post.charAt(j) + ""))){
                mark[pos1][pos2] = Math.max(mark[pos1][pos2], 1 + search(pos1+1, j + 1));
            }
        }
        mark[pos1][pos2] = Math.max(mark[pos1][pos2], search(pos1+1, pos2));
        return mark[pos1][pos2];
    }
}
