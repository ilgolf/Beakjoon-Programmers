package Beakjoon;

import java.io.*;
import java.util.*;

public class Beak_1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<String> strList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strList.add(br.readLine());
        }

        strList.stream()
                .distinct()
                .sorted(((o1, o2) -> {
                    if (o1.length() == o2.length()) return o1.compareTo(o2);
                    return o1.length() - o2.length();
                }))
                .forEach(System.out :: println);
    }
}
