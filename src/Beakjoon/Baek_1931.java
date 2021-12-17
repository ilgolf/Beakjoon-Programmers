package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // Integer.parseInt() <- 문자를 숫자로
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int start = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i][0] >= start) {
                start = arr[i][1];
                count ++;
            }
        }

        System.out.println(count);
    }
}
