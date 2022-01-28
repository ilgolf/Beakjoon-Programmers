package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_5582 {

    static char[] A;
    static char[] B;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        A = new char[str1.length() + 1];
        B = new char[str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            A[i] = str1.charAt(i - 1);
        }

        for (int i = 1; i <= str2.length(); i++) {
            B[i] = str2.charAt(i - 1);
        }

        dp = new int[str2.length() + 1][str1.length() + 1];

        int max = 0;
        for (int i = 1; i <= str2.length(); i++) {
            for (int j = 1; j <= str1.length(); j++) {
                // 점화식 : 대각선을 참고하여 두 글자가 같을 때 + 1
                if (B[i] == A[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // 최댓값 갱신
                    max = Math.max(max, dp[i][j]);
                }

            }
        }

        System.out.println(max);
    }
}
