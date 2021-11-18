package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while (n -- > 0) {
            int number = Integer.parseInt(br.readLine());

            if (number == 0) {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll()).append('\n');
                } else {
                    sb.append('0').append('\n');
                }
                continue;
            }

            pq.offer(number);
        }

        System.out.println(sb);
    }
}
