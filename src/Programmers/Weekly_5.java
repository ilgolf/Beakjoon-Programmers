package Programmers;

import java.util.*;

/**
 *
 * A는 최대 5개 AAAAA -> AAAAE -> AAAAI -> ...
 * A = 0 + 1, E = 781 + 1, I = 1562 + 1
 * 뒤로 갈 때 마다 * 5
 *
 */

public class Weekly_5 {
    public int solution(String word) {
        int answer = 0;

        int num = 781;

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);

            switch (w) {
                case 'A':
                    answer += 1;
                    break;
                case 'E':
                    answer += 1 + num;
                    break;
                case 'I' :
                    answer += 1 + 2 * num;
                    break;
                case 'O' :
                    answer += 1 + 3 * num;
                    break;
                case 'U' :
                    answer += 1 + 4 * num;
                    break;
            }

            num = (num - i) / 5;
        }

        return answer;
    }
}
