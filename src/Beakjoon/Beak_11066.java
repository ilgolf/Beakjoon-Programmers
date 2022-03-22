package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_11066 {

    /**
     * 점화식
     * dp[i][j] = i부터 j장까지 합치는 비용
     * dp[i][i] = arr[i]
     * dp[i][i + 1] = arr[i] + arr[i+1]
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder resultBuilder = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int testcase = 0; testcase < t; testcase++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n + 1];
            int[][] dp = new int[n + 1][n + 1];
            int[] sum = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + arr[i];
            }

            for (int i = 1; i <= n; i++) { // 1 ~ n까지 묶기
                for (int from = 1; from + i <= n; from++) { // 어디서 부터 묶을 건가
                    int to = from + i;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) { // 어디까지 묶을 것인가?
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide]
                                + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            resultBuilder.append(dp[1][n]).append('\n');
        }

        System.out.println(resultBuilder.toString().trim());
    }
}
