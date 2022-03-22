package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_9184 {

    static Integer[][][] dp = new Integer[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            int w = w(a, b, c);

            String str = "w(" + a + ", " + b + ", " + c + ") = ";

            sb.append(str).append(w).append('\n');
        }

        System.out.println(sb);
    }

    private static Integer w(int a, int b, int c) {
        if (inRange(a, b, c) && dp[a][b][c] != null) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = w(20 ,20, 20);
        }

        if (a < b && b < c) {
           return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c)
                    + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c)
                + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    private static boolean inRange(int a, int b, int c) {
        return a >= 0 && b >= 0 && c >= 0 && a < 21 && b < 21 && c < 21;
    }
}
