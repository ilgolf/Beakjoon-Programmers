package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2578 {

    static final int SIZE = 5;
    static int[][] map = new int[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                int num = Integer.parseInt(st.nextToken());
                result ++;

                if (isSame(num)) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }

    private static boolean isSame(int num) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == num) {
                    map[i][j] = -1;

                    if (isBingo(i, j) >= 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int isBingo(int r, int c) {
        int cnt = 0;

        // 가로
        for (int i = 0; i < 5; i++) {
            int rCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == -1) {
                    rCnt ++;
                }

                if (rCnt == 5) cnt ++;
            }
        }

        // 세로
        for (int i = 0; i < 5; i++) {
            int cCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (map[j][i] == -1) {
                    cCnt ++;
                }

                if (cCnt == 5) cnt ++;
            }
        }

        // 우 상향 대각선
        int cCnt = 0;
        for (int i = 4; i >= 0; i--) {
            if (map[4 - i][i] == -1) {
                cCnt ++;
            }

            if (cCnt == 5) cnt ++;

        }

        cCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][i] == -1) {
                cCnt++;
            }

            if (cCnt == 5) cnt ++;
        }

        return cnt;
    }
}
