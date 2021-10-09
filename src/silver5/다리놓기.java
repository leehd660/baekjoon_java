package silver5;

import java.io.*;
import java.math.BigInteger;

public class 다리놓기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);

        for (int i=0; i<num; i++){
            String numLine = bf.readLine();
            String[] arr = numLine.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            BigInteger aFact = BigInteger.valueOf(1);
            BigInteger baFact = BigInteger.valueOf(1);
            long abFact = 1;
            for (int j=b; j>b-a; j--){
                baFact = baFact.multiply(BigInteger.valueOf(j));
            }
            for (int j=a; j>1; j--){
                aFact = aFact.multiply(BigInteger.valueOf(j));
            }
            for (int j=b-a; j>1; j--){
                abFact = abFact*j;
            }
            BigInteger answer = baFact.divide(aFact);
            bw.write(String.valueOf(answer) + '\n');
        }
        bw.close();
    }
}
