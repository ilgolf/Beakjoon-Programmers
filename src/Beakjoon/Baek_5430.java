package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_5430 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque;

    static void AC(String cmd) {
        boolean isRight = true;

        for (char ch : cmd.toCharArray()) {
            if (ch == 'R') {
                isRight = !isRight;
                continue;
            }

            if (isRight) {
                if (deque.pollFirst() == null) {
                    sb.append("error\n");
                    return;
                }
            } else {
                if (deque.pollLast() == null) {
                    sb.append("error\n");
                    return;
                }
            }
        }

        makeString(isRight);
    }

    static void makeString(boolean isRight) {
        sb.append('[');

        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t -- > 0) {
            String cmd = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");

            deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            AC(cmd);
        }

        System.out.println(sb);
    }
}
