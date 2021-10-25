package silver4;

import java.io.*;

public class S4_1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        String strNum = bf.readLine();
        if (strNum.length()<3){
            answer = Integer.parseInt(strNum);
        }
        else {
            answer += 99;
            if (strNum.length()==4){
                strNum = "999";
            }
            for (int i=111; i<=Integer.parseInt(strNum); i++) {
                int n1 = i%10;
                int n2 = (i/10)%10;
                int n3 = i/100;
                if ((n3-n2 == n2-n1)){
                    answer++;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
