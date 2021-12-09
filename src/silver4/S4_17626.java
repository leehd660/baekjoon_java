package silver4;

import java.io.*;

public class S4_17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int[] numArr = new int[num+1];
        numArr[0] = 0;
        numArr[1] = 1;
        int nowNum = 1;
        while (nowNum<=num) {
            if (Math.pow((int)Math.sqrt(nowNum),2) == nowNum) {
                numArr[nowNum] = 1;
            }
            else {
                int min = Integer.MAX_VALUE;
                for (int i=1; i<=(int)Math.sqrt(nowNum); i++){
                    min = Math.min(numArr[(int)Math.pow(i,2)] + numArr[nowNum-(int)Math.pow(i,2)], min);
                }
                numArr[nowNum] = min;
            }
            nowNum++;
        }
        bw.write(String.valueOf(numArr[num]));
        bw.close();


//        int[] table = new int[223];
//        for (int i=1; i<=223; i++) {
//            table[i-1] = (int)Math.pow(i,2);
//        }
//        int nRoot = (int)Math.sqrt(num);


//        int nowNum = 1;
//        int nowN = 0;
//        int beforeNum = 1;
//        int beforeN = 0;
//        while (nowNum < num) {
//            int root = (int)Math.sqrt(nowNum);
//            if (Math.pow(root,2) == nowNum) {
//                nowN = 1;
//            }
//            else {
//                nowN = beforeN
//            }
//            nowNum++;
//        }
    }
}
