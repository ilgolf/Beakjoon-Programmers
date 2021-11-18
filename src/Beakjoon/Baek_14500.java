package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * 주어진 블록 : {1, 1, 1, 1}, {{1, 1}, {1, 1}}, ... 5개
 *
 * 0. map 배열과 똑같은 배열을 선언해주고 덮어 씌운다.
 * 1. 각각 회전해가며 하나씩 모두 배열에 대입해본다. (dfs 활용 재귀적으로 돌리면 댐)
 * (이때 ㅗ 모양은 상하좌우가 불가능 그렇기에 별도 메소드로 검사 + 모양 기준으로 가장 작은 날개 부분을 제외하는 방법)
 * 2. 그 중 최댓 값을 계속 갱신해준다.
 * 3. 모든 경우의 수를 돌려보고 마지막에 갱신된 최대 값을 출력
 *
 */

public class Baek_14500 {

    static int n,m;
    static int[][] map;
    static int max = 0;
    static boolean[][] checked;
    static int[][] moving = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean isValid(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < m;
    }

    static void dfs(int x, int y, int depth, int sum) {

        if (depth == 4) { // 블록 크기 4
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nX = x + moving[i][0];
            int nY = y + moving[i][1];

            if (isValid(nX, nY) && !checked[nX][nY]) {
                checked[nX][nY] = true;
                dfs(nX, nY, depth + 1, sum + map[nX][nY]);
                checked[nX][nY] = false;
            }
        }
    }

    // 예외 사항
    static void exceptCase(int x, int y) {
        int wing = 4;
        int min = Integer.MAX_VALUE;
        int sum = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + moving[i][0];
            int ny = y + moving[i][1];

            if (wing <= 2) {
                return;
            }

            if (!isValid(nx, ny)) {
                wing --;
                continue;
            }

            min = Math.min(min, map[nx][ny]);
            sum += map[nx][ny];
        }

        if (wing == 4) {
            sum = sum - min;
        }

        max = Math.max(max, sum);
    }

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
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, 0, 0);
                exceptCase(i, j); // ㅗ 모양은 제외
            }
        }

        System.out.println(max);
    }
}
