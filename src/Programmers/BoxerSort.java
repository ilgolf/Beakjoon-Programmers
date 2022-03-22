package Programmers;

import java.util.*;

/**
 *
 *  우선 적으로 각각 승률을 구해주고 자기보다 무거운 복서를 이긴 횟수를 구해줌
 *  1. 승률 비교해서 정렬
 *  2. 몸무게가 무거운 횟수 순 정렬
 *  3. 작은 번호 순 정렬
 *
 */

public class BoxerSort {

    static class boxer {
        double win; // 승률
        int count; // 무거운 사람 이긴 횟수
        int idx; // 복서 인덱스
        int weight; // 무게

        public boxer(double win, int count, int idx, int weight) {
            this.win = win;
            this.count = count;
            this.idx = idx;
            this.weight = weight;
        }
    }

    static List<boxer> list = new ArrayList<>(); // 각 복서 특징들 저장
    static Map<Integer, Integer> map = new HashMap<>(); // 복서 인덱스와 몸무게 저장

    static boxer game(int weight, String round, int num) {
        double win = 0, none = 0;
        int cnt = 0;

        int idx = 0;
        for(char ch : round.toCharArray()) {
            switch (ch) {
                case 'W':
                    win +=1;
                    if(map.get(idx) > weight) cnt ++;
                    break;
                case 'N':
                    none +=1;
                    break;
                case 'L':
                    break;
            }
            idx ++;
        }
        double cal = (win/ (round.length() - none));

        return new boxer(Double.isNaN(cal) ? 0 : cal, cnt, num, weight);
    }

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];

        for (int i = 0; i < weights.length; i++) {
            map.put(i, weights[i]);   // {1, 50}, {2, 82}, ... {4, 120}
        }

        for (int i = 0; i < weights.length; i++) {
            boxer temp = game(weights[i], head2head[i], i);
            list.add(temp);
        }

        list.sort((o1, o2) -> {
            if (o1.win == o2.win) {
                if(o1.count  == o2.count) {
                    if(o1.weight == o2.weight) {
                        return o1.idx - o2.idx;
                    }
                    return o2.weight - o1.weight;
                }
                return o2.count - o1.count;
            }
            return o1.win > o2.win ? 1 : -1;
        });

        int k = 0;
        for(boxer b : list) {
            answer[k++] = b.idx + 1;
        }

        return answer;
    }
}
