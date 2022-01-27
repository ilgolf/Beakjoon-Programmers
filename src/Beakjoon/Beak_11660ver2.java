package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_11660ver2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n + 1][n + 1];
        int[][] prefixArr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 점화식을 이용한 계산산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixArr[i][j] = arr[i][j] + prefixArr[i - 1][j] + prefixArr[i][j - 1] - prefixArr[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());

            int num = prefixArr[eX][eY] - prefixArr[sX - 1][eY] -
                    prefixArr[eX][sY - 1] + prefixArr[sX - 1][sY - 1];

            sb.append(num).append('\n');
        }

        System.out.println(sb);
    }
}
