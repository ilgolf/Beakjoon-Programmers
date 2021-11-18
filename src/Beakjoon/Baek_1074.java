package Beakjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Baek_1074 {

    static int n,r,c;
    static int count = 0;

    static void division(int x, int y, int size) {
        if (size == 1) return;

        if (x < size / 2 && y < size / 2) {
            division(x, y, size / 2);
        }
        else if (x < size / 2 && y >= size / 2) {
            count += size * size / 4;
            division(x, y - size / 2, size / 2);
        }
        else if (x >= size / 2 && y < size / 2) {
            count += (size * size / 4) * 2;
            division(x - size / 2, y, size / 2);
        }
        else {
            count += (size * size / 4) * 3;
            division(x - size / 2, y - size / 2, size / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int size = (int)(Math.pow(2, n));

        division(r, c, size);
        System.out.println(count);
    }
}
