package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_9019 {

    static int a,b;
    static final int MOD = 10000;
    static String[] cmd;
    static boolean[] checked;

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        cmd = new String[10000];
        checked = new boolean[10000];
        checked[a] = true;
        queue.offer(a);

        Arrays.fill(cmd, "");

        while (!queue.isEmpty() && !checked[b]) {
            int prev = queue.poll();

            int d = (2 * prev) % MOD;
            int s = (prev == 0) ? 9999 : prev - 1;
            int l = (prev % 1000) * 10 + prev / 1000;
            int r = (prev % 10) * 1000 + (prev / 10);

            if (!checked[d]) {
                queue.offer(d);
                checked[d] = true;
                cmd[d] = cmd[prev] + "D";
            }
            if (!checked[s]) {
                queue.offer(s);
                checked[s] = true;
                cmd[s] = cmd[prev] + "S";
            }
            if (!checked[l]) {
                queue.offer(l);
                checked[l] = true;
                cmd[l] = cmd[prev] + "L";
            }
            if (!checked[r]) {
                queue.offer(r);
                checked[r] = true;
                cmd[r] = cmd[prev] + "R";
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            bfs();

            System.out.println(cmd[b]);
        }
    }
}
