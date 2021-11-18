package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] cnt = new int[20_000_001];

        for(int i=0; i<N; i++) {
            cnt[Integer.parseInt(st.nextToken()) + 10_000_000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++) {
            sb.append(cnt[Integer.parseInt(st.nextToken()) + 10_000_000]).append(" ");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}