package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_10989 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = (Integer.parseInt(br.readLine()));
        }

        StringBuilder sb = new StringBuilder();

        Arrays.sort(list);

        for (int val : list) {
            sb.append(val).append('\n');
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
