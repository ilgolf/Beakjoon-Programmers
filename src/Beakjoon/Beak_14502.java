package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS로 벽세우기 0 인 곳만 세울 수 있음!!
 * BFS로 벽세운 후 탐색
 */
public class Beak_14502 {

    static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] map, wall;
    static boolean[][] checked;
    static int[][] moving = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static ArrayList<P> viruses = new ArrayList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        checked = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    viruses.add(new P(i, j));
                }
            }
        }

        wall = copy(map);

        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int depth) {
        // 1. 체크인(생략)

        // 2. 목적지인가? (3개 벽 세움)
        if (depth == 3) {
            // BFS 탐색 시작
            bfs();
            return;
        }

        // 3. 연결 된 곳을 순회
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 4. 갈 수 있는가? 0인 곳 순회
                if (wall[i][j] == 0) {
                    wall[i][j] = 1;

                    dfs(depth + 1);

                    // 5. 체크 아웃
                    wall[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<P> queue = new LinkedList<>();
        int[][] copy = copy(wall);

        // 1. 체크인
        for (P virus : viruses) {
            queue.offer(new P(virus.x, virus.y));
        }

        while (!queue.isEmpty()) {
            P curr = queue.poll();

            // 2. 연결된 곳을 순회
            for (int i = 0; i < 4; i++) {
                int nx = curr.x + moving[i][0];
                int ny = curr.y + moving[i][1];

                // 3. 갈 수 있는가
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (copy[nx][ny] == 0) {
                        // 4. 체크인
                        copy[nx][ny] = 2;

                        // 5. 큐에 다음 장소를 저장
                        queue.offer(new P(nx, ny));
                    }
                }
            }
        }

        int count = countVirus(copy);
        max = Math.max(count, max);
    }

    private static int countVirus(int[][] arr) {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    count ++;
                }
            }
        }

        return count;
    }

    private static int[][] copy(int[][] map) {
        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (m >= 0) System.arraycopy(map[i], 0, copy[i], 0, m);
        }

        return copy;
    }
}
