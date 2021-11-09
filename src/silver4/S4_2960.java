package silver4;

import java.io.*;

public class S4_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        String[] numArr = numStr.split(" ");
        int answer = 0;
        int N = Integer.parseInt(numArr[0]);
        int K = Integer.parseInt(numArr[1]);
        int[] list = new int[N-1];
        for (int i=2; i<=N; i++) {
            list[i-2] = i;
        }
        int count =0;
        for (int i=0; i<list.length; i++) {
            int testNum = list[i];
            if (list[i] == 0){
                continue;
            }
            else {
                for (int j = i; j<list.length; j++) {
                    if (list[j]%testNum == 0 && list[j] !=0) {
                        count ++;
                        if (count == K){
                            answer = list[j];
                            break;
                        }
                        list[j] = 0;
                    }
                }
            }
            if (answer != 0){
                break;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
