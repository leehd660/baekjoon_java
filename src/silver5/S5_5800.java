package silver5;

import java.io.*;
import java.util.Arrays;

public class S5_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String classNumStr = bf.readLine();
        int classNum = Integer.parseInt(classNumStr);
        for (int i=1; i<classNum+1; i++) {
            bw.write("Class "+ String.valueOf(i) + "\n");
            String classInfo = bf.readLine();
            String[] classInfoArr = classInfo.split(" ");
            int[] scoreArr = new int[Integer.parseInt(classInfoArr[0])];
            for (int j=1; j<classInfoArr.length; j++){
                scoreArr[j-1] = Integer.parseInt(classInfoArr[j]);
            }
            Arrays.sort(scoreArr);
            bw.write("Max " + String.valueOf(scoreArr[scoreArr.length-1] + ", Min " + String.valueOf(scoreArr[0]) +", "));
            int maxBetween = 0;
            for (int j=1; j<scoreArr.length; j++){
                if (maxBetween < (scoreArr[j]-scoreArr[j-1]) ){
                    maxBetween = scoreArr[j]-scoreArr[j-1];
                }
            }
            bw.write("Largest gap " +String.valueOf(maxBetween));
            bw.write("\n");
        }
        bw.close();
    }
}
