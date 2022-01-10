package silver2;

import java.io.*;

public class S2_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NKstr = bf.readLine();
        String[] NKarr = NKstr.split(" ");
        int N = Integer.parseInt(NKarr[0]);
        int K = Integer.parseInt(NKarr[1]);
        int[] coinValue = new int[N];
        for (int i=0; i<N; i++) {
            coinValue[i] = Integer.valueOf(bf.readLine());
        }
        int count = 0;
        int index = N-1;
        while (K!=0) {
            if (K>=coinValue[index]) {
                K -= coinValue[index];
                count++;
            }
            else {
                index--;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
