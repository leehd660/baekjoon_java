package silver4;

import java.io.*;
import java.math.BigInteger;

public class S4_10826 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        BigInteger answer = BigInteger.ZERO;
        BigInteger N_1Num = BigInteger.ONE;
        BigInteger N_2Num = BigInteger.ZERO;
        if (num == 0) {
            answer = N_2Num;
        }
        else if (num ==1) {
            answer = N_1Num;
        }
        else {
            for (int i=2; i<=num; i++) {
                BigInteger keepNum = N_1Num;
                N_1Num = N_1Num.add(N_2Num);
                N_2Num = keepNum;
            }
            answer = N_1Num;
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
