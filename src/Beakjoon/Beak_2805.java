package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        int max = 0;

        int[] tree = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        long left = 0;
        long right = max;
        long maxLength = 0;

        while (left <= right) {
            // 절단기 높이
            long mid = (right + left) / 2;
            long sum = 0; // 자른 갯수

            // 나무 자르기
            for (int i = 0; i < n; i++) {
                if ((tree[i] - mid) > 0) {
                    sum += (tree[i] - mid);
                }
            }

            // sum >= m : left = mid + 1, maxLength 갱신
            if (sum >= m) {
                maxLength = Math.max(maxLength, mid);
                left = mid + 1;
            }

            // sum < m : left = mid - 1
            else {
                right = mid - 1;
            }
        }

        System.out.println(maxLength);
    }
}
