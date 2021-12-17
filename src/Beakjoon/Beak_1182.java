package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1182 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        comb(arr, 0, 0, s);

        if (s == 0) {
            count --;
        }

        System.out.println(count);
    }

    private static void comb(int[] arr, int depth, int sum, int s) {
        if (depth == arr.length) {
            if (sum == s) {
                count ++;
            }
            return;
        }

        comb(arr, depth + 1, sum + arr[depth], s);
        comb(arr, depth + 1, sum, s);
    }
}
