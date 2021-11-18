package Programmers;

import java.util.Arrays;

public class DiffBit {

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                int lastIdx = binary.lastIndexOf("0");
                int firstIdx = binary.indexOf("1", lastIdx);

                if (lastIdx == -1) {
                    numbers[i] += 1;
                    binary = Long.toBinaryString(numbers[i]);
                    binary = binary.substring(0, 2) + binary.substring(2).replace("0", "1");
                } else {
                    binary = binary.substring(0, lastIdx) + "1" + binary.substring(lastIdx + 1, firstIdx) + "0" +
                            binary.substring(firstIdx + 1);
                }

                answer[i] = Long.parseLong(binary, 2);
            }
        }

        return answer;
    }
}
