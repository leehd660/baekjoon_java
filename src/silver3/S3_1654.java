package silver3;

import java.io.*;

public class S3_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String KNstr = bf.readLine();
        String[] KNarr = KNstr.split(" ");
        int K = Integer.parseInt(KNarr[0]);
        int N = Integer.parseInt(KNarr[1]);
        int[] arr = new int[K];
        long total = 0;
        for (int i=0; i<K; i++) {
            int k = Integer.parseInt(bf.readLine());
            arr[i] = k;
            total += k;
        }
        long maxNum = (total/N)*2;
        long minNum = 0;
        long mid = total/N;
        while (minNum<=maxNum) {
            int number = 0;
            for (int i=0; i<K; i++) {
                number += arr[i]/mid;
            }
            if (number >= N) {
                minNum = mid+1;
            }
//            else if (number == N) {
//                break;
//            }
            else {
                maxNum = mid-1;
            }
            mid = (maxNum+minNum)/2;
        }
        bw.write(String.valueOf(mid));
        bw.close();
    }
}
