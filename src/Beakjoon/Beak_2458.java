package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 정방향으로만 탐색을 한다면 모든 정점을 순회하며 탐색이 불가능하다. (다른 정점에서 출발하여 이어진 그래프도 존재)
 * 그렇기에 reverseDist로 역방향 그래프를 만들어 플로이드 탐색이 핵심이다.
 *
 * 자신을 제외한 모든 정점에서 모든 정점에 대해 이동할 수 있는지 파악하면 된다.
 */

public class Beak_2458 {

    static int n, m;
    static boolean[][] dist;
    static boolean[][] reverseDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new boolean[n + 1][n + 1]; // 정방향 탐색
        reverseDist = new boolean[n + 1][n + 1]; // 거꾸로 탐색

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = true;
            reverseDist[b][a] = true;
        }

        floyd(dist);
        floyd(reverseDist);

        // reverseDist가 false라면 모든 정점 순회가 아니므로 false
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] |= reverseDist[i][j];
            }
        }

        int result = 0;
        outer: for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
               if (i == j) continue;

               if (!dist[i][j]) {
                   continue outer;
               }
            }
            result ++;
        }

        System.out.println(result);
    }

    private static void floyd(boolean[][] road) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 이어져 있다면 true
                    if (road[i][k] && road[k][j]) {
                        road[i][j] = true;
                    }
                }
            }
        }
    }
}
