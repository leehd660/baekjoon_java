package silver5;

import java.io.*;
import java.util.Arrays;

public class S5_16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N_LStr = bf.readLine();
        String[] strArr = N_LStr.split(" ");
        int N = Integer.parseInt(strArr[0]);
        int L = Integer.parseInt(strArr[1]);
        String hStr = bf.readLine();
        String[] hStrArr = hStr.split(" ");
        int[] hArr = new int[N];
        for (int i=0; i<N; i++) {
            hArr[i] = Integer.parseInt(hStrArr[i]);
        }
        Arrays.sort(hArr);
        for (int i=0; i<N; i++) {
            if (hArr[i] <= L) {
                L ++;
            }
            else {
                break;
            }
        }
        bw.write(String.valueOf(L));
        bw.close();
    }
}
