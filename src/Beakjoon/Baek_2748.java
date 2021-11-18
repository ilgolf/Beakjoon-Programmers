package Beakjoon;

import java.io.*;

/**
 *
 * 점화식
 * F(n) = F(n - 1) + F(n - 2) (n >= 2)
 *
 */

public class Baek_2748 {

    static Long[] dp = new Long[91];

    static Long fibo(int x) {
        if (dp[x] == null) {
            dp[x] = fibo(x - 1) + fibo(x - 2);
        }

        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp[0] = 0L;
        dp[1] = 1L;

        System.out.println(fibo(n));
    }
}
