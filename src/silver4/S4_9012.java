package silver4;

import java.io.*;

public class S4_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++) {
            String answer = "NO";
            String vps = bf.readLine();
            String[] arr = vps.split("");
            int countOpen = 0;
            int countClose = 0;
            for (String s : arr) {
                if (s.equals("(")){
                    countOpen++;
                }
                else {
                    countClose++;
                }
                if (countOpen<countClose){
                    break;
                }
            }
            if (countOpen==countClose){
                answer = "YES";
            }
            bw.write(answer);
            bw.write("\n");
        }
        bw.close();
    }
}
