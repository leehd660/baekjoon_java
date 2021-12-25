package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        List<Integer> dp = new ArrayList<>();
        for (int i=0; i<num; i++) {
            if (i==0) {
                dp.add(1);
            }
            else if (i==1) {
                dp.add(3);
            }
            else {
                int checkNum = dp.get(i-2)*2 + dp.get(i-1);
                if (checkNum >= 10007) {
                    checkNum = checkNum%10007;
                }
                dp.add(checkNum);
            }
        }
        bw.write(String.valueOf(dp.get(num-1)));
        bw.close();
    }
}
