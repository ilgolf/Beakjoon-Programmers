package Beakjoon;

import java.io.*;

public class Baek_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] result = new int[t];
        int[] output = new int[11];
        output[1] = 1;
        output[2] = 2;
        output[3] = 4;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            for (int j = 4; j <= n; j++) {
                output[j] = output[j - 1] + output[j - 2] + output[j - 3];
            }
            result[i] = output[n];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int val : result) {
            bw.write(String.valueOf(val) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
