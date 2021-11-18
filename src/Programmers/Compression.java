package Programmers;

import java.util.*;

public class Compression {

    public static int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        char alpha = 'A';
        int idx = 27;
        boolean isEnd = false;

        for (int i = 1; i <= 26; i++) {
            map.put(alpha + "", i);
            alpha += 1;
        }

        for (int i = 0; i < msg.length(); i++) {
            String w = msg.charAt(i) + "";

            while (map.containsKey(w)) {
                i ++;
                if (i == msg.length()) {
                    isEnd = true;
                    break;
                }
                w += msg.charAt(i);
            }

            if (isEnd) {
                result.add(map.get(w));
                break;
            }

            result.add(map.get(w.substring(0, w.length() - 1)));
            map.put(w, idx ++);

            i --;
        }

        int[] answer = new int[result.size()];

        int k = 0;
        for (int val : result) {
            answer[k ++] = val;
        }

        return answer;
    }

    public static void main(String[] args) {
        String msg = "KAKAO";

        System.out.println(Arrays.toString(solution(msg)));
    }
}
