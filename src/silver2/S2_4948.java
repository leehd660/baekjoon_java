package silver2;

import java.io.*;

public class S2_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            int n = Integer.parseInt(bf.readLine());
            if (n ==0) {
                break;
            }
            else {
                boolean[] table = new boolean[2*n+1];
                int count = 0;
                table[1] = true;
                for (int i=1; i<2*n+1; i++) {
                    if (table[i]) continue;
                    else {
                        int multiNum = 2;
                        while(multiNum*i < 2*n+1) {
                            table[multiNum*i] = true;
                            multiNum++;
                        }
                        if (i>n && i<=2*n) {
                            count++;
                        }
                    }
                }
                bw.write(String.valueOf(count+"\n"));
            }
        }
        bw.close();
    }
}
