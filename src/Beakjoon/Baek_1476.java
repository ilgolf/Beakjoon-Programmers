package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_1476 {
    
    public static void main(String[] args) throws IOException {
        var br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int year = 0;
        do {
            year++;
        } while ((year - a) % 15 != 0 || (year - b) % 28 != 0 || (year - c) % 19 != 0);

        System.out.println(year);
    }
}
