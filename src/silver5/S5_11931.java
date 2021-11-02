package silver5;

import java.io.*;
import java.util.Arrays;

public class S5_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nStr = bf.readLine();
        int n = Integer.parseInt(nStr);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            String str = bf.readLine();
            int num = Integer.parseInt(str);
            arr[i] = num;
        }
        Arrays.sort(arr);
        for (int i=0; i<n; i++){
            bw.write(String.valueOf(arr[n-1-i]));
            bw.write("\n");
        }
        bw.close();
    }
}