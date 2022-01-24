package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_1256 {

    static int n, m, k;
    static int[][] dp;
    static final int MAX = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n * m + 1][n * m + 1]; // 파스칼 삼각형임

        // ex). 2 2 2 일 때 aazz로 시작하는 문자 중 두 번째로 등장하는 문자

        // 파스칼 삼각형 구하자
        getPascal();

        // 인덱스
    }

    private static void getPascal() {
        for (int i = 0; i <= n * m; i++) {
            for (int j = 0; j <= i; j++) {
                // 인덱스 같으면 1
                if (i == j) {
                    dp[i][j] = 1;
                }

                // 0번 뽑는 경우 1
                else if (j == 0) {
                    dp[i][j] = 1;
                }

                // 외의 경우 (i - 1, j) + (i - 1, j - 1)
                else {
                    if (dp[i - 1][j] + dp[i - 1][j - 1] > MAX) {
                        dp[i][j] = MAX;
                    }
                    else {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    }
                }
            }
        }
    }
}
