package silver5;

import java.io.*;

public class 올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        String[] strArr = str.split(" ");
        int N = Integer.parseInt(strArr[0]);
        int C = Integer.parseInt(strArr[1]);
        int[][] country = new int[N][4];
        int S = 0;
        for (int i=0; i<N; i++){
            String numStr = bf.readLine();
            String[] numArr = numStr.split(" ");
            for (int j=0; j< numArr.length; j++){
                country[i][j] = Integer.parseInt(numArr[j]);
            }
            if (C==country[i][0]){
                S=i;
            }
        }
        int answer = 1;
        for (int i=0; i<N; i++){
            if (i==S){
                continue;
            }
            else {
                if (country[i][1]>country[S][1]){
                    answer++;
                }
                else if (country[i][1] == country[S][1]){
                    if (country[i][2]>country[S][2]){
                        answer++;
                    }
                    else if (country[i][2]==country[S][2]){
                        if (country[i][3]>country[S][3]){
                            answer++;
                        }
                    }
                    else {
                        continue;
                    }
                }
                else {
                    continue;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
