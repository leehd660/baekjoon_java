package gold5;

import java.io.*;
import java.util.StringTokenizer;

public class G5_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer NKtoken = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(NKtoken.nextToken());
        int K = Integer.parseInt(NKtoken.nextToken());
        int[] weightTable = new int[K+1];
        for (int i=0; i<N; i++) {
            StringTokenizer WVtoken = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(WVtoken.nextToken());
            int v = Integer.parseInt(WVtoken.nextToken());
            weightTable[w] = Math.max(weightTable[w], v);
        }
        int answer = 0;
        int[] dp = new int[K+1];
        for (int i=1; i<K+1; i++) {
            dp[i] = weightTable[i];
            for (int j=i-1; j>=j/2; j--) {
                if (i-j<j) {
                    dp[i] = Math.max(dp[i], weightTable[j] + weightTable[i - j]);
                }
            }
            answer = Math.max(dp[i], answer);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
