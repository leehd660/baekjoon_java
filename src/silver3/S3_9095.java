package silver3;

import java.io.*;

public class S3_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++){
            String findNumStr = bf.readLine();
            int findNum = Integer.parseInt(findNumStr);
            int count = 0;
            for (int threeNum=0; threeNum<=(findNum/3); threeNum++ ) {
                int modNum = findNum - (3*threeNum);
                for (int twoNum=0; twoNum <=(modNum/2); twoNum++) {
                    int oneNum = modNum - (2*twoNum);
                    int total = threeNum + twoNum + oneNum;
                    count += factorial(total) / (factorial(threeNum)*factorial(twoNum)*factorial(oneNum));
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }
        bw.close();
    }

    public static int factorial(int num) {
        int answer = 1;
        for (int i=1; i<=num; i++){
            answer = answer*i;
        }
        return answer;
    }
}
