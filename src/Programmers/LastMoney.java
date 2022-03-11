package Programmers;

public class LastMoney {

    /**
     * dp[현재 해당 가격] = dp[현재 해당 가격 - 현재 화폐의 액수]
     */
    public int solution(int n, int[] money) {
        long[] dp = new long[n + 1];

        dp[0] = 1;

        for (int i = 1; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) {
                dp[j] += dp[j - money[i]];
            }
        }

        int answer = (int)(dp[n] % 1_000_000_007);

        return answer;
    }
}
