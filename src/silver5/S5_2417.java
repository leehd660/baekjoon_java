package silver5;

import java.io.*;
import java.math.BigInteger;

public class S5_2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        long numLong = Long.parseLong(numStr);
        BigInteger num = BigInteger.valueOf(1);
        BigInteger answer = BigInteger.ONE;
        while (true) {
            if (num.multiply(num).compareTo(BigInteger.valueOf(numLong)) > 0) {
                answer = num;
                break;
            }
            else {
                num = num.add(BigInteger.ONE);
            }
        }
        bw.write(answer.toString());
        bw.close();
    }
}
