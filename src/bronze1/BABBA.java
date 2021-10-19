package bronze1;

import java.io.*;

public class BABBA {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = 1;
        int b = 0;
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++){
            int j=a;
            a=b;
            b=j+b;
        }
        bw.write(String.valueOf(a) + " " + String.valueOf(b));
        bw.close();
    }
}
