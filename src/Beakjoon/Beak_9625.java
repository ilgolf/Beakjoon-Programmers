package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_9625 {

    /**
     * dp[n][A] = dp[n - 1][A] + dp[n - 2][A];
     * dp[n][B] = dp[n - 1][B] + dp[n - 2][B];
     *
     * dp[n] = new int[] {dp[n][A], dp[n][B]};
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int[][] dp = new int[k + 1][2];

        dp[0] = new int[] {1, 0};
        dp[1] = new int[] {0, 1};

        for (int i = 2; i <= k; i++) {
            int a = dp[i - 1][0] + dp[i - 2][0];
            int b = dp[i - 1][1] + dp[i - 2][1];

//            System.out.println(a + " " + b);

            dp[i] = new int[] {a, b};
        }

        System.out.println(dp[k][0] + " " + dp[k][1]);
    }
}
