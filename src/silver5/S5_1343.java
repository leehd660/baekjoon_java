package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S5_1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String board = bf.readLine();
        List<String> boardArr = new ArrayList<>();
        String word = "";
        String[] arr = board.split("");
        for (int i=0; i<arr.length; i++){
//            if (arr[i].equals("X")){
//                word += "X";
//                if (i == arr.length-1){
//                    boardArr.add(word);
//                }
//            }
//            else {
//                boardArr.add(word);
//                word="";
//            }
            if (i==0){
                word += arr[i];
                if (i == arr.length-1){
                    boardArr.add(word);
                }
            }
            else if (arr[i-1].equals(arr[i])){
                word += arr[i];
                if (i == arr.length-1){
                    boardArr.add(word);
                }
            }
            else {
                boardArr.add(word);
                word = arr[i];
                if (i == arr.length-1){
                    boardArr.add(word);
                }
            }
        }
        String answer = "";
//        for (String s : boardArr){
//            bw.write(s+"\n");
//        }
        for (int j=0; j<boardArr.size(); j++){
            String b = boardArr.get(j);
            if (b.contains("X")) {
                if (b.length() % 2 != 0) {
                    answer = "-1";
                    break;
                } else {
                    int len = b.length();
                    int aNum = len / 4;
                    int bNum = (len - 4 * aNum) / 2;
                    for (int i = 0; i < aNum; i++) {
                        answer += "AAAA";
                    }
                    for (int i = 0; i < bNum; i++) {
                        answer += "BB";
                    }
                }
            }
            else {
                answer += b;
            }
        }
        bw.write(answer);
        bw.close();
    }
}
