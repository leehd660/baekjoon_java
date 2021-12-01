package silver4;

import java.io.*;

public class S4_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int[] table = new int[num];
        for (int i=0; i<num; i++) {
            String score = bf.readLine();
            table[i] = Integer.parseInt(score);
        }
        int answer = 0;
        for (int i=num-2; i>=0; i--) {
            if (table[i] < table[i+1]) {
                continue;
            }
            else {
                answer += table[i] - (table[i+1]-1);
                table[i] = table[i+1]-1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
