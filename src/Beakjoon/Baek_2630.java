package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_2630 {

    static int[][] colorPaper;
    static int white = 0, blue = 0;

    static void division(int x, int y, int size) {
        int check = colorCheck(x, y, size);

        if (check != -1) {
            if (check == 0) {
                white ++;
            } else {
                blue ++;
            }

            return;
        }

        size /= 2;

        division(x, y, size);
        division(x, y + size, size);
        division(x + size, y, size);
        division(x + size, y + size, size);
    }

    static int colorCheck(int x, int y, int size) {
        int color = colorPaper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (color != colorPaper[i][j]) return -1;
            }
        }

        return color;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // ㄷㄷ 배열 초기화 안하고 있었음 여태

        colorPaper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                colorPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        division(0, 0, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println(white);
        System.out.println(blue);
    }
}
