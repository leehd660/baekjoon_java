package gold5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G5_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        int[][] arr = new int[num][2];
        for (int i=0; i<num; i++) {
            StringTokenizer token = new StringTokenizer(bf.readLine());
            arr[i][0] = Integer.parseInt(token.nextToken());
            arr[i][1] = Integer.parseInt(token.nextToken());
        }
        //2차원 배열 정렬
        Arrays.sort(arr,Comparator.comparingInt(o1->o1[0]));
        int[] dp = new int[num];
        int answer = 0;
        for(int i=0; i<num; i++) {
            for (int j=i-1; j>=0; j--) {
                if (arr[j][1]<arr[i][1]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i]==0) dp[i]=1;
            answer = Math.max(answer, dp[i]);
        }
        bw.write(String.valueOf(num-answer));
        bw.close();
    }
}
