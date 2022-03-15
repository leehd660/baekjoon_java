package gold4;

import java.io.*;
import java.util.StringTokenizer;

public class G4_17070 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[][] map = new int[n][n];
        int[][][] dp = new int[3][n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            for (int j=0; j<n; j++) {
                if (token.nextToken().equals("1")) {
                    map[i][j] = -1;
                }
            }
        }

        dp[0][0][1] = 1;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(map[i][j] == -1) {
                    continue;
                }
                else {
                    //0인 가로 먼저
                    if (j-1>=0) {
                        dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1] + dp[0][i][j];
                    }
                    if (i-1>=0) {
                        dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j] + dp[1][i][j];
                    }
                    if (i-1>=0 && j-1>=0 && map[i][j] != -1 && map[i-1][j] != -1 && map[i][j-1] != -1) {
                        dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1] + dp[2][i][j];
                    }
                }
            }
        }
        bw.write(String.valueOf(dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1]));
        bw.close();
    }
}
