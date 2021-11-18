package Beakjoon;

/**
 *
 * Deque로 푸는 문제
 * 1234 -> 342 로 변하는 과정에서 pollFirst, offerLast가 필요
 *
 */

import java.io.*;
import java.util.*;

public class Baek_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            deque.offer(i + 1);
        }

        while (deque.size() > 1) {
            deque.poll(); // 시작시 큐에서 하나 제거

            if (deque.isEmpty()) break;

            int num = deque.poll();
            deque.offer(num); // 빼서 마지막에 넣어주기
        }

        System.out.println(deque.poll());
    }
}