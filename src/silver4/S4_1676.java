package silver4;

import java.io.*;

public class S4_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int countTwo = 0;
        int countFive = 0;

        for (int i=1; i<=num; i++) {
            int test1 = i;
            int test2 = i;
            while (test1%2 == 0) {
                countTwo++;
                test1 = test1/2;
            }
            while (test2%5 == 0) {
                countFive++;
                test2 = test2/5;
            }
        }

        int answer = Math.min(countTwo,countFive);
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
