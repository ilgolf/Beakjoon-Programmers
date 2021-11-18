package Beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * 4 1 5 2 3  -> 1 2 3 / 4 5
 * 1 3 7 9 5 -> 1 3 5 7 9
 *
 */

public class Baek_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] line = br.readLine().split(" ");
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[m];

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            int right = n - 1;
            int left = 0;
            int num = Integer.parseInt(st.nextToken());

            while(left <= right) {
                int mid = (left + right) / 2;

                if (num == arr[mid]) {
                    result[i] = 1;
                    break;
                }

                if (num > arr[mid]) {
                    left = mid + 1;
                }
                else if (num < arr[mid]) {
                    right = mid - 1;
                }
            }
        }

        for (int val : result) {
            System.out.println(val);
        }
    }
}
