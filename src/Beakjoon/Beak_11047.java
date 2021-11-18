package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] pocket = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            pocket[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0;
        int sum = 0;

        while (k > 0) {
            if (k / pocket[idx] > 0) {
                sum += (k / pocket[idx]);
            }

            k = k % pocket[idx];
            idx ++;
        }

        System.out.println(sum);
    }
}
