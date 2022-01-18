package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_1806 {

    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 배열 길이
        s = Integer.parseInt(st.nextToken()); // 타겟

        arr = new int[n]; // 담을 배열, ArrayIndexOfBounds 방지

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE, sum = arr[0], left = 0, right = 0;

        while (true) {

            // sum >= s, left ++, length 비교
            if (sum >= s) {
                minLength = Math.min(minLength, Math.abs((right - left) + 1));
                sum -= arr[left ++];
            }

            // sum < s, right ++
            else {
                if (right == n - 1) {
                    break;
                }
                sum += arr[++right];
            }
        }

        // 원하는 경우가 없어 그대로 나왔을 경우 0 출력
        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }

        System.out.println(minLength);
    }
}
