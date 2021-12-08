package Programmers;

import java.util.Arrays;

/**
 * n = 1, 1개
 * n = 2, 2개
 * n = 3, 3개
 * n = 4, 5개
 *
 * 피보나치 수열 방식으로 증가 : 점화식 -> f(n) = f(n - 1) + f(n - 2)
 */

public class TileX2 {

    static int[] dp = new int[60001];
    static final int MOD = 1000000007;

    static int tile(int num) {
        if (dp[num] != -1) {
            return dp[num] % MOD;
        }

        dp[num] = tile(num - 1) + tile(num - 2);

        return dp[num] % MOD;
    }

    public int solution(int n) {
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        return tile(n);
    }
}
