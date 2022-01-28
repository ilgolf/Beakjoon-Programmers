package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak_9295 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strA = br.readLine();
        String strB = br.readLine();

        char[] a = new char[strA.length() + 1];
        char[] b = new char[strB.length() + 1];

        for (int i = 1; i < a.length; i++) {
            a[i] = strA.charAt(i - 1);
        }

        for (int i = 1; i < b.length; i++) {
            b[i] = strB.charAt(i - 1);
        }


        int[][] dp = new int[b.length][a.length];

        for (int i = 1; i < b.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j] == b[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]));
                }

                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[b.length - 1][a.length - 1]);

        int i = b.length - 1;
        int j = a.length - 1;

        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (dp[i - 1][j] == dp[i][j]) {
                i --;
            }

            else if (dp[i][j - 1] == dp[i][j]) {
                j --;
            }

            else {
                sb.append(b[i]);
                i --; j--;
            }
        }

        System.out.println(sb.reverse());
    }
}
