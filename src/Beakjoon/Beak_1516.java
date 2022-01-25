package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Beak_1516 {

    static int n;
    static int[] inDegree;
    static int[] times;
    static List<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        inDegree = new int[n + 1];
        times = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());

            times[i] = time;

            while (true) {
                int input = Integer.parseInt(st.nextToken());

                if (input == -1) {
                    break;
                }

                graph.get(input).add(i);
                inDegree[i] ++;
            }
        }

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int val : graph.get(node)) {
                inDegree[val] --;

                result[val] = Math.max(result[val], result[node] + times[node]);

                if (inDegree[val] == 0) {
                    queue.offer(val);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(result[i] + times[i]).append('\n');
        }

        System.out.println(sb);
    }
}
