package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_2096 {

    static int n;
    static int[] maxDp = new int[3];
    static int[] minDp = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (i == 0) {
                //최대
                maxDp[0] = a;
                maxDp[1] = b;
                maxDp[2] = c;

                // 최소
                minDp[0] = a;
                minDp[1] = b;
                minDp[2] = c;
            } else {
                // 최대
                int beforeMax0 = maxDp[0], beforeMax2 = maxDp[2];
                maxDp[0] = Math.max(maxDp[0], maxDp[1]) + a;
                maxDp[2] = Math.max(maxDp[1], maxDp[2]) + c;
                maxDp[1] = Math.max(maxDp[1], Math.max(beforeMax0, beforeMax2)) + b;

                // 최소
                int beforeMin0 = minDp[0], beforeMin2 = minDp[2];
                minDp[0] = Math.min(minDp[0], minDp[1]) + a;
                minDp[2] = Math.min(minDp[2], minDp[1]) + c;
                minDp[1] = Math.min(minDp[1], Math.min(beforeMin0, beforeMin2)) + b;
            }
        }

        int max = Math.max(maxDp[0], Math.max(maxDp[1], maxDp[2]));
        int min = Math.min(minDp[0], Math.min(minDp[1], minDp[2]));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + " " + min);
        bw.flush();
        bw.close();
    }
}
