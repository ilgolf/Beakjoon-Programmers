package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * 전형적인 이분탐색 문제
 * 탐색하면서 기준에 맞는 최대 갯수를 구해주자
 *
 */

public class Baek_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 랜선 개수
        int k = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        long max = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }


        Arrays.sort(arr);

        int left = 1;
        int right = arr[n - 1];

        /**
         *
         * ex. 802 - 1 = 801 / 2 -> 400
         * [457, 539, 743, 802]
         *
         */

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            long cal = 0;

            for (int j : arr) {
                sum += (j / mid);
            }

            if(sum >= k) {
                max = Math.max(max, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(max);
    }
}
