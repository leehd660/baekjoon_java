package bronze1;

import java.io.*;

public class 누울자리를찾아라 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        String[][] room = new String[num][num];
        for (int i=0; i<num; i++){
            room[i] = bf.readLine().split("");
        }
        int xCount = 0;
        int yCount = 0;
        for (int i=0; i<num; i++){
            int xLen = 0;
            for (int j=0; j<num; j++){
                if (room[i][j].equals("X")){
                    if (xLen>=2){
                        xCount++;
                    }
                    xLen=0;
                }
                else{
                    xLen++;
                }
                if (j==num-1){
                    if (xLen>=2){
                        xCount++;
                    }
                }
            }
        }
        for (int i=0; i<num; i++){
            int yLen = 0;
            for (int j=0; j<num; j++){
                if (room[j][i].equals("X")){
                    if (yLen>=2){
                        yCount++;
                    }
                    yLen=0;
                }
                else{
                    yLen++;
                }
                if (j==num-1){
                    if (yLen>=2){
                        yCount++;
                    }
                }
            }
        }
        bw.write(String.valueOf(xCount)+" "+String.valueOf(yCount));
        bw.close();
    }
}
