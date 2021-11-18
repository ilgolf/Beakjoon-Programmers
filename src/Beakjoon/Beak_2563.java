package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_2563 {

    static final int SIZE = 100;
    static final int LENGTH = 10;
    static int[][] square;

    static void feelBlock(int x, int y) {
        for (int i = x; i < x + LENGTH; i++) {
            for (int j = y; j < y + LENGTH; j++) {
                square[i][j] += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int result = 0;

        square = new int[SIZE][SIZE];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            feelBlock(x, y);
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (square[i][j] >= 1) {
                    result ++;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
