package silver5;

import java.io.*;

public class 날짜계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        String[] numArr = numStr.split(" ");
        int e = Integer.parseInt(numArr[0]);
        int s = Integer.parseInt(numArr[1]);
        int m = Integer.parseInt(numArr[2]);

        int i=0;
        int answer = 0;
        while (true) {
            int year = 28*i +s;
            if (year%15 == e%15 && year%19==m%19){
                answer = year;
                break;
            }
            else{
                i++;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
