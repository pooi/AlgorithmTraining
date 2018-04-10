package baekjoon;

import java.util.Scanner;

public class P14500 {
    static int N, M;
    static int[][] map;
    static int[][][] BLOCK = {
            {
                    {0, 0, 0, 1},
                    {0, 0, 0, 1},
                    {0, 0, 0, 1},
                    {0, 0, 0, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {1, 1, 1, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 1, 1},
                    {0, 0, 1, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 0, 1},
                    {0, 1, 1, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 1, 1},
                    {0, 0, 0, 1},
                    {0, 0, 0, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 1, 1, 1},
                    {0, 1, 0, 0},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 1},
                    {0, 0, 0, 1},
                    {0, 0, 1, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 1, 1, 1},
                    {0, 0, 0, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 1, 1},
                    {0, 0, 1, 0},
                    {0, 0, 1, 0},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 1, 1, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 1},
                    {0, 0, 1, 1},
                    {0, 0, 1, 0},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 1, 1, 0},
                    {0, 0, 1, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 1},
                    {0, 0, 0, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 1, 1},
                    {0, 1, 1, 0},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 0, 1, 0},
                    {0, 1, 1, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 1},
                    {0, 0, 1, 1},
                    {0, 0, 0, 1},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 0, 0},
                    {0, 1, 1, 1},
                    {0, 0, 1, 0},
            },
            {
                    {0, 0, 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 1, 1},
                    {0, 0, 1, 0},
            }
    };

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        M = scn.nextInt();
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = scn.nextInt();
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                int sum = getSum(i, j);
                max = Math.max(sum, max);

            }
        }

        System.out.println(max);

    }

    public static int getSum(int y, int x) {
        int max = 0;
        for (int b = 0; b < BLOCK.length; b++) {
            int[][] block = BLOCK[b];
            int sum = 0;
            for (int by = 0; by < 4; by++) {
                for (int bx = 0; bx < 4; bx++) {
                    if (block[by][bx] == 1) {
                        int mapX = x - (3 - bx);
                        int mapY = y - (3 - by);
                        if (0 <= mapX && mapX < M && 0 <= mapY && mapY < N) {
                            sum += map[mapY][mapX];
                        } else {
                            sum = -1;
                            break;
                        }
                    }
                }
                if (sum < 0)
                    break;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
