package silver1;

import java.io.*;

public class S1_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[] juice = new int[N];
        for (int i=0; i<N; i++) {
            juice[i] = Integer.parseInt(bf.readLine());
        }
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        int[] dp3 = new int[N];
        dp1[0] = juice[0];
        dp2[0] = juice[0];
        dp3[0] = 0;
        int dp1Max = dp1[0];
        int dp2Max = dp2[0];
        int dp3Max = dp3[0];
        for (int i=1; i<N; i++) {
            dp1[i] = dp2[i-1] + juice[i];
            dp1Max = Math.max(dp1Max,dp1[i]);
//            if (i==1) {
//                dp2[i] = dp3[i-1];
//                dp2Max = Math.max(dp2Max,dp2[i]);
//            }
//            else {
//                dp2[i] = Math.max(dp2[i-2],Math.max(dp1[i-2],dp3[i-1])) + juice[i];
//                dp2Max = Math.max(dp2Max,dp2[i]);
//            }
            dp2[i] = dp3[i-1] + juice[i];
            dp2Max = Math.max(dp2Max,dp2[i]);
            dp3[i] = Math.max(Math.max(dp1[i-1],dp2[i-1]),dp3[i-1]);
            dp3Max = Math.max(dp3Max, dp3[i]);
        }
        bw.write(String.valueOf(Math.max(dp1Max,Math.max(dp2Max,dp3Max))));
        bw.close();
    }
}
