package Beakjoon;

import java.io.*;

public class Beak_2447 {

    static int n;
    static char[][] starArr;

    static void star(int x, int y, int n, boolean blank) {

        // 해당 윛치는 공백으로 채워야 할 경우
        if (blank) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    starArr[i][j] = ' ';
                }
            }
            return;
        }

        // 1까지 쪼갰을 때 *로 채우기
        if (n == 1) {
            starArr[x][y] = '*';
            return;
        }

        int size = n / 3;
        int count = 0; // 카운트가 5가되면 비어줘야 하는 구간이다.

        for (int i = x; i < x + n; i+=size) {
            for (int j = y; j < y + n; j+=size) {
                count ++;
                star(i, j, size, count == 5);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        starArr = new char[n][n];

        star(0, 0, n, false);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result.append(starArr[i][j]);
            }
            result.append('\n');
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
