package silver5;

import java.io.*;

public class 돌게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        int num = Integer.parseInt(str);
        if (num%2==0){
            bw.write("SK");
        }
        else {
            bw.write("CY");
        }
        bw.close();
    }
}
