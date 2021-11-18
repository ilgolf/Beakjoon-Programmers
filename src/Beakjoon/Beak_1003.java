package Beakjoon;

import java.io.*;

public class Beak_1003 {

    static Integer[][] dp = new Integer[41][2];

    static Integer[] fibo(int x) {
        if (dp[x][0] != null || dp[x][1] != null) {
            return dp[x];
        }

        dp[x][0] = fibo(x - 1)[0] + fibo(x - 2)[0];
        dp[x][1] = fibo(x - 1)[1] + fibo(x - 2)[1];

        return dp[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        StringBuilder sb = new StringBuilder();
        while (t -- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(fibo(n)[0]).append(" ").append(fibo(n)[1]).append('\n');
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
