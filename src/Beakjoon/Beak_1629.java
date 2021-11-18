package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Beak_1629 {

    static long c;

    static long pow(long a, long b) {
        if (b == 0) {
            return 1 % c;
        }

        long res = pow(a, b / 2);

        if (b % 2 == 0) {
            return res * res % c;
        }

        return (res * res % c) * a % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(pow(a, b)));
        bw.flush();
        bw.close();
    }
}
