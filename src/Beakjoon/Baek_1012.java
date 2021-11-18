package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_1012 {

    static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] farm;
    static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] checked;
    static int n, m, k;

    static void bfs(int x, int y) {
        Queue<P> queue = new LinkedList<>();
        checked[x][y] = true;
        queue.offer(new P(x, y));

        while (!queue.isEmpty()) {
            P curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + moving[i][0];
                int ny = curr.y + moving[i][1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!checked[nx][ny] && farm[nx][ny] == 1) {
                        checked[nx][ny] = true;
                        queue.offer(new P(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t -- > 0) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            farm = new int[n][m];
            checked = new boolean[n][m];

            Baek_1389.func(br, k, farm);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!checked[i][j] && farm[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append('\n');
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
