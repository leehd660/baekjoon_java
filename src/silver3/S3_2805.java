package silver3;

import java.io.*;
import java.util.Arrays;

public class S3_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NMstr = bf.readLine();
        String[] NMarr = NMstr.split(" ");
        int N = Integer.parseInt(NMarr[0]);
        int M = Integer.parseInt(NMarr[1]);
        String treeStr = bf.readLine();
        String[] treeStrArr = treeStr.split(" ");
        int[] treeArr = new int[N];
        for (int i=0; i<treeStrArr.length; i++) {
            treeArr[i] = Integer.parseInt(treeStrArr[i]);
        }
        Arrays.sort(treeArr);
        int index = treeArr.length-1;
        long high = treeArr[index];
        long beforeTotal = 0;
        long answer = 0;
        while (true) {
            long total = 0;
            for (int i= treeArr.length-1; i>=0; i--) {
                if (treeArr[i] > high) {
                    total += treeArr[i]-high;
                }
                else {
                    break;
                }
            }
            if (total < M && beforeTotal > M) {
                answer = high+1;
                break;
            }
            else if (total == M) {
                answer = high;
                break;
            }
            else {
                high--;
                beforeTotal = total;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

}
