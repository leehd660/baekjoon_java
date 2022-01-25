package silver1;

import java.io.*;

public class S1_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[][] table = new int[n][10];
        for (int i=1; i<10; i++) {
            table[0][i] = 1;
        }
        for (int i=1; i<n; i++) {
            table[i][0] = table[i-1][1]%1000000000;
            for (int j=1; j<9; j++) {
                table[i][j] = table[i-1][j-1]%1000000000 + table[i-1][j+1]%1000000000;
            }
            table[i][9] = table[i-1][8]%1000000000;
        }
        int answer = 0;
        for (int i=0; i<10; i++) {
            answer += table[n-1][i]%1000000000;
            answer = answer%1000000000;
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
