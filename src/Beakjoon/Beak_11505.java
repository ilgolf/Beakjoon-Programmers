package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak_11505 {

    static int n, m, k;
    static long[] arr;
    static long[] tree;
    static int s = 1;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init();

        System.out.println(Arrays.toString(tree));

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            // 업데이트 == 1
            if (cmd == 1) {
                int a = Integer.parseInt(st.nextToken());
                long b = Long.parseLong(st.nextToken());

                update(a, b);
            }

            // 값 구하기 == 2
            else if (cmd == 2) {
                long a = Long.parseLong(st.nextToken());
                long b = Long.parseLong(st.nextToken());

                long result = find(1, s, 1, a, b) % MOD;
                resultBuilder.append(result).append('\n');
            }
        }

        System.out.println(resultBuilder);
    }

    // query를 이용하여 구간 곱 구해주기
    private static long find(int start, int end, int node, long left, long right) {
        // 범위 벗어남
        if (start > right || end < left) {
            return 1;
        }

        // 범위 안에 들었을 때
        else if (left <= start && end <= right) {
            return tree[node];
        }

        // 부모노드로 이동
        int mid = (start + end) / 2;

        return (find(start, mid, node * 2, left, right)
                * find(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }

    // 업데이트 쿼리
    private static void update(int target, long query) {
        int index = s + target - 1;

        tree[index] = query;

        index /= 2;
        while (index >= 1) {
            tree[index] = (tree[index * 2] * tree[index * 2 + 1] % MOD);

            index /= 2;
        }
    }

    private static void init() {
        while (s < n) {
            s *= 2;
        }

        tree = new long[s * 2];

        int k = 0;
        for (int i = s; i <= s + n - 1; i++) {
            tree[i] = arr[k ++];
        }

        for (int i = s - 1; i >= 1; i--) {
            tree[i] = (tree[i * 2 + 1] * tree[i * 2]) % MOD;
        }
    }
}
