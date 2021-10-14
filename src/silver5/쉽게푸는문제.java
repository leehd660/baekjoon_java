package silver5;

import java.io.*;

public class 쉽게푸는문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        String[] numArr = numStr.split(" ");
        int a = Integer.parseInt(numArr[0]);
        int b = Integer.parseInt(numArr[1]);
        int[] table = new int[1000];
        int answer = 0;
        boolean test = false;
        int n = 1;
        for (int i=0; i<1000;) {
            for (int j=0; j<n; j++) {
                table[i] = n;
                if (i>=a-1 && i<=b-1) {
                    answer += table[i];
                }
                if (i>=b-1){
                    test = true;
                    break;
                }
                i++;
            }
            n++;
            if (test){
                break;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
