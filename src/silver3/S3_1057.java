package silver3;

import java.io.*;
import java.util.StringTokenizer;

public class S3_1057 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String info = bf.readLine();
        StringTokenizer infoToken = new StringTokenizer(info);
        int totalNum = Integer.parseInt(infoToken.nextToken());
        int num1 = Integer.parseInt(infoToken.nextToken());
        int num2 = Integer.parseInt(infoToken.nextToken());
        int count = 1;
        while (true) {
            if ((num1+1)/2 == (num2+1)/2) {
                break;
            }
            else {
                num1 = (num1+1)/2;
                num2 = (num2+1)/2;
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
