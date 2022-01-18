package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beak_3055 {

    static class P {
        int x, y, count;
        char type;

        public P(int x, int y, int count, char type) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.type = type;
        }
    }

    static int r, c;
    static char[][] map;
    static boolean[][] checked;
    static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static String bfs(int pX, int pY) {
        Queue<P> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    queue.offer(new P(i, j, 0, '*'));
                }
            }
        }

        queue.offer(new P(pX, pY, 0, 'S'));
        checked[pX][pY] = true;

        while (!queue.isEmpty()) {
            // 물 부터 이동(큐에서 꺼냄)
            P cur = queue.poll();

            // 목적지 인가? (type S가 type D에 도착)
            if (map[cur.x][cur.y] == 'D' && cur.type == 'S') {
                return String.valueOf(cur.count);
            }

            // 물 부터 인접 행렬 순회
            if (cur.type == '*') {
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + moving[i][0];
                    int ny = cur.y + moving[i][1];

                    // 물 갈 수 있는가? (범위, .인지)
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (map[nx][ny] == '.') {
                            // 체크인 : 물
                            map[nx][ny] = '*';
                            // 큐에 넣기 : 물
                            queue.offer(new P(nx, ny, 0, '*'));
                        }
                    }
                }
            }
            // 고슴도치 순회
            else if (cur.type == 'S') {
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + moving[i][0];
                    int ny = cur.y + moving[i][1];

                    // 고슴도치 갈 수 있는가? (범위, 방문 여부, .과 D만 갈 수 있다.)
                    if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                        if (!checked[nx][ny]) {
                            if (map[nx][ny] == '.' || map[nx][ny] == 'D') {
                                // 체크인 : 방문 체크
                                checked[nx][ny] = true;
                                // 큐에 넣기 : 고슴도치
                                queue.offer(new P(nx, ny, cur.count + 1, 'S'));
                            }
                        }
                    }
                }
            }
        }

        return "KAKTUS";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        checked = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int pX = 0, pY = 0; // 고슴도치 위치

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'S') {
                    pX = i;
                    pY = j;
                }
            }
        }

        String result = bfs(pX, pY);

        System.out.println(result);
    }
}
