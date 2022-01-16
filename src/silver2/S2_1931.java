package silver2;

import java.io.*;
import java.util.*;

public class S2_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nNum = Integer.parseInt(bf.readLine());
        // 끝나는 시간이 key, 그에 맞는 시작하는 시간들이 list에 들어감.
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxFinTime = 0;
        for (int i=0; i<nNum; i++) {
            String timeStr = bf.readLine();
            StringTokenizer st = new StringTokenizer(timeStr);
            int startTime = Integer.parseInt(st.nextToken());
            int finTime = Integer.parseInt(st.nextToken());
            maxFinTime = Math.max(maxFinTime, finTime);
            if (map.keySet().contains(finTime)) {
                map.get(finTime).add(startTime);
            }
            else {
                List<Integer> list = new ArrayList<>();
                map.put(finTime, list);
                map.get(finTime).add(startTime);
            }
        }
        int[] dp = new int[maxFinTime+1];
        if (!map.keySet().contains(0)) {
            dp[0] = 0;
        }
        else {
            dp[0] = 1;
        }
        for (int i=1; i<maxFinTime+1; i++) {
            int max = dp[i-1];
            int count = 0;
            if (map.keySet().contains(i)) {
                for (int num : map.get(i)) {
                    if (num == i) {
                        count++;
                    }
                    else {
                        max = Math.max(max, dp[num] + 1);
                    }
                }
            }
            dp[i] = max+count;
        }
        bw.write(String.valueOf(dp[maxFinTime]));
        bw.close();
    }
}
