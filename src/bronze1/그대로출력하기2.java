package bronze1;

import java.io.*;

public class 그대로출력하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true){
            String s = bf.readLine();
            if (s == null){
                break;
            }
            bw.write(s+'\n');
        }
        bw.close();
    }
}
