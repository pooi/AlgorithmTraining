package d6;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1263 {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int[][] dist;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        scn.nextLine();
        for (int testCase = 1; testCase <= T; testCase++) {
            N = scn.nextInt();
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = scn.nextInt();
                }
            }

            int min = Integer.MAX_VALUE - 1;
            for (int V = 0; V < N; V++) {
                visited = new boolean[N];
                dist = new int[N][N];
                for (int i = 0; i < dist.length; i++) {
                    if (map[V][i] == 0)
                        dist[V][i] = Integer.MAX_VALUE - 1;
                    else
                        dist[V][i] = map[V][i];
                }


                Queue<Integer> queue = new LinkedList<>();
                queue.add(V);

                while (!queue.isEmpty()) {
                    int node = queue.remove();
                    if (visited[node])
                        continue;
                    visited[node] = true;
                    for (int i = 0; i < N; i++) {
                        if (map[node][i] == 1) {
                            if (!visited[i]) {
                                queue.add(i);
                                if (dist[V][node] + map[node][i] < dist[V][i]) {
                                    dist[V][i] = dist[V][node] + map[node][i];
                                }
                            }
                        }
                    }

                }

                int sum = 0;
                for (int i = 0; i < dist[V].length; i++) {
                    if (i != V) {
                        sum += dist[V][i];
                    }
                }
                if (sum < min)
                    min = sum;
            }
            System.out.println(String.format("#%d %d", testCase, min));


        }

    }

}
