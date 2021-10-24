package silver5;

import java.io.*;

public class S5_2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] table = new String[5][5];
        for (int i=0; i<5; i++){
            String str = bf.readLine();
            table[i] = str.split(" ");
        }

        String[][] check = new String[5][5];
        for (int i=0; i<5; i++){
            String str = bf.readLine();
            check[i] = str.split(" ");
        }

        int count = 0;
        boolean answer = false;
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
//                count++;
                for (int k=0; k<5; k++) {
                    for (int r=0; r<5; r++) {
                        if (table[k][r].equals(check[i][j])) {
                            table[k][r] = "0";
                            count++;
                        }
                    }
                }
                if(bingo(table)==3) {
                    bw.write(String.valueOf(count));
                    answer = true;
                    break;
                }
            }
            if (answer){
                break;
            }
        }
        bw.close();
    }

    static int bingo (String[][] arr) {
        int answer = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (arr[i][j].equals("0")){
                    count1 ++;
                }
                if (count1==5){
                    answer++;
                }
                if (arr[j][i].equals("0")){
                    count2 ++;
                }
                if (count2==5){
                    answer++;
                }
            }
            count1 = 0;
            count2 = 0;
            if (arr[i][i].equals("0")){
                count3++;
            }
            if (arr[4-i][i].equals("0")){
                count4++;
            }
        }
        if (count3==5){
            answer++;
        }
        if (count4==5){
            answer++;
        }
        return answer;
    }
}
