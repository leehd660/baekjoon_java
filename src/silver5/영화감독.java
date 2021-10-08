package silver5;

import java.io.*;

public class 영화감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int count = 0;
        int i = 666;
        while (true){
            String test = String.valueOf(i);
            if (test.contains("666")){
                count ++;
            }
            if (count == num){
                bw.write(test);
                bw.close();
                break;
            }
            i++;
        }
    }
}
