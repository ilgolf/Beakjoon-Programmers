package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int[] prefixArr = new int[n * n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 4 * 4 기준 16개 배열로 표현 1, 1은 6번째로 표현 가능 (i, j) -> (n * i) + (j)
         */

        prefixArr[0] = arr[0][0];
        for (int i = 1; i < n * n; i++) {
            prefixArr[i] = arr[i / n][i % n] + prefixArr[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int sX = Integer.parseInt(st.nextToken()) - 1;
            int sY = Integer.parseInt(st.nextToken()) - 1;
            int eX = Integer.parseInt(st.nextToken()) - 1;
            int eY = Integer.parseInt(st.nextToken()) - 1;

            int startIdx = (n * sX) + sY;
            int endIdx = (n * eX) + eY;

            if (startIdx == 0) {
                sb.append(prefixArr[endIdx]).append('\n');
            }

            else if (startIdx == endIdx) {
                sb.append(arr[sX][sY]).append('\n');
            }

            else if (startIdx > 0) {
                sb.append(prefixArr[endIdx] - prefixArr[startIdx]).append('\n');
            }
        }

        System.out.println(sb);
    }
}
