package Beakjoon;

import java.io.*;
import java.util.*;

/**
 *
 * -2, 1, 2, 3, 5, 8  n = (5 / 2)  -> 2
 * -3, -2, -2, -1, -1
 *
 */

public class Baek_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            max = Math.max(max, map.get(arr[i]));
        }

        List<Integer> list = new ArrayList<>();


        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                list.add(key);
            }
        }

        Arrays.sort(arr);
        Collections.sort(list);

        int avg = ((int)Math.round((double)sum/n));
        int midIdx = arr[n / 2];
        int maxVal = list.size() > 1 ? list.get(1) : list.get(0);
        int range = arr[n - 1] - arr[0];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(String.valueOf(avg) + "\n");
        bw.write(String.valueOf(midIdx) + "\n");
        bw.write(String.valueOf(maxVal) + "\n");
        bw.write(String.valueOf(range) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
