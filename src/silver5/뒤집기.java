package silver5;

import java.io.*;

public class 뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        String[] strArr = str.split("");
        int count0 = 0;
        int count1 = 0;
        for (int i=0; i<str.length(); i++){
            if (i==0){
                if (strArr[i].equals("0")){
                    count1++;
                }
                else{
                    count0++;
                }
            }
            else {
                if (strArr[i-1].equals("0") && strArr[i].equals("1")){
                    count0++;
                }
                else if (strArr[i-1].equals("1") && strArr[i].equals("0")) {
                    count1++;
                }
            }
        }
        int answer = Math.min(count0,count1);
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
