package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baek_1780 {

    static int[][] map;
    static int[] result = new int[3];

    static void find(int x, int y, int size) {
        int check = checkPaper(x, y, size);

        if (check == -1) {
            result[0] ++;
            return;
        }
        else if (check == 0) {
            result[1] ++;
            return;
        }
        else if (check == 1) {
            result[2] ++;
            return;
        }

        size = size / 3;

        find(x, y, size);
        find(x, y + size, size);
        find(x, y + 2 * size, size);

        find(x + size, y, size);
        find(x + size, y + size, size);
        find(x + size, y + 2 * size, size);

        find(x + 2 * size, y, size);
        find(x + 2 * size, y + size, size);
        find(x + 2 * size, y + 2 * size, size);
    }

    static int checkPaper(int x, int y, int size) {
        int paper = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != paper) { return 2; }
            }
        }

        return paper;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        find(0, 0, n);

        for (int val : result) {
            System.out.println(val);
        }
    }
}
