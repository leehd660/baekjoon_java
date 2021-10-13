package silver5;

import java.io.*;

public class 색종이 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[][] paper = new boolean[100][100];
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++) {
            String xy = bf.readLine();
            String[] arr = xy.split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            for (int x=a; x<a+10; x++){
                for (int y=b; y<b+10; y++){
                    if (!paper[x][y]){
                        paper[x][y] = true;
                    }
                }
            }
        }
        int ansNum = 0;
        for (int i=0; i<100; i++){
            for (int j=0; j<100; j++){
                if (paper[i][j]){
                    ansNum++;
                }
            }
        }
        bw.write(String.valueOf(ansNum));
        bw.close();
    }
}
