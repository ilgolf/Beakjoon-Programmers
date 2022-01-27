package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dp[i][j] -> i : 앱 사용 빈도, j : 확보가능한 최대 메모리
 * i 번 앱을 지우면서, j cost를 갱신할 수 있는 최대 메모리
 */
public class Beak_7579 {

    static class App {
        int memory;
        int cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }
    }

    static int n, m;
    static int[][] dp;
    static App[] apps;
    static int totalCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        apps = new App[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            apps[i] = new App(0, 0);
            apps[i].memory = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {

            apps[i].cost = Integer.parseInt(st.nextToken());
            totalCost += apps[i].cost;
        }

        dp = new int[n + 1][totalCost + 1];

        // 순회 하며 값 넣어주기
        int result = totalCost + 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= totalCost; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

                // i번째 앱을 넣을 수 있다면?
                if (j - apps[i].cost >= 0) {
                    // 넣지 않았을 때와 넣었을 때 둘 중 최댓값
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - apps[i].cost] + apps[i].memory);
                }
            }
        }

        for (int i = 1; i <= totalCost; i++) {
            if (dp[n][i] >= m) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
