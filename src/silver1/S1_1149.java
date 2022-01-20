package silver1;

import java.io.*;
import java.util.StringTokenizer;

public class S1_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int houseNum = Integer.parseInt(bf.readLine());
        int[][] cost = new int[houseNum][3];
        for (int i=0; i<houseNum; i++) {
            String RGBcost = bf.readLine();
            StringTokenizer st = new StringTokenizer(RGBcost);
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
//        int[][] dp = new int[houseNum][3];
//        dp[0][0] = cost[0][0];
//        dp[0][1] = cost[0][1];
//        dp[0][2] = cost[0][2];
        for (int i=1; i<houseNum; i++) {
            for (int j=0; j<3; j++) {
                int min = 1000000;
                for (int k=0; k<3; k++) {
                    if (k != j) {
                        min = Math.min(min, cost[i-1][k]);
                    }
                }
                cost[i][j] = cost[i][j] + min;
            }
        }
        int answer = 1000000;
        for (int i=0; i<3; i++) {
            answer = Math.min(answer, cost[houseNum-1][i]);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
