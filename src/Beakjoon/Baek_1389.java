package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1389 {

    static int n,m;
    static int[][] kevin;
    static final int INF = 5001;

    static void func(BufferedReader br, int m, int[][] kevin) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            kevin[x][y] = kevin[y][x] = 1;
        }
    }

    static void floyd() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    kevin[i][j] = Math.min(kevin[i][j], kevin[i][k] + kevin[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        kevin = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) kevin[i][j] = 0;
                else kevin[i][j] = INF;
            }
        }

        func(br, m, kevin);

        floyd();

        int[] result = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += kevin[i][j];
            }
            result[i] = sum;
            if (sum < min) min = sum;
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == min) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}
