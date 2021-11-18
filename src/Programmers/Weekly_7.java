package Programmers;

import java.util.*;

public class Weekly_7 {
    public int[] solution(int[] enter, int[] leave) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[enter.length];
        int i = 0 ,j = 0;

        while (i != enter.length && j != enter.length) {
            map.put(enter[i], enter[i]);

            if (map.size() > 1) {
                for (int key : map.keySet()) {
                    answer[key - 1] ++;
                }
                answer[enter[i] - 1] += map.size() - 2;
            }

            while (true) {
                if (j < enter.length && map.containsKey(leave[j])) {
                    map.remove(leave[j]);
                    j ++;
                } else {
                    break;
                }
            }
            i ++;
        }

        return answer;
    }
}
