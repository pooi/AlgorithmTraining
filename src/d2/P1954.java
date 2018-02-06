package d2;

import java.util.Scanner;

public class P1954 {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int step = scn.nextInt();

        int[][] direction = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        for (int s = 0; s < step; s++) {

            int len = scn.nextInt();

            int[][] values = new int[len][len];

            int dir = 0;
            int x = 0, y = 0;
            for (int k = 1; k <= len * len; k++) {

                values[y][x] = k;

                int offsetX = direction[dir][0];
                int offsetY = direction[dir][1];

                int changedX = x + offsetX;
                int changedY = y + offsetY;

                if (changedX >= len || changedY >= len || changedX < 0 || changedY < 0 || values[changedY][changedX] != 0){
                    dir = (dir + 1) % 4;
                }

                offsetX = direction[dir][0];
                offsetY = direction[dir][1];
                x += offsetX;
                y += offsetY;

            }

            System.out.println("#" + (s+1));
            for (int j = 0; j < len; j++) {
                String ans = "";
                for (int i = 0; i < len; i++) {

                    ans += values[j][i] + " ";

                }
                System.out.println(ans.trim());
            }

        }
        scn.close();

    }

}
