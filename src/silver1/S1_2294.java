package silver1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class S1_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (!list.contains(num) && num<=k) {
                list.add(num);
            }
        }
        Collections.sort(list);
        int[] dp = new int[k+1];
        for (int num : list) {
            dp[num] = 1;
        }
        for(int i=1; i<=k; i++) {
            for (int num : list) {
                if (i-num>=0 && dp[i-num]!=0) {
                    if (dp[i] == 0) {
                        dp[i] = dp[i-num]+1;
                    }
                    else {
                        dp[i] = Math.min(dp[i], dp[i-num]+1);
                    }
                }
            }
        }
        if (dp[k]==0) {
            bw.write("-1");
        }
        else {
            bw.write(String.valueOf(dp[k]));
        }
        bw.close();
    }
}
