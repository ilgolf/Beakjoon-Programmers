package Programmers;

import java.util.*;

public class KaKao2022_03 {

    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Integer> map = new HashMap<>(); // key : 차량 번호, value : 입장 시간
        Map<Integer, Integer> result = new TreeMap<>(); // key : 차량 번호, value : 이용비

        /**
         * records[0] : 입/출 시간
         * records[1] : 차량번호
         * records[2] : 입/출 기록
         */
        for (String data : records) {
            String[] ele = data.split(" ");

            int time = calTime(ele[0]);
            int carNum = Integer.parseInt(ele[1]);
            String status = ele[2];

            // 차량이 나간다.
            if (status.equals("OUT")) {
                int start = map.get(carNum);
                int useTime = time - start;

                if (result.containsKey(carNum)) {
                    int a = result.get(carNum);
                    useTime += a;
                }

                result.put(carNum, useTime);
                map.remove(carNum);
                continue;
            }

            // 들어온다.
            map.put(carNum, time);
        }

        // 남은 차량이 있을 경우 : 시작 시간은 23:59 - 들어온 시간
        for (int key : map.keySet()) {
            Integer d = map.get(key);

            d = d == null ? 0 : d;

            int start = d;
            int useTime = 1439 - start;

            Integer e = result.get(key);
            e = e == null ? 0 : e;

            int total = e;

            result.put(key, total + useTime);
        }

        int[] answer = new int[result.size()];

        /**
         * fee[0] : 기본 시간
         * fee[1] : 기본 요금
         * fee[2] : 단위 시간
         * fee[3] : 단위 요금
         */
        int i = 0;
        for (int key : result.keySet()) {
            int time = result.get(key);

            if (time <= fees[0]) {
                time = fees[1];
            }
            else {
                time = fees[1] + (int) Math.ceil((double) (time - fees[0]) / fees[2]) * fees[3];
            }

            answer[i ++] = time;
        }

        return answer;
    }

    private static int calTime(String time) {
        String[] temp = time.split(":");

        int hour = Integer.parseInt(temp[0]) * 60;
        int min = Integer.parseInt(temp[1]);

        return hour + min;
    }
}
