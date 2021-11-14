package silver4;

import java.io.*;

public class S4_3085 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        String[][] table = new String[num][num];
        for (int i=0; i<num; i++) {
            String line = bf.readLine();
            table[i] = line.split("");
        }
        int answer = 0;
        for (int i=0; i< table.length; i++) {
            //i는 행
            for (int j=0; j<table.length-1; j++){
                String keep = table[i][j];
                table[i][j] = table[i][j+1];
                table[i][j+1] = keep;
                int n = check(table);
                if (answer < n){
                    answer = n;
                }
                table[i][j+1] = table[i][j];
                table[i][j] = keep;
            }
        }
        for (int j=0; j< table.length; j++) {
            for (int i=0; i<table.length-1; i++){
                String keep = table[i][j];
                table[i][j] = table[i+1][j];
                table[i+1][j] = keep;
                int n = check(table);
                if (answer < n){
                    answer = n;
                }
                table[i+1][j] = table[i][j];
                table[i][j] = keep;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }

    static int check(String[][] arr) {
        int answer =0;
        for (int i=0; i< arr.length; i++) {
            int count = 1;
            String before = "";
            String now = "";
            for (int j=0; j<arr.length; j++) {
                now = arr[i][j];
                if (now.equals(before)) {
                    count ++;
                }
                else {
                    if (answer < count) {
                        answer = count;
                    }
                    count=1;
                }
                if (j == arr.length-1) {
                    if (answer < count) {
                        answer = count;
                    }
                }
                before = arr[i][j];
            }
        }
        for (int i=0; i< arr.length; i++) {
            int count = 1;
            String before = "";
            String now = "";
            for (int j=0; j<arr.length; j++) {
                now = arr[j][i];
                if (now.equals(before)) {
                    count ++;
                }
                else {
                    if (answer < count) {
                        answer = count;
                    }
                    count=1;
                }
                if (j == arr.length-1) {
                    if (answer < count) {
                        answer = count;
                    }
                }
                before = arr[j][i];
            }
        }
        return answer;
    }
}
