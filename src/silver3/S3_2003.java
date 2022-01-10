package silver3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S3_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NMstr = bf.readLine();
        String[] NMarr = NMstr.split(" ");
        int N = Integer.parseInt(NMarr[0]);
        int M = Integer.parseInt(NMarr[1]);
        String arrStr = bf.readLine();
        String[] strArr = arrStr.split(" ");
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int totalNum = 0;
        int count = 0;
        for (int i=0; i<N; i++) {
            deque.addLast(arr[i]);
            totalNum += arr[i];
            if (totalNum == M) {
                count++;
                totalNum -= deque.pollFirst();
            }
            else if (totalNum > M) {
                while (totalNum > M) {
                    totalNum -= deque.pollFirst();
                    if (totalNum == M) {
                        count++;
                        totalNum -= deque.pollFirst();
                    }
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
