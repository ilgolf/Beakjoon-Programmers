package Beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1이라면 주변을 살펴보고 0이 두 개 이상 존재하면 없애면 된다.
 */

public class Beak_2638 {

    static class P {
        int x,y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m, last, count;
    static boolean flag = true;
    static int[][] cheese;
    static boolean[][] checked;
    static int[][] moving = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static Queue<P> airQueue = new LinkedList<>();
    static Queue<P> meltQueue = new LinkedList<>();

    static void bfs() {
        if (airQueue.isEmpty()) airQueue.offer(new P(0, 0));

        while (!airQueue.isEmpty()) {
            P cur = airQueue.poll();

            cheese[cur.x][cur.y] = count;
            checked[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + moving[i][0];
                int ny = cur.y + moving[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (checked[nx][ny]) continue;

                if (cheese[nx][ny] == 0) {
                    checked[nx][ny] = true;
                    airQueue.offer(new P(nx, ny));
                }
                else if (cheese[nx][ny] == 1) {
                    checked[nx][ny] = true;
                    meltQueue.offer(new P(cur.x, cur.y));
                }
            }
        }
    }

    static void targetCheese() {

        while (!meltQueue.isEmpty()) {
            P cur = meltQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + moving[i][0];
                int ny = cur.y + moving[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (cheese[nx][ny] == -1) {
                    cheese[nx][ny] = count + 1;
                    airQueue.offer(new P(nx, ny));
                }
            }
        }

        if (airQueue.isEmpty()) {
            flag = false;
            return;
        }

        count ++;
        last = airQueue.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        count = 2;
        last = 0;

        cheese = new int[n][m];
        checked = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());

                cheese[i][j] = num == 1 ? -1 : 0;
            }
        }

        while (flag) {
            bfs();
            targetCheese();
        }

        System.out.println(count);
    }
}
