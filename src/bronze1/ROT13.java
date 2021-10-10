package bronze1;

import java.io.*;

public class ROT13 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        String[] strArr = str.split("");
        String answer = "";
        for (String s : strArr){
            int num = s.charAt(0);
            if (65<=num && num<=90){
                if (num+13 > 90){
                    num = 64 + ((num+13)%90);
                }
                else {
                    num = num + 13;
                }
            }
            else if (97<=num && num<=122){
                if (num+13 > 122){
                    num = 96 + ((num+13)%122);
                }
                else {
                    num = num + 13;
                }
            }
            answer += (char)num;
        }
        bw.write(answer);
        bw.close();
    }
}
