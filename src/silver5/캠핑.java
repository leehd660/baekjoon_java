package silver5;

import java.io.*;

public class 캠핑 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count =1;
        while (true) {
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            int L = Integer.parseInt(strArr[0]);
            int P = Integer.parseInt(strArr[1]);
            int V = Integer.parseInt(strArr[2]);
            if (L==0 && P==0 && V==0){
                break;
            }
            else {
                int a = 0;
                if ((V%P)<L){
                    a = V%P;
                }
                else {
                    a = L;
                }
                int answer = (V/P)*L + a;
                bw.write("Case " + count + ": " + String.valueOf(answer) +'\n');
            }
            count++;
        }
        bw.close();
    }
}
