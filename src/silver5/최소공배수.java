package silver5;

import java.io.*;

public class 최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++){
            String lineNum = bf.readLine();
            String[] arr = lineNum.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int j=1;
            while (true) {
                int test = j*Math.max(a,b);
                if (test%Math.min(a,b)==0){
                    bw.write(String.valueOf(test) + '\n');
                    break;
                }
                else{
                    j++;
                    continue;
                }

            }
        }
        bw.close();
    }
}
