package silver3;

import java.io.*;

public class S3_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        if (num==1) {
            bw.write("1");
        }
        else if (num==2) {
            bw.write("1");
        }
        else {
            long[] dp1 = new long[num];
            long[] dp2 = new long[num];
            dp1[0] = 1;
            dp2[0] = 1;
            dp1[1] = 1;
            dp2[1] = 0;
            for (int i=2; i<num; i++) {
                dp1[i] = dp1[i-1] + dp2[i-1];
                dp2[i] = dp1[i-1];
            }
            long answer = dp1[num-1]+dp2[num-1];
            bw.write(String.valueOf(answer));
        }
        bw.close();
    }
}
