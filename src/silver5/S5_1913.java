package silver5;

import java.io.*;

public class S5_1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int f_num = num;
        int n = 4*(num/2)+1;
        int[] sequeArr = new int[n];
        sequeArr[0] = num;
        num--;
        for (int i=1; i<n; i++){
            if (i%2==0){
                sequeArr[i] = num;
                num--;
            }
            else{
                sequeArr[i] = num;
            }
        }
        int[][] table = new int[f_num][f_num];
        int startNum = (int)Math.pow(f_num,2);
        int a=0;
        int b=0;
        for (int i=0; i< sequeArr.length; i++) {
            int check = i%4;
            if (check==0){
                //a가 1씩 증가
                for (int j=0; j<sequeArr[i]; j++){
                    table[a][b] = startNum;
                    startNum--;
                    a++;
                }
                a--;
                b++;
            }
            else if (check==1) {
                //b가 1씩 증가
                for (int j=0; j<sequeArr[i]; j++){
                    table[a][b] = startNum;
                    startNum--;
                    b++;
                }
                b--;
                a--;
            }
            else if (check==2) {
                //a가 1씩 감소
                for (int j=0; j<sequeArr[i]; j++){
                    table[a][b] = startNum;
                    startNum--;
                    a--;
                }
                a++;
                b--;
            }
            else if (check==3) {
                //b가 1씩 감소
                for (int j=0; j<sequeArr[i]; j++){
                    table[a][b] = startNum;
                    startNum--;
                    b--;
                }
                b++;
                a++;
            }
        }
        String findNumStr = bf.readLine();
        int findNum = Integer.parseInt(findNumStr);
        String answer2 = "";
        for (int i=0; i<f_num; i++){
            for (int j=0; j<f_num; j++){
                bw.write(String.valueOf(table[i][j]));
                bw.write(" ");
                if (table[i][j]==findNum){
                    answer2 = String.valueOf(i+1)+ " " +String.valueOf(j+1);
                }
            }
            bw.write("\n");
        }
        bw.write(answer2);
        bw.close();
    }
}
