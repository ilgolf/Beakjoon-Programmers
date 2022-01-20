package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_2042 {

    static int n, m, k;
    static long[] arr;
    static long[] tree;
    static int s;

    // init
    static void init() {
        s = 1;
        while (s < n) {
            s = s * 2;
        }
        tree = new long[s * 2];
        int k = 0;
        for (int i = s; i <= s + n - 1; i++) {
            tree[i] = arr[k++];
        }

        for (int i = s - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    // query
    static long query(long left, long right, int node, int qLeft, int qRight) {

        // 연관 없음
        if (left > qRight || qLeft > right) {
            return 0;
        }

        // 값 사용
        else if (qLeft <= left && right <= qRight) {
            return tree[node];
        }

        // 사용 불가
        long mid = (left + right) / 2;
        return query(left, mid, node * 2, qLeft, qRight) + query(mid + 1, right, node * 2 + 1, qLeft, qRight);
    }


    // update
    static void update(int target, long value) {
        int index = s + target - 1;

        tree[index] = value;

        index = index / 2;
        while (index >= 1) {
            tree[index] = tree[index * 2] + tree[index * 2 + 1];

            index /= 2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init();

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                long num2 = Long.parseLong(st.nextToken());
                update(num1, num2);
            } else {
                int num2 = Integer.parseInt(st.nextToken());
                long result = query(1, s, 1, num1, num2);
                sb.append(result).append('\n');
            }
        }

        System.out.println(sb);
    }
}
