package silver5;

import java.io.*;

public class S5_2303 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String personStr = bf.readLine();
        int personNum = Integer.parseInt(personStr);
        int[] count = new int[personNum];
        int maxPerson = 0;
        int maxPersonNum = 0;
        for (int i=0; i<personNum; i++) {
            int maxNum = 0;
            String cardDeckStr = bf.readLine();
            String[] cardDeckArr = cardDeckStr.split(" ");
            for (int a=0; a< cardDeckArr.length; a++) {
                for (int b=a+1; b< cardDeckArr.length; b++) {
                    for (int c=b+1; c< cardDeckArr.length; c++) {
                        int sum = Integer.parseInt(cardDeckArr[a]) +
                                Integer.parseInt(cardDeckArr[b]) + Integer.parseInt(cardDeckArr[c]);
                        int gameNum = sum%10;
                        if (maxNum <= gameNum){
                            maxNum = gameNum;
                        }
                    }
                }
            }
            count[i] = maxNum;
            if (maxPersonNum <= maxNum) {
                maxPerson = i+1;
                maxPersonNum = maxNum;
            }
            else {
                continue;
            }
        }
        bw.write(String.valueOf(maxPerson));
        bw.close();
    }
}
