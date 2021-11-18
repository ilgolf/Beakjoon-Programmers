package Programmers;

import java.util.*;

public class BiggestNum {

    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] stArr = new String[numbers.length];

        int k = 0;
        for (int val : numbers) {
            stArr[k++] = String.valueOf(val);
        }

        Arrays.sort(stArr, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        if (stArr[0].equals("0")) return "0";

        for (String s : stArr) {
            answer.append(s);
        }

        return answer.toString();
    }
}
