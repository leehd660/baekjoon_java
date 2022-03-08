package gold5;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class G5_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        int minNum = Math.min(N, K-1);
//        long answer = 1;
        BigInteger answer = new BigInteger(String.valueOf(1));
        BigInteger multipleNum = new BigInteger(String.valueOf(N+K-1));
//        int multiple = N+K-1;
        for (int i=0; i<minNum; i++) {
            answer = answer.multiply(multipleNum);
            multipleNum = multipleNum.subtract(new BigInteger(String.valueOf(1)));
        }
        BigInteger divideNum = new BigInteger(String.valueOf(minNum));
        for (int i=minNum; i>0; i--) {
            answer = answer.divide(divideNum);
            divideNum = divideNum.subtract(new BigInteger(String.valueOf(1)));
        }
        bw.write(String.valueOf(answer.mod(new BigInteger(String.valueOf(1000000000)))));
        bw.close();
    }
}
