package Beakjoon;

import java.io.*;

/**
 *
 * 사분면 하나당 괄호가 열리고 닫히고 그 안에 압축된 값이 들어간다
 *
 *
 */

public class Baek_1992 {

    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    static void division(int x, int y, int size) {
        int check = checkTree(x, y, size);

        if (check != -1) {
            sb.append(check);
            return;
        }

        size /= 2;

        sb.append('(');

        division(x, y, size);  // 1사분면  (01)
        division(x, y + size, size); // 2사분면 (0(0011)1)
        division(x + size, y, size); // 3사분면 (0(0011)(0()01)1)
        division(x + size, y + size, size); // 4사분면 ()

        sb.append(')');
    }

    static int checkTree(int x, int y, int size) {
        int color = tree[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (tree[i][j] != color) return -1;
            }
        }
        return color;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                tree[i][j] = line.charAt(j) - '0';
            }
        }

        division(0, 0, n);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
