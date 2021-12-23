package silver4;

import java.io.*;

public class S4_2670 {
//    이거 시간 초과 발생
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int arrSize = Integer.parseInt(bf.readLine());
//        double[] arr = new double[arrSize];
//        for (int i=0; i<arrSize; i++) {
//            arr[i] = Double.parseDouble(bf.readLine());
//        }
//        double max = 0;
//        for (int i=1; i<=arr.length-1; i++) {
//            for (int j=0; j<=arr.length-1-i; j++) {
//                double  compareNum = 1;
//                for (int k=j; k<=j+i; k++) {
//                    compareNum *= arr[k];
//                }
//                if (compareNum>max) max = compareNum;
//            }
//        }
//        max = Math.round(max*1000)/1000.0;
//        bw.write(String.valueOf(max));
//        bw.close();
//    }

    //DP로 풀어보기 - DP로 풀면 연속된 숫자인지 알 수가 없는데..?
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int arrSize = Integer.parseInt(bf.readLine());
        double[] arr = new double[arrSize];
        double answer = 0;
        for (int i=0; i<arrSize; i++) {
            arr[i] = Double.parseDouble(bf.readLine());
            if (arr[i]>answer){
                answer = arr[i];
            }
        }
        double[] DPtable = new double[arrSize];
        for (int i=0; i<arrSize; i++) {
            if (i==0) {
                DPtable[i] = arr[i];
            }
            else {
                DPtable[i] = Math.max(arr[i], DPtable[i-1]*arr[i]);
            }

            if (DPtable[i]>answer){
                answer = DPtable[i];
            }
        }
        bw.write(String.format("%.3f",answer));
        bw.close();
    }
}
