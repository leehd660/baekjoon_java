package silver3;

import java.io.*;
import java.util.Arrays;

public class S3_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        String timeArrLine = bf.readLine();
        String[] timeStrArr = timeArrLine.split(" ");
        int[] timeArr = new int[num];
        for (int i=0; i<timeStrArr.length; i++) {
            timeArr[i] = Integer.parseInt(timeStrArr[i]);
        }
        Arrays.sort(timeArr);
        int answer = 0;
        for (int i=0; i<num; i++) {
            answer += timeArr[i]*(num-i);
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
