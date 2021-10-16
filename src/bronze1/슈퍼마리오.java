package bronze1;

import java.io.*;

public class 슈퍼마리오 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int before =0;
        int after =0;
        int answer = 0;
        int[] arr = new int[10];
        for (int i=0; i<10; i++){
            String numStr = bf.readLine();
            int num = Integer.parseInt(numStr);
            if (i==0){
                arr[i] = num;
            }
            else{
                arr[i] = num+arr[i-1];
            }
        }
        for (int i=1; i<10; i++){
            after = arr[i];
            before = arr[i-1];
            if (after>=100){
                if ((after-100)>(100-before)){
                    answer = before;
                }
                else {
                    answer = after;
                }
                break;
            }
        }
        if (answer == 0){
            answer = arr[9];
        }
//        while (true) {
//            String numStr = bf.readLine();
//            int num = Integer.parseInt(numStr);
//            after = num + before;
//            if (after>=100){
//                if ((after-100)>(100-before)){
//                    answer = before;
//                }
//                else {
//                    answer = after;
//                }
//                break;
//            }
//            else {
//                before = after;
//                continue;
//            }
//        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
