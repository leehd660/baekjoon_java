package silver5;

import java.io.*;

public class S5_2947 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        String[] strArr = str.split(" ");
        int[] numArr = new int[strArr.length];
        for (int i=0; i< numArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        while (true) {
            for (int i=0; i<numArr.length-1; i++) {
                int j=i+1;
                if (numArr[i]>numArr[j]){
                    int k = numArr[j];
                    numArr[j] = numArr[i];
                    numArr[i] = k;
                    for (int n:numArr){
                        bw.write(String.valueOf(n));
                        bw.write(" ");
                    }
                    bw.write("\n");
                }
            }
            if (numArr[0]<numArr[1] && numArr[1]<numArr[2] && numArr[2]<numArr[3] && numArr[3]<numArr[4]) {
                break;
            }
        }
        bw.close();
    }
}
