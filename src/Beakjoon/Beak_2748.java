package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_2748 {

    static Long[] dp = new Long[91];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;

        int n = Integer.parseInt(br.readLine());

        System.out.println(fibo(n));
    }

    private static Long fibo(int n) {
        if (dp[n] != null) {
            return dp[n];
        }

        dp[n] = fibo(n - 1) + fibo(n - 2);

        return dp[n];
    }
}
