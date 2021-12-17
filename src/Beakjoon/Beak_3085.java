package Beakjoon;

import java.io.*;
import java.util.Arrays;

public class Beak_3085 {

    static int n;
    static char[][] map;

    private static int check(char[][] map) {
        int result = 1;

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (map[i][j] == map[i][j - 1]) {
                    cnt ++;
                } else {
                    cnt = 1;
                }
                if (result < cnt) {
                    result = cnt;
                }
            }

            cnt = 1;
            for (int j = 1; j < n; j++) {
                if (map[j][i] == map[j - 1][i]) {
                    cnt ++;
                } else {
                    cnt = 1;
                }

                if (result < cnt) {
                    result = cnt;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new char[n][];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    char t = map[i][j];
                    map[i][j] = map[i][j + 1];
                    map[i][j + 1] = t;

                    int temp = check(map);

                    if (answer < temp) {
                        answer = temp;
                    }

                    t = map[i][j];
                    map[i][j] = map[i][j + 1];
                    map[i][j + 1] = t;
                }
                if (i + 1 < n) {
                    char t = map[i][j];
                    map[i][j] = map[i + 1][j];
                    map[i + 1][j] = t;

                    int temp = check(map);

                    if (answer < temp) {
                        answer = temp;
                    }

                    t = map[i][j];
                    map[i][j] = map[i + 1][j];
                    map[i + 1][j] = t;
                }
            }
        }

        System.out.println(answer);
    }
}
