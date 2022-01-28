package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Beak_7578 {

    static int n;
    static long[] tree;
    static int s;
    static Map<Integer, Integer> b = new HashMap<>();
    static int[] a;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());

        a = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b.put(Integer.parseInt(st.nextToken()), (i + 1));
        }
        
        init();

        for (int i = 0; i < n; i++) {
            int index = b.get(a[i]);
            update(index, 1);
            result += getSum(index, n);
        }

        System.out.println(result);
    }

    private static void update(int index, int value) {
        int k = s + index - 1;
        tree[k] += value;

        k /= 2;
        while (k >= 1) {
            tree[k] = tree[k * 2] + tree[k * 2 + 1];

            k /= 2;
        }
    }

    private static long getSum(int left, int right) {
        long sum = 0;

        left += s;
        right += s;

        while (left <= right) {
            if (left % 2 == 1) {
                sum += tree[left];
                left ++;
            }

            if (right % 2 == 0) {
                sum += tree[right];
                right --;
            }

            left >>= 1;
            right >>= 1;
        }

        return sum;
    }

    private static void init() {
        s = 1;
        
        while (s < n) {
            s *= 2;
        }
        
        tree = new long[s * 2];
    }
}
