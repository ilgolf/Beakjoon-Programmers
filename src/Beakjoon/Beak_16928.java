package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * 계단 올라가는 곳 1 도착점 2
 * 뱀 내려가는 곳 3 도착점 4
 *
 */

public class Beak_16928 {

    static final int SIZE = 101;
    static int[] map = new int[SIZE];
    static int[] count = new int[SIZE];
    static int n,m;
    static boolean[] checked = new boolean[SIZE];

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        checked[1] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == SIZE - 1) {
                System.out.println(count[curr]);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int next = curr + (i + 1);

                if ((SIZE - 1) < next) continue;
                if (checked[next]) continue;

                if (map[next] > 0) {
                    if (!checked[map[next]]) {
                        queue.offer(map[next]);
                        checked[next] = true;
                        checked[map[next]] = true;
                        count[map[next]] = count[curr] + 1;
                    }
                } else {
                    queue.offer(next);
                    checked[next] = true;
                    count[next] = count[curr] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a] = b;
        }

        bfs();
    }
}
