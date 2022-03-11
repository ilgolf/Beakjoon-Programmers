package Programmers;

public class LongJump {

    static Long[] dp = new Long[2001];

    public long solution(int n) {
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;

        return fibo(n);
    }

    private long fibo(int n) {
        if (dp[n] != null) {
            return dp[n];
        }

        return dp[n] = fibo(n - 1) + fibo(n - 2);
    }
}
