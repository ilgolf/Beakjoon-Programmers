package Programmers;

import java.util.*;

public class KaKao2022_01 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> ids = new HashMap<>(); // 신고를 당한 횟수 저장 맵
        Map<String, Integer> result = new LinkedHashMap<>();
        int[] answer = new int[id_list.length];

        for (String id : id_list) {
            ids.put(id, 0);
            result.put(id, 0);
        }

        Set<String> duplicateCheck = new HashSet<>();

        for (String repo : report) {
            String[] line = repo.split(" ");

            if (duplicateCheck.contains(repo)) continue;

            duplicateCheck.add(repo);

            ids.put(line[1], ids.getOrDefault(line[1], 0) + 1);
        }

        for (String key : ids.keySet()) {
            System.out.println(ids.get(key));
        }


        for (String repo : duplicateCheck) {
            String[] line = repo.split(" ");

            if (ids.containsKey(line[1]) && ids.get(line[1]) >= k) {
                result.put(line[0], result.getOrDefault(line[0], result.get(line[0])) + 1);
            }
        }

        int l = 0;
        for (String s : result.keySet()) {
            answer[l ++] = result.get(s);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
}
