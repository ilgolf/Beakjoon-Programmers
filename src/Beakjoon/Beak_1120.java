package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_1120 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int diff = 55;

        String a = st.nextToken();
        String b = st.nextToken();

        for (int i = 0; i < b.length() - a.length() + 1; i++) {
            int count = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j + i)) {
                    count ++;
                }
            }

            diff = Math.min(diff, count);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(diff));
        bw.flush();
        bw.close();
    }
}