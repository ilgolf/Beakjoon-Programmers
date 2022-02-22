package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_13458 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n]; // 시험장
        long[] viewer = new long[2]; // 감시할 수 있는 응시자 수
        long result = 0; // 결과

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        viewer[0] = Integer.parseInt(st.nextToken()); // 총 감독관
        viewer[1] = Integer.parseInt(st.nextToken()); // 부 감독관

        result = getResult(n, arr, viewer, result);

        System.out.println(result);
    }

    private static long getResult(int n, long[] arr, long[] viewer, long result) {
        // 1. 총 감독관을 기준으로 빼준다.
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] - viewer[0];
            result++;
        }

        // 2. 부 감독관으로 나눠주고 나머지가 존재한다면 + 1
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) continue; // 이미 감독을 다 할 수 있다면 연산할 필요가 없다.

            // 딱 떨어질 경우
            if (arr[i] % viewer[1] == 0) {
                result += arr[i] / viewer[1];
            }

            // 나머지가 존재할 경우
            else {
                result += arr[i] / viewer[1] + 1;
            }
        }
        return result;
    }
}
