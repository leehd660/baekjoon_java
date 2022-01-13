package silver2;

import java.io.*;

public class S2_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String MNstr = bf.readLine();
        String[] MNarr = MNstr.split(" ");
        int M = Integer.parseInt(MNarr[0]);
        int N = Integer.parseInt(MNarr[1]);
        boolean[] table = new boolean[N+1];
        table[0] = true;
        table[1] = true;
        for (int i=0; i<=N; i++) {
            if (table[i]) {
                continue;
            }
            else {
                int j=2;
                while (true) {
                    if (i*j<=N) {
                        table[i*j] = true;
                        j++;
                    }
                    else {
                        break;
                    }
                }
                if (i>=M) {
                    bw.write(String.valueOf(i) + "\n");
                }
            }
        }
        bw.close();
    }
}
