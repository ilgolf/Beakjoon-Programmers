package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Beak_1517 {

    static int n;
    static long[] arr, tree, index;
    static int s = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new long[n];
        index = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        init();

        Map<Long, Integer> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            pos.put(arr[i], i);
        }

        index = Arrays.stream(arr).sorted().toArray();

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int idx = pos.get(index[i]);

            ans += sum(0, n - 1, 1, idx + 1, n - 1);
            update(0, n - 1, 1, idx, 1);
        }

        System.out.println(ans);
    }

    private static void update(int start, int end, int node, int idx, int dif) {
        if (start == end) {
            tree[node] = dif;
            return;
        }

        int mid = (start + end) / 2;

        if (idx <= mid) {
            update(start, mid, node * 2, idx, dif);
        }
        else {
            update(mid + 1, end, node * 2 + 1, idx, dif);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
     }

    private static long sum(int start, int end, int node, int left, int right) {
        if (end < left || right < start) {
            return 0;
        }
        
        else if (left <= start && end <= right) {
            return tree[node];
        }
        
        int mid = (start + end) / 2;
        
        return sum(start, mid, node * 2, left, right) +
                sum(mid + 1, end, node * 2 + 1, left, right);
    }

    private static void init() {
        while (s < n) {
            s *= 2;
        }

        tree = new long[s * 2];
    }
}
