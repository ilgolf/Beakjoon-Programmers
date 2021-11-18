package Beakjoon;

import java.util.*;
import java.io.*;

/**
 *
 * 1, 2, 3, 4, 5, 6, 7 -> 3456712
 *
 */

public class Baek_11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            queue.offer(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while (n -- > 1) {
            for (int i = 0; i < k - 1; i++) {
                int a = queue.poll();

                queue.offer(a);
            }

            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append(">");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
