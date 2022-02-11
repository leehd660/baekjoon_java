package silver1;

import java.io.*;
import java.util.StringTokenizer;

public class S1_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(bf.readLine());
        for (int caseIndex=0; caseIndex<caseNum; caseIndex++) {
            int num = Integer.parseInt(bf.readLine());
            int[][] arr = new int[num][2];
            StringTokenizer token1 = new StringTokenizer(bf.readLine());
            StringTokenizer token2 = new StringTokenizer(bf.readLine());
            for (int i=0; i<num; i++) {
                arr[i][0] = Integer.parseInt(token1.nextToken());
            }
            for (int i=0; i<num; i++) {
                arr[i][1] = Integer.parseInt(token2.nextToken());
            }
            int[][] maxArr = new int[num][2];
            maxArr[0][0] = arr[0][0];
            maxArr[0][1] = arr[0][1];
            for (int i=1; i<num; i++) {
                arr[i][0] += maxArr[i-1][1];
                arr[i][1] += maxArr[i-1][0];
                maxArr[i][0] = Math.max(maxArr[i-1][0], arr[i][0]);
                maxArr[i][1] = Math.max(maxArr[i-1][1], arr[i][1]);
            }
            bw.write(String.valueOf(Math.max(maxArr[num-1][0],maxArr[num-1][1]))+"\n");
        }
        bw.close();
    }
}
