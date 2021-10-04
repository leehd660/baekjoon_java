package silver5;

import java.io.*;

public class 덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int[][] answer = new int[num][3];
        for (int i=0; i<num; i++){
            String check = bf.readLine();
            String[] arr = check.split(" ");
            answer[i][0] = Integer.parseInt(arr[0]);
            answer[i][1] = Integer.parseInt(arr[1]);
            answer[i][2] = 1;
        }
        for (int i=0; i<num-1; i++){
            for (int j=i+1; j<num; j++){
                if (answer[i][0]>answer[j][0] && answer[i][1]>answer[j][1]){
                    answer[j][2]++;
                }
                else if (answer[i][0]<answer[j][0] && answer[i][1]<answer[j][1]){
                    answer[i][2]++;
                }
            }
        }
        for (int i=0;i<num;i++){
            bw.write(String.valueOf(answer[i][2])+" ");
        }
        bw.close();
    }
}
