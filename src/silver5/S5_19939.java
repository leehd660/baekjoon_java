package silver5;

import java.io.*;

public class S5_19939 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        String[] strArr = str.split(" ");
        int N = Integer.parseInt(strArr[0]);
        int K = Integer.parseInt(strArr[1]);
        double a = N/(double)K;
        if (a-(K/2) > 0) {
//            if (K%2 == 1) {
//                if (a%(double)(int)a != 0) {
//                    bw.write(String.valueOf(K));
//                }
//                else {
//                    bw.write(String.valueOf(K-1));
//                }
//            }
//            else {
//                if (a%(double)(int)a != 0) {
//                    bw.write(String.valueOf(K-1));
//                }
//                else {
//                    bw.write(String.valueOf(K));
//                }
//            }
            if (N%2 == 0) {
                if (K%2==0) {
                    bw.write(String.valueOf(K));
                }
                else {
                    bw.write(String.valueOf(K-1));
                }
            }
            else {
                if (K%2==0) {

                }
                else {

                }
            }
        }
        else {
            bw.write("-1");
        }
        bw.close();
    }
}
