package silver3;

import java.io.*;

public class S3_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer =0;
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int[] stare = new int[num];
        for (int i=0; i<num; i++) {
            stare[i] = Integer.parseInt(bf.readLine());
        }
        if (num==1) {
            answer = stare[0];
        }
        else if (num==2) {
            answer = stare[0] + stare[1];
        }
        else {
            int[] dp1arr = new int[num];
            int[] dp2arr = new int[num];
            dp1arr[0] = stare[0];
            dp2arr[0] = stare[0];
            dp1arr[1] = stare[0] + stare[1];
            dp2arr[1] = stare[1];
            for (int i = 2; i < num; i++) {
                dp1arr[i] = stare[i] + dp2arr[i - 1];
                dp2arr[i] = stare[i] + Math.max(dp1arr[i - 2], dp2arr[i - 2]);
            }
            answer = Math.max(dp1arr[num - 1], dp2arr[num - 1]);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
