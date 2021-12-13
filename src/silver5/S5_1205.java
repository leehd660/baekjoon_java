package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S5_1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N_S_P = bf.readLine();
        String[] NSParr = N_S_P.split(" ");
        int N = Integer.parseInt(NSParr[0]);
        int newScore = Integer.parseInt(NSParr[1]);
        int P = Integer.parseInt(NSParr[2]);
        int answer = 0;
        int inputIndex = 0;
        int upRankNum = 0;
        int sameScoreNum = 0;
        if (N == 0) {
            answer = 1;
        }
        else {
            String rankStr = bf.readLine();
            String[] rankStrArr = rankStr.split(" ");
            List<Integer> rankList = new ArrayList<>();
            Map<Integer, Integer> rankMap = new HashMap<>();
            for (String rankScore : rankStrArr) {
                int score = Integer.parseInt(rankScore);
                if (!rankList.contains(score)) {
                    rankList.add(score);
                }
                if (rankMap.keySet().contains(score)) {
                    rankMap.put(score, rankMap.get(score) + 1);
                } else {
                    rankMap.put(score, 1);
                }
            }

            for (int i = 0; i < rankList.size(); i++) {
                if (rankList.get(i) == newScore) {
                    inputIndex = i;
//                    rankMap.put(newScore, rankMap.get(newScore)+1 );
                    sameScoreNum = rankMap.get(newScore);
                    break;
                } else if (rankList.get(i) < newScore) {
                    inputIndex = i;
                    rankMap.put(newScore, 1);
                    sameScoreNum = 0;
                    break;
                } else {
                    upRankNum += rankMap.get(rankList.get(i));
                }
            }
        }
        if (upRankNum+sameScoreNum >= P) {
            answer = -1;
        }
        else {
            answer = upRankNum+1;
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
