package Beakjoon;

import java.io.*;

public class Beak_1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 공식 count = min(mid / i, n) i -> i번째 수
         */

        long result = 0;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long left = 1;
        long right = k;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if (count < k) {
                left = mid  + 1;
            }
            else {
                result = mid;
                right = mid - 1;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
