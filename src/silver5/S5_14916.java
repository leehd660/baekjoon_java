package silver5;

import java.io.*;

public class S5_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int y = num/5;
        int totalNum = num;
        for (int i=y; i>=0; i--) {
            int modMoney = num-5*i;
            if (modMoney%2 == 0) {
                int j = modMoney/2;
                if (totalNum>i+j) {
                    totalNum = i+j;
                }
            }
        }
        if (totalNum == num) {
            totalNum = -1;
        }
        bw.write(String.valueOf(totalNum));
        bw.close();
    }
}
