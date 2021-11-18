package Beakjoon;

import java.io.*;
import java.util.*;

/**
 *
 * 아기상어 이동시 1초 -> count 1씩 증가
 * 먹는데 시간이 안듬 -> 따로 처리 x
 * 자기보다 큰 물고기만 남았을 때에는 종료
 * BFS 돌며 자기보다 작은 물고기일 때 0일때 이동 및 잡아먹는다.
 * 잡아먹은 갯수가 자기 크기일 경우 크기 1 증가
 *
 */

public class Beak_16236 {

    static class P {
        int x, y, count;

        public P(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    static int sharkSize; // 초기 상어 크기 2
    static int n, second, feedCount;
    static int[][] map;
    static boolean[][] checked;
    static int[][] moving = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static List<P> feedList;

    static boolean isValid(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        checked = new boolean[n][n];
        feedCount = 0;
        sharkSize = 2;
        int sx = 0, sy = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i; // 값들 저장
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            Queue<P> queue = new LinkedList<>();
            feedList = new ArrayList<>(); // 먹을 수 있는 먹이 위치 저장
            checked = new boolean[n][n];
            checked[sx][sy] = true;
            queue.offer(new P(sx, sy, 0));

            while (!queue.isEmpty()) {
                P curr = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = curr.x + moving[i][0];
                    int ny = curr.y + moving[i][1];

                    if (!isValid(nx, ny) && !checked[nx][ny]) {
                        if (1 <= map[nx][ny] && map[nx][ny] < sharkSize) {
                            queue.offer(new P(nx, ny, curr.count + 1));
                            feedList.add(new P(nx, ny, curr.count + 1)); // 먹을 수 있는 물고기 저장
                            checked[nx][ny] = true;
                        } else if (map[nx][ny] == sharkSize || map[nx][ny] == 0) {
                            queue.offer(new P(nx, ny, curr.count + 1));
                            checked[nx][ny] = true;
                        }
                    }
                }
            }

            if (feedList.size() == 0) {
                System.out.println(second);
                return;
            }

            P possible = feedList.get(0); // 먹이를 먹을 수 있는 상황

            for (int i = 1; i < feedList.size(); i++) {
                if (possible.count > feedList.get(i).count) {
                    possible = feedList.get(i);
                }

                if (possible.count == feedList.get(i).count) {
                    if (possible.x > feedList.get(i).x) {
                        possible = feedList.get(i);
                    }
                }
            }

            second += possible.count;
            feedCount ++;
            map[possible.x][possible.y] = 0;

            if (feedCount == sharkSize) {
                sharkSize ++;
                feedCount = 0;
            }

            sx = possible.x;
            sy = possible.y;
        }
    }
}
