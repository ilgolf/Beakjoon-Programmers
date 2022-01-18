package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2003 {

    static int n, m;
    static int[] arr;
    static int result = 0;

    private static void twoPoint() {
        int left = 0;
        int right = 0;

        while (left < arr.length && right < arr.length) {
            // 구간 을 더하기 해본다.
            int sum = 0;

            // 구간 합
            for (int i = left; i <= right; i++) {
                sum += arr[i];
            }

            // 더 했을 때 m과 비교하여 left와 right 이동
            if (sum == m) {
                result ++;
                left ++;
            }
            else if (sum < m) {
                right ++;
            }
            else {
                left ++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPoint();

        System.out.println(result);
    }
}
