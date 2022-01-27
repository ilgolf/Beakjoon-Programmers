package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_1932ver2 {

    static int n;
    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        triangle = new int[n][];

        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
        }

        for (int i = 0; i < triangle.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = triangle[i + 1][j] + triangle[i][j];
                int right = triangle[i + 1][j + 1] + triangle[i][j];

                triangle[i][j] = Math.max(left, right);
            }
        }

        System.out.println(triangle[0][0]);
    }
}
