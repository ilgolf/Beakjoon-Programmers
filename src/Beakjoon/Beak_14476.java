package Beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak_14476 {

    static int n;
    static int[] nums;

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] lr = new int[n];
        int[] rl = new int[n];

        lr[0] = nums[0];
        rl[0] = nums[nums.length - 1];

        // LR
        for (int i = 1; i < nums.length; i++) {
            lr[i] = gcd(lr[i - 1], nums[i]);
        }

        // RL
        for (int i = nums.length - 2; i >= 0; i--) {
            rl[i] = gcd(lr[i + 1], nums[i]);
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            int gcd;

            if (i == 0) {
                gcd = lr[1];
            } else if (i == n - 1) {
                gcd = rl[n - 2];
            } else {
                gcd = gcd(lr[i - 1], rl[i + 1]);
            }

            if (nums[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIndex = i;
            }
        }

        if (max == 0) {
            System.out.println(-1);
        }

        System.out.println(nums[maxIndex] + " " + maxIndex);
    }
}
