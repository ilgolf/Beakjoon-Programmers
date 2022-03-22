package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1520 {

    static int n, m;

    static int[][] map;
    static int[][] dp;

    static int[][] moving = {{-1, 0}, {0, 1}, {1, 0} ,{0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(1, 1));
    }

    private static int dfs(int x, int y) {
        // 1. 목적지 인가?
        if (x == n && y == m) {
            return 1;
        }

        // 이미 방문 한 적 있으면 재 탐색 x
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        // -1 인경우만
        else {
            // 2. 체크인
            dp[x][y] = 0;

            // 3. 연결된 곳을 순회 : 4가지 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + moving[i][0];
                int ny = y + moving[i][1];

                // 4. 갈 수 있는가? : 범위 초과 주의
                if (nx < 1 || ny < 1 || nx > n || ny > m) continue;

                // 4. 갈 수 있는가? 2 : 더 높지 않은 곳만을 탐색한다.
                if (map[x][y] > map[nx][ny]) {
                    // 5. 간다. : 순회하면서 목적지에 도달 시 ++
                    dp[x][y] += dfs(nx, ny);
                }
            }
        }

        // 6. 체크아웃
        return dp[x][y];
    }
}
