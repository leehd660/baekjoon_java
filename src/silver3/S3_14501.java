package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int days = Integer.parseInt(bf.readLine());
        int[] T = new int[days+1];
        int[] P = new int[days+1];
        for (int i=1; i<=days; i++) {
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            T[i] = Integer.parseInt(strArr[0]);
            P[i] = Integer.parseInt(strArr[1]);
        }
        List[] updateT = new List[days+1];
        for (int i=0; i<=days; i++) {
            updateT[i] = new ArrayList<Integer>();
        }
        for (int i=1; i<days+1; i++) {
            if (i+T[i]-1 > days) {
                continue;
            }
            else {
                updateT[i+ T[i] -1].add(i);
            }
        }
        int[] dp = new int[days+1];
        for (int i=1; i<days+1; i++) {
            if (updateT[i].isEmpty()) {
                dp[i] = dp[i-1];
            }
            else {
                int max = 0;
                for (int j=0; j<updateT[i].size(); j++) {
                    int n = dp[(int)updateT[i].get(j)-1] + P[(int)updateT[i].get(j)];
                    if (max < n) {
                        max = n;
                    }
                }
                max = Math.max(dp[i-1] , max);
                dp[i] = max;
            }
        }
        bw.write(String.valueOf(dp[days]));
        bw.close();
    }
}
