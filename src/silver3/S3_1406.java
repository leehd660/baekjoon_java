package silver3;

import java.io.*;
import java.util.Stack;

public class S3_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> answerStack = new Stack<>();
        Stack<String> keepStack = new Stack<>();
        String word = bf.readLine();
        for (String s : word.split("")) {
            answerStack.push(s);
        }
        int num = Integer.parseInt(bf.readLine());
        for (int i=0; i<num; i++) {
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            if (strArr[0].equals("L")) {
                if (!answerStack.isEmpty()){
                    keepStack.push(answerStack.pop());
                }
            }
            else if (strArr[0].equals("D")){
                if (!keepStack.isEmpty()){
                    answerStack.push(keepStack.pop());
                }
            }
            else if (strArr[0].equals("B")) {
                if (!answerStack.isEmpty()){
                    answerStack.pop();
                }
            }
            else if (strArr[0].equals("P")) {
                answerStack.push(strArr[1]);
            }
        }
        while (!answerStack.isEmpty()) {
            keepStack.push(answerStack.pop());
        }
        while (!keepStack.isEmpty()) {
            bw.write(keepStack.pop());
        }
        bw.close();
    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String word = bf.readLine();
//        int curser = word.length();
//        int num = Integer.parseInt(bf.readLine());
//        for (int i=0; i<num; i++) {
//            String str = bf.readLine();
//            String[] strArr = str.split(" ");
//            if (strArr[0].equals("L")) {
//                if (curser != 0) {
//                    curser--;
//                }
//            }
//            else if (strArr[0].equals("D")){
//                if (curser != word.length()) {
//                    curser++;
//                }
//            }
//            else if (strArr[0].equals("B")) {
//                if (curser!=0) {
//                    String answer = word.substring(0,curser-1) + word.substring(curser);
//                    word = answer;
//                    curser--;
//                }
//            }
//            else if (strArr[0].equals("P")) {
//                String answer = word.substring(0,curser) + strArr[1] + word.substring(curser);
//                word = answer;
//                curser++;
//            }
//        }
//        bw.write(word);
//        bw.close();
//    }
}
