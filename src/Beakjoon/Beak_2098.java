package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_2098 {

    static int n;
    static int[][] dp;
    static int[][] map;
    static final int INF = 11000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int bitLength = (1 << n) - 1;

        dp = new int[n][bitLength];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());;
            }
        }


        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(dfs(0, 1));
    }

    private static int dfs(int city, int visit) {
        // 1. 체크인

        // 2. 목적지인가?
        if (visit == (1 << n) - 1) {
            if (map[city][0] == 0) {
                return INF;
            }

            return map[city][0];
        }

        // 이미 값이 존재한다면 방문 x
        if (dp[city][visit] != INF) {
            return dp[city][visit];
        }

        // 3. 갈 수 있는 곳을 순회
        for (int i = 0; i < n; i++) {
            // 4. 갈 수 있는가?
            if ((visit & (1 << i)) == 0 && map[city][i] != 0) {
                // 5. 간다.
                // 6. 체크 아웃
                dp[city][visit] = Math.min(dp[city][visit], dfs(i, visit | (1 << i)) + map[city][i]);
            }
        }

        return dp[city][visit];
    }
}
