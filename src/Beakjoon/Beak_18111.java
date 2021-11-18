package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answerTime = 64000000;
        int answerheight = -1;
        int max = -1, min = answerTime;

        int[][] block = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                block[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, block[i][j]);
                min = Math.min(min, block[i][j]);
            }
        }

        for (int i = max; i >= min; i--) {
            int time = 0;
            int bag = b;

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (block[x][y] != i) {
                        int distance = Math.abs(i - block[x][y]);
                        if (i > block[x][y]) {
                            bag -= distance;
                            time += distance;
                        } else {
                            bag += distance;
                            time += (2 * distance);
                        }
                    }
                }
            }

            if (bag < 0) continue;
            if (time < answerTime) {
                answerTime = time;
                answerheight = i;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(answerTime + " " + answerheight);
        bw.flush();
        bw.close();
    }
}
