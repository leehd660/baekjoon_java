package bronze1;

import java.io.*;
import java.util.Locale;

public class 진법변환2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        String[] numArr = numStr.split(" ");
        long a = Long.parseLong(numArr[0]);
        int b = Integer.parseInt(numArr[1]);
        String answer = Long.toString(a,b).toUpperCase(Locale.ROOT);
        bw.write(answer);
        bw.close();
    }
}
