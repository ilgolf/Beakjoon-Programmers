package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baek_4153 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            long a = (long)(Math.pow(Integer.parseInt(st.nextToken()), 2));
            long b = (long)(Math.pow(Integer.parseInt(st.nextToken()), 2));
            long c = (long)(Math.pow(Integer.parseInt(st.nextToken()), 2));


            if (a == 0 && b == 0 && c == 0) break;

            if ((a + b) == c) sb.append("right").append('\n');
            else if ((a + c) == b) sb.append("right").append('\n');
            else if ((b + c) == a) sb.append("right").append('\n');
            else sb.append("wrong").append('\n');
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
