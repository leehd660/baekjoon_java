package silver5;

import java.io.*;

public class S5_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        String[] numArr = numStr.split(" ");
        int rowNum = Integer.parseInt(numArr[0]);
        int colNum = Integer.parseInt(numArr[1]);
        String[][] table = new String[rowNum][colNum];
        for (int i=0; i<rowNum; i++) {
            table[i] = bf.readLine().split("");
        }
        String answer = "";
        int answerNum = 0;
        for (int i=0; i<colNum; i++) {
            String[] answerArr = test(i, table).split(" ");
            answer += answerArr[0];
            answerNum += Integer.parseInt(answerArr[1]);
        }
        bw.write(answer);
        bw.write("\n");
        bw.write(String.valueOf(answerNum));
        bw.close();
    }

    static String test (int i, String[][] arr) {
        int countA = 0;
        int countT = 0;
        int countG = 0;
        int countC = 0;
        for (int j=0; j< arr.length; j++) {
            if (arr[j][i].equals("A")){
                countA++;
            }
            else if (arr[j][i].equals("T")) {
                countT++;
            }
            else if (arr[j][i].equals("G")) {
                countG++;
            }
            else {
                countC++;
            }
        }
        int maxNum = Math.max( Math.max(countA, countT), Math.max(countG, countC) );
        String answer = "";
        if (countA == maxNum) {
            answer = "A";
        }
        else if (countC == maxNum){
            answer = "C";
        }
        else if (countG == maxNum){
            answer = "G";
        }
        else if (countT == maxNum){
            answer = "T";
        }
        int answer2 = arr.length-maxNum;
        answer += " "+String.valueOf(answer2);
        return answer;
    }
}