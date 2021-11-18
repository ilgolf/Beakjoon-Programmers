package Beakjoon;

import java.io.*;
import java.util.Arrays;

public class Beak_3085 {

    static int n;
    static char[][] map;
    static int max = 0;

    static void swap(int x1, int y1, int x2, int y2) {
        char[][] temp = new char[n][n];

        for (int i = 0; i < n; i++) {
            temp[i] = map[i].clone();
        }

        char tmp = temp[x1][y1];
        temp[x1][y1] = temp[x2][y2];
        temp[x2][y2] = tmp;

        checkLength(temp);
    }

    static void checkLength(char[][] temp) {
        int count = 1;

        // 오른쪽 검색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (temp[i][j] == temp[i][j + 1]) {
                    count ++;
                    max = Math.max(max, count);
                    if (max == n) return;
                } else {
                    count = 1;
                }
            }
        }

        count = 1;

        // 아래 검색
        for (int i = 0; i < n; i++) {
            count = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    count ++;
                    max = Math.max(max, count);
                    if (max == n) return;
                } else {
                    count = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i - 1][j - 1] != map[i][j - 1]) {
                    swap(i - 1, j - 1, i, j - 1);
                }
                else if (map[i - 1][j - 1] != map[i - 1][j - 1]) {
                    swap(i - 1, j - 1, i - 1, j);
                }

                if (max ==  n) {
                    System.out.println(max);
                    return;
                }
            }
        }

        System.out.println(max);
    }
}
