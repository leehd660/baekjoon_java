package silver5;

import java.io.*;

public class 최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        String[] numArr = str.split(" ");
        int a = Integer.parseInt(numArr[0]);
        int b = Integer.parseInt(numArr[1]);
        int big = Math.max(a,b);
        int small = Math.min(a,b);
        int answer1 =0;
        int answer2 =0;
        for (int i=1; i<=small; i++){
            int j = 0;
            if (small%i == 0){
                j = small/i;
                if (big%j==0){
                    answer1 = j;
                    break;
                }
            }
            else{
                continue;
            }
        }
        int k = big;
        while(true) {
            if (k%small==0){
                answer2=k;
                break;
            }
            else {
                k = k+big;
            }
        }
        bw.write(String.valueOf(answer1) + '\n');
        bw.write(String.valueOf(answer2));
        bw.close();
    }
}
