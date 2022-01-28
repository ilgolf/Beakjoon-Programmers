package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_14003 {

    static int n;
    static int[] arr;
    static int[] dp;
    static int[] indexOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];
        indexOrder = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int length = 0;
        dp[0] = arr[0];
        indexOrder[0] = 0;

        for (int i = 1; i < n; i++) {
            int binarySearch = binarySearch(arr[i], length);
            indexOrder[i] = binarySearch;
            if (binarySearch > length) {
                length ++;
                dp[length] = arr[i];
            }

            else {
                dp[binarySearch] = arr[i];
            }
        }

        result.append(length + 1).append('\n');

        int[] nums = new int[length + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (length == indexOrder[i]) {
                nums[length] = arr[i];
                length --;
            }
        }

        for (int num : nums) {
            result.append(num).append(' ');
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }

    private static int binarySearch(int val, int length) {
        int left = 0;
        int right = length;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (dp[mid] > val) {
                right = mid - 1;
            }
            else if (dp[mid] < val) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }

        return left;
    }
}
