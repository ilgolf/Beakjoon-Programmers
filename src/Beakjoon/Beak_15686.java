package Beakjoon;

import java.io.*;
import java.util.*;

/**
 * Math.abs(r1 - r2) + Math.abs(c1 - c2) -> 치킨 거리
 * 0: 길, 1: 집, 2: 치킨집
 */

public class Beak_15686 {

    static class Chicken {
        int x, y;

        public Chicken(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static int[][] map;
    static List<Chicken> chickens = new ArrayList<>();
    static List<Chicken> person = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] checked;
    static int[] output;

    static void chickenSelection(int start, int depth) {
        output[depth] = start + 1;

        for (int i = start; i < chickens.size(); i++) {
            if (checked[i]) continue;

            checked[i] = true;
            chickenSelection(i, depth + 1);
            checked[i] = false;
        }

        if (depth == m - 1) {
            int sum = 0;
            int curr;

            for (Chicken chicken : person) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < m; j++) {
                    curr = calc(chicken, chickens.get(output[j] - 1));
                    min = Math.min(min, curr);
                }

                sum += min;
            }

            result = Math.min(result, sum);
        }
    }

    static int calc(Chicken c1, Chicken c2) {
        return Math.abs(c1.x - c2.x) + Math.abs(c1.y - c2.y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) person.add(new Chicken(i, j));
                else if (map[i][j] == 2) chickens.add(new Chicken(i, j));
            }
        }

        checked = new boolean[chickens.size()];
        output = new int[chickens.size()];

        for (int i = 0; i < chickens.size(); i++) {
            checked[i] = true;
            chickenSelection(i, 0);
            checked[i] = false;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
