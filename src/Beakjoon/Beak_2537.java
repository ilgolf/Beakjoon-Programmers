package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2537 {

    static int n, m;
    static long[] arr;
    static long[] minTree;
    static long[] maxTree;
    static int s = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        while (s < n) {
            s *= 2;
        }

        maxTree = new long[s * 2];
        minTree = new long[s * 2];

        minInit(1, n, 1);

        maxInit(1, n, 1);

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            resultBuilder
                    .append(minFind(1, n, 1, a, b))
                    .append(' ')
                    .append(maxFind(1, n, 1, a, b))
                    .append('\n');
        }

        System.out.println(resultBuilder);
    }

    private static long maxFind(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Long.MIN_VALUE;
        }

        if (left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;

        return Math.max(maxFind(start, mid, node * 2, left, right),
                maxFind(mid + 1, end, node * 2 + 1, left, right));
    }

    private static long minFind(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Long.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min(minFind(start, mid, node * 2, left, right),
                minFind(mid + 1, end, node * 2 + 1, left, right));
    }

    private static long maxInit(int start, int end, int node) {
        if (start == end) {
            return maxTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return maxTree[node] = Math.max(maxInit(start, mid, node * 2),
                maxInit(mid + 1, end, node * 2 + 1));
    }

    private static long minInit(int start, int end, int node) {
        if (start == end) {
            return minTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return minTree[node] = Math.min(minInit(start, mid, node * 2),
                minInit(mid + 1, end, node * 2 + 1));
    }
}
