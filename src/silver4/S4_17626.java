package silver4;

import java.io.*;

public class S4_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int[] table = new int[223];
        for (int i=1; i<=223; i++) {
            table[i-1] = (int)Math.pow(i,2);
        }
        int nRoot = (int)Math.sqrt(num);

    }
}
