package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_1966 {

    static int n;
    static int m;
    static int[] arr;
    static PriorityQueue<Integer> pq;

    static int print() {
        int result = 1;

        while (!pq.isEmpty()) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == pq.peek()) {
                    if(i == m) {
                        return result;
                    }
                    pq.poll();
                    result ++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T -- > 0) {
            pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int val : arr) pq.offer(val);

            sb.append(print()).append('\n');
        }
        System.out.println(sb);
    }
}
