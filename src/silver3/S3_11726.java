package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_11726 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String numStr = bf.readLine();
//        int num = Integer.parseInt(numStr);
//        int maxTwo = num/2;
//        long answer =1;
//        for (int i=1; i<=maxTwo; i++){
//            int oneNum = num-(i*2);
//            int totalNum = oneNum+i;
//
//        }
//        answer = answer%10007;
//
//        bw.write(String.valueOf(answer));
//        bw.close();
//    }
//
//    static int calcul(int num) {
//        int answer = 1;
//        if (num == 1){
//            return answer;
//        }
//        return answer;
//    }

//    static double combination(int num1, int num2) {
//        double answer = 1;
////        for (int i=1; i<=n; i++) {
////            answer = (answer*i%10007);
////        }
//        for (int i=0; i< num1; i++){
//            answer = (answer%10007) * (((num1+num2-i)/(double)(num1-i))%10007);
//        }
//        return answer;
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        List<Integer> dp = new ArrayList<>();
        for (int i=0; i<num; i++) {
            if (i == 0) {
                dp.add(1);
            }
            else if (i == 1) {
                dp.add(2);
            }
            else {
                int n = dp.get(i-2)+dp.get(i-1);
                if (n >= 10007) {
                    n = n%10007;
                }
                dp.add(n);
            }
        }
        bw.write(String.valueOf(dp.get(num-1)));
        bw.close();
    }
}
