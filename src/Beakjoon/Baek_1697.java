package Beakjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1697 {

    static int n,k;
    static int[] checked = new int[100_001];

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        checked[n] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = curr + 1;
                }
                else if (i == 1) {
                    next = curr - 1;
                }
                else {
                    next = curr * 2;
                }

                if (next == k) {
                    System.out.println(checked[curr]);
                    return;
                }

                if (next >= 0 && next < checked.length && checked[next] == 0) {
                    queue.offer(next);
                    checked[next] = checked[curr] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
        } else {
            bfs();
        }
    }
}
