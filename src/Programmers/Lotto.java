package Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();

        for (int lotto : lottos) {
            if (lotto != 0) {
                set.add(lotto);
            }
        }

        int minCount = 0;

        for (int win_num : win_nums) {
            if (set.contains(win_num)) {
                minCount++;
            }
        }

        int zeroCount = lottos.length - set.size();
        int maxCount = minCount + zeroCount;

        int maxRank = makeRank(maxCount);
        int minRank = makeRank(minCount);

        return new int[] {minRank, maxRank};
    }

    private int makeRank(int count) {
        switch (count) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}
