package Beakjoon;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.*;

public class Baek_9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        int[] result = new int[t];

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[][] clothes = new String[n][2];

            for (int j = 0; j < n; j++) {
                clothes[i] = br.readLine().split(" ");
            }

            result[i] = Arrays.stream(clothes)
                    .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                    .values()
                    .stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int val : result) {
            bw.write(String.valueOf(val) + '\n');
        }

        bw.flush();
        bw.close();
    }
}
