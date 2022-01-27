package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_11049 {

    static int[][] dp = new int[501][501];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][2];

        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            matrix[i][0] = r;
            matrix[i][1] = c;
        }

        find(matrix);

        System.out.println(dp[0][n - 1]);
    }

    private static void find(int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int a = j;
                int b = i + j;

                if (a == b) {
                    dp[a][b] = 0;
                }

                else {
                    for (int k = a; k < b; k++) {
                        dp[a][b] = Math.min(dp[a][b], dp[a][k] + dp[k + 1][b] +
                                matrix[a][0] * matrix[k][1] * matrix[b][1]);
                    }
                }
            }
        }
    }
}
