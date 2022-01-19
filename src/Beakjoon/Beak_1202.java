package Beakjoon;

import java.io.*;
import java.util.*;

public class Beak_1202 {

    static class Jam implements Comparable<Jam> {
        int weight;
        int price;

        public Jam(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jam o) {
            return o.price - price;
        }
    }

    static int n, k;
    static long result = 0;
    static PriorityQueue<Jam> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[][] jams = new int[n][2];
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            
            jams[i][0] = weight;
            jams[i][1] = price;
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 가방, 보석 오름차순 정렬 (무게 순)
        Arrays.sort(jams, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(bags);

        int pos = 0; // 보석 위치

        // 가방 선택
        for (int i = 0; i < k; i++) {
            // 순회 하며 필요한 보석 담기
            while (pos < n) {
                // 담을 수 있는 무게만 담기
                if (jams[pos][0] <= bags[i]) {
                    queue.offer(new Jam(jams[pos][0], jams[pos][1]));
                } else {
                    break;
                }

                pos++;
            }

            // 힙 정렬 후 Top에 있는 값 빼오기
            if (!queue.isEmpty()) {
                result += queue.poll().price;
            }
        }

        System.out.println(result);
    }
}
