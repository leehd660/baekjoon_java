package silver5;

import java.io.*;
import java.util.Arrays;

public class S5_9237 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        String treeStr = bf.readLine();
        String[] treeStrArr = treeStr.split(" ");
        int[] treeArr = new int[num];
        for (int i=0; i<num; i++) {
            treeArr[i] = Integer.parseInt(treeStrArr[i]);
        }
        int lastDay = 1;
        Arrays.sort(treeArr);
        for (int i=0; i<num; i++) {
            int compareDay = (i+1)+treeArr[num-1-i];
            if (lastDay < compareDay) {
                lastDay = compareDay;
            }
        }
        int answer = lastDay + 1;
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
