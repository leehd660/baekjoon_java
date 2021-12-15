package silver5;

import java.io.*;

public class S5_11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++) {
            int answer = 0;
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            int first = Integer.parseInt(strArr[0]);
            int fin = Integer.parseInt(strArr[1]);
            for (int j=first; j<=fin; j++) {
                String word = String.valueOf(j);
                for (String s : word.split("")) {
                    if (s.equals("0")){
                        answer ++;
                    }
                }
            }
            bw.write(String.valueOf(answer));
            bw.write("\n");
        }
        bw.close();
    }
}
