package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_2342 {

    static int[][][] dp;
    static int[] direction = new int[100001];
    static int n;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; ; i++) {
            int val = Integer.parseInt(st.nextToken());

            if (val == 0) {
                n = i - 1;
                break;
            }

            direction[i] = val;
        }

        dp = new int[n + 1][5][5];

        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, INF);
            }
        }

        dp[1][0][direction[1]] = 2;
        dp[1][direction[1]][0] = 2;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 4; k++) {
                    if (dp[i][j][k] != INF) {
                        int next = direction[i + 1];

                        if (k != next) {
                            dp[i + 1][next][k] = Math.min(dp[i + 1][next][k], dp[i][j][k] + getCost(j, next));
                        }
                        if (j != next) {
                            dp[i + 1][j][next] = Math.min(dp[i + 1][j][next], dp[i][j][k] + getCost(k, next));
                        }
                    }
                }
            }
        }

        int result = INF;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                result = Math.min(result, dp[n][i][j]);
            }
        }

        System.out.println(result);
    }

    private static int getCost(int from, int to) {
        if (from == to) {
            return 1;
        }
        else if (from == 0) {
            return 2;
        }
        else if (Math.abs(from - to) == 2) {
            return 4;
        }
        else {
            return 3;
        }
    }
}
