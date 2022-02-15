package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_14501 {

    static class Consult {
        int day;
        int cost;

        public Consult(int day, int cost) {
            this.day = day;
            this.cost = cost;
        }
    }

    static int n;
    static Consult[] consults;
    static int[] dp;

    /**
     * 전형적인 DP 메모리제이션 문제 consult 배열을 기준으로 Math.max()를 이용해
     * 최댓값을 상시로 업데이트 해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        consults = new Consult[n + 1];
        dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            consults[i] = new Consult(day, cost);
        }

        // 업데이트 시작
        for (int i = 1; i <= n; i++) {
            int idx = i + consults[i].day; // 업데이트할 테이블 인덱스

            if (idx <= n + 1) {
                dp[idx] = Math.max(dp[idx], dp[i] + consults[i].cost); // 점화식
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n + 1]);
    }
}
