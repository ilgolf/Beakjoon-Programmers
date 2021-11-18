package Beakjoon;

import java.io.*;
import java.util.*;

public class Baek_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] nameArr = new String[n];

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            map.put(name, i + 1);
            nameArr[i] = name;
        }

        for (int i = 0; i < m; i++) {
            String str = br.readLine();

            if (isNumber(str)) {
                int index = Integer.parseInt(str);
                sb.append(nameArr[index - 1]);
            } else {
                sb.append(map.get(str));
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
