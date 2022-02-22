package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_15683 {

    static class CCTV {
        int x;
        int y;
        int num;

        public CCTV(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static int n, m;
    static int[][] map;
    static int[][] copyMap;
    static List<CCTV> cctvs = new ArrayList<>();
    static int resultCount = Integer.MAX_VALUE;
    static int[] output;
    static int[][] moving = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvs.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        output = new int[cctvs.size()];
        permutation(0, cctvs.size());

        System.out.println(resultCount);
    }

    private static void permutation(int depth, int r) {
        if (depth == r) {
            copyMap = new int[n][m];

            for (int i = 0; i < n; i++) {
                if (m >= 0) System.arraycopy(map[i], 0, copyMap[i], 0, m);
            }

            for (int i = 0; i < cctvs.size(); i++) {
                direction(cctvs.get(i), output[i]);
            }

            getBlindSpot();

            return;
        }

        for (int i = 0; i < 4; i++) {
            output[depth] = i;
            permutation(depth + 1, r);
        }
    }

    private static void getBlindSpot() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == 0) {
                    cnt ++;
                }
            }
        }

        resultCount = Math.min(resultCount, cnt);
    }

    private static void direction(CCTV cctv, int d) {
        int cctvNum = cctv.num;

        if (cctvNum == 1) {
            switch (d) {
                case 0:
                    watch(cctv, 0);
                    break;
                case 1:
                    watch(cctv, 1);
                    break;
                case 2:
                    watch(cctv, 2);
                    break;
                case 3:
                    watch(cctv, 3);
                    break;
            }
        }
        else if (cctvNum == 2) {
            if (d == 0 || d == 2) {
                watch(cctv, 0);
                watch(cctv, 2);
            }
            else {
                watch(cctv, 1);
                watch(cctv, 3);
            }
        }
        else if (cctvNum == 3) {
            switch (d) {
                case 0:
                    watch(cctv, 0);
                    watch(cctv, 1);
                    break;
                case 1:
                    watch(cctv, 1);
                    watch(cctv, 2);
                    break;
                case 2:
                    watch(cctv, 2);
                    watch(cctv, 3);
                    break;
                case 3:
                    watch(cctv, 0);
                    watch(cctv, 3);
                    break;
            }
        }
        else if (cctvNum == 4) {
            switch (d) {
                case 0:
                    watch(cctv, 0);
                    watch(cctv, 1);
                    watch(cctv, 3);
                    break;
                case 1:
                    watch(cctv, 0);
                    watch(cctv, 1);
                    watch(cctv, 2);
                    break;
                case 2:
                    watch(cctv, 1);
                    watch(cctv, 2);
                    watch(cctv, 3);
                    break;
                case 3:
                    watch(cctv, 0);
                    watch(cctv, 2);
                    watch(cctv, 3);
                    break;
            }
        }
        else if (cctvNum == 5) {
            watch(cctv, 0);
            watch(cctv, 1);
            watch(cctv, 2);
            watch(cctv, 3);
        }
    }

    private static void watch(CCTV cctv, int dir) {
        Queue<CCTV> queue = new LinkedList<>();
        checked = new boolean[n][m];

        queue.offer(cctv);
        checked[cctv.x][cctv.y] = true;

        while (!queue.isEmpty()) {
            CCTV cur = queue.poll();

            int nx = cur.x + moving[dir][0];
            int ny = cur.y + moving[dir][1];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) break;
            if (copyMap[nx][ny] == 6) break;

            if (copyMap[nx][ny] == 0) {
                copyMap[nx][ny] = -1;

                queue.offer(new CCTV(nx, ny, cctv.num));
            }
            else {
                queue.offer(new CCTV(nx, ny, cctv.num));
            }
        }
    }
}
