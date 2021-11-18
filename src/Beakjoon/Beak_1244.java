package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_1244 {

    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());

        while (m -- > 0) {
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int i = index; i <= n; i+=index) {
                    arr[i] ^= 1;
                }
            }
            else {
                int left = index - 1;
                int right = index + 1;

                while (true) {
                    if (left < 1 || right >= n) break;
                    if (arr[left] != arr[right]) break;

                    left --;
                    right ++;
                }

                for ( ; left <= right; left ++) {
                    arr[left] ^= 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(' ');

            if (i % 20 == 0) {
                sb.append('\n');
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
