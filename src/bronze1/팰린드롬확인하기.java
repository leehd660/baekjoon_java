package bronze1;

import java.io.*;

public class 팰린드롬확인하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        int answer = 1;
        int a = str.length();
        for (int i=0; i<Math.floor(a/2); i++){
            if (str.substring(i,i+1).equals(str.substring(a-1-i,a-i))){
                continue;
            }
            else {
                answer = 0;
                break;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
