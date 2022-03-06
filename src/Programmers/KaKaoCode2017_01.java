package Programmers;

import java.util.*;

public class KaKaoCode2017_01 {

    public String solution(String sentence) {
        StringBuilder answer = new StringBuilder();

        Map<Character, ArrayList<Integer>> lowerCount = new LinkedHashMap<>();
        String invalid = "invalid";

        try {
            char[] c = sentence.toCharArray();

            for (int i = 0; i < c.length; i++) {
                if (Character.isLowerCase(c[i])) {
                    if (!lowerCount.containsKey(c[i])) {
                        lowerCount.put(c[i], new ArrayList<>());
                    }
                    lowerCount.get(c[i]).add(i);
                }
            }

            int stringIdx = 0;
            int startChar, endChar;
            int lastStartChar = -1, lastEndChar = -1;
            int startWord, endWord;
            int lastStartWord = -1, lastEndWord = -1;
            int count, distance;
            int rule;

            List<Integer> temp;

            for (char ch : lowerCount.keySet()) {
                temp = lowerCount.get(ch);
                count = temp.size();
                startChar = temp.get(0);
                endChar = temp.get(count - 1);

                if (count == 1 || count >= 3) {
                    for (int i = 1; i < count; i++) {
                        // 간격 2 넘어가면 x
                        if (temp.get(i) - temp.get(i - 1) != 2) return invalid;
                    }
                    rule = 1;
                }

                else {
                    distance = endChar - startChar;

                    // 다른 기호 안에 있음 (규칙 2와 겹침)
                    if (distance == 2 && (endChar < lastEndChar && startChar > lastStartChar)) {
                        rule = 1;
                    }

                    else if (distance >= 2) {
                        rule = 2;
                    }

                    // 소문자 연속은 x
                    else {
                        return invalid;
                    }
                }

                if (rule == 1) {
                    startWord = startChar - 1;
                    endWord = endChar + 1;

                    // 이전 단어 안에 포함되어 있는 경우
                    if (lastStartWord < startWord && lastEndWord > endWord) {
                        // 규칙 2 아니면 안됨
                        if (startChar - lastStartChar == 2 && lastEndChar - endChar == 2) {
                            continue;
                        }
                        else {
                            return invalid;
                        }
                    }
                }

                else {
                    startWord = startChar;
                    endWord = endChar;

                    // 규칙 2는 중복되면 안됨
                    if (lastStartWord < startWord && lastEndWord > endWord) return invalid;
                }

                if (lastEndWord >= startWord) return invalid;

                // 소문자 등장 이전에 존재하던 앞의 단어 추가
                if (stringIdx < startWord) {
                    answer.append(makeWord(sentence, stringIdx, startWord - 1));
                    answer.append(" ");
                }

                answer.append(makeWord(sentence, startWord, endWord));
                answer.append(" ");
                lastStartWord = startWord;
                lastEndWord = endWord;
                lastStartChar = startChar;
                lastEndChar = endChar;
                stringIdx = endWord + 1;
            }

            // 뒤에 남은 단어들도 더하기
            if (stringIdx < sentence.length()) {
                answer.append(makeWord(sentence, stringIdx, sentence.length() - 1));
            }

        } catch (Exception e) {
            return invalid;
        }

        return answer.toString().trim();
    }

    private String makeWord(String sentence, int start, int end) {
        String word = sentence.substring(start, end + 1);
        return word.replaceAll("[a-z]", "");
    }
}
