package silver3;

import java.io.*;

public class S3_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int maxTwo = num/2;
        long answer =1;
        for (int i=1; i<=maxTwo; i++){
            int oneNum = num-(i*2);
            int totalNum = oneNum+i;

        }
        answer = answer%10007;

        bw.write(String.valueOf(answer));
        bw.close();
    }

    static int calcul(int num) {
        int answer = 1;
        if (num == 1){
            return answer;
        }
        return answer;
    }

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
}
