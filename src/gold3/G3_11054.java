package gold3;

import java.io.*;
import java.util.StringTokenizer;

public class G3_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }
        int[] dp_up = new int[n];
        int upMax = 1;
        dp_up[0] = 1;
        int[] dp_down = new int[n];
        int downMax = 1;
        dp_down[n-1] = 1;
        for (int i=1; i<n; i++) {
            for (int j=i-1; j>=0; j--) {
                if (arr[j]<arr[i]) {
                    dp_up[i] = Math.max(dp_up[i], dp_up[j]+1);
                    upMax = Math.max(upMax, dp_up[i]);
                }
                if (dp_up[i]==0) {
                    dp_up[i] = 1;
                }
            }
        }
        for (int i=n-2; i>=0; i--) {
            for (int j=i+1; j<n; j++) {
                if (arr[j]<arr[i]) {
                    dp_down[i] = Math.max(dp_down[i], dp_down[j]+1);
                    downMax = Math.max(downMax, dp_down[i]);
                }
                if (dp_down[i]==0) {
                    dp_down[i] = 1;
                }
            }
        }
        int[] total = new int[n];
        int totalMax = 0;
        for (int i=0; i<n; i++) {
            total[i] = dp_up[i]+dp_down[i]-1;
            totalMax = Math.max(totalMax, total[i]);
        }
        bw.write(String.valueOf(Math.max(Math.max(downMax,upMax),totalMax)));
        bw.close();
    }
}
