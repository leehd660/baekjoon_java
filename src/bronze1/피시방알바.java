package bronze1;

import java.io.*;

public class 피시방알바 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String nStr = bf.readLine();
        int n = Integer.parseInt(nStr);
        String numStr = bf.readLine();
        String[] numArr = numStr.split(" ");
        boolean[] computer = new boolean[100];
        int count = 0;
        for (int i=0; i<n; i++){
            int a = Integer.parseInt(numArr[i]);
            if (computer[a-1]){
                count++;
            }
            else{
                computer[a-1] = true;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
