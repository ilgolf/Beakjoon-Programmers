package Programmers;

import java.util.*;

public class BestAlbum {

    static class Album {
        String song; // 장르
        int play; // 재생 횟수
        int idx; // 고유 번호

        public Album(String song, int play, int idx) {
            this.song = song;
            this.play = play;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> title = new HashMap<>();
        List<Album> albums = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            title.put(genres[i], title.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> list = new ArrayList<>();
        while (title.size() != 0) {
            int max = -1;
            String maxTitle = "";

            for (String key : title.keySet()) {
                int tmpCnt = title.get(key);
                if (tmpCnt > max) {
                    max = tmpCnt;
                    maxTitle = key;
                }
            }

            list.add(maxTitle);
            title.remove(maxTitle);
        }

        for (String gern : list) {
            List<Album> temp = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(gern)) {
                    temp.add(new Album(gern, plays[i], i));
                }
            }

            temp.sort((o1, o2) -> o2.play - o1.play);
            albums.add(temp.get(0));
            if (temp.size() != 1) {
                albums.add(temp.get(1));
            }
        }

        int[] answer = new int[albums.size()];

        for (int i = 0; i < albums.size(); i++) {
            answer[i] = albums.get(i).idx;
        }

        return answer;
    }
}
