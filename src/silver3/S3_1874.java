package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S3_1874 {
    // 12/29 재도전
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        int[] wantArr = new int[num];
        for (int i = 0; i < num; i++) {
            wantArr[i] = Integer.parseInt(bf.readLine());
        }
        int pushNum = 2;
        int checkNum = 0;
        Stack<Integer> stack = new Stack<>();
        List<String> answer = new ArrayList<>();
        stack.push(1);
        answer.add("+");
        while (pushNum < num || !stack.empty()) {
            if (stack.empty()) {
                stack.push(pushNum);
                answer.add("+");
                if (pushNum<num){
                    pushNum++;
                }
            }
            if (stack.peek() == wantArr[checkNum]) {
                stack.pop();
                answer.add("-");
                checkNum++;
            } else {
                if (wantArr[checkNum] > pushNum-1) {
                    stack.push(pushNum);
                    answer.add("+");
                    if (pushNum<num){
                        pushNum++;
                    }
                }
                else {
                    answer.clear();
                    answer.add("NO");
                    break;
                }
            }
        }
        for (String s:answer) {
            bw.write(s+"\n");
        }
        bw.close();
    }
}





//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int num = Integer.parseInt(bf.readLine());
//        int[] wantArr = new int[num];
//        boolean[] checkTable = new boolean[num];
////        boolean check = true;
////        for (int i=0; i<num; i++) {
////            wantArr[i] = Integer.parseInt(bf.readLine());
////            checkTable[wantArr[i]-1] = true;
////            if (check) {
////                for (int j = wantArr[i]; j < num - 1; j++) {
////                    if (!checkTable[j] && checkTable[j + 1]) {
////                        check = false;
////                        break;
////                    }
////                }
////            }
////        }
////        if (check) {
////            Stack<Integer> stack = new Stack<>();
////            int arrNum = 0;
////            for (int i=1; i<=num; i++) {
////                if (stack.empty()){
////                    stack.push(i);
////                    bw.write("+\n");
////                }
////                else if (stack.peek()!=wantArr[arrNum]) {
////                    stack.push(i);
////                    bw.write("+\n");
////                }
////                else if (stack.peek()==wantArr[arrNum]) {
////                    while (stack.peek()==wantArr[arrNum]) {
////                        stack.pop();
////                        arrNum++;
////                        bw.write("-\n");
////                        if (stack.empty()) break;
////                    }
////                    stack.push(i);
////                    bw.write("+\n");
////                }
////            }
////            for (int i=0; i<stack.size(); i++) {
////                bw.write("-\n");
////            }
////        }
////        else {
////            bw.write("NO");
////        }
//
//        for (int i=0; i<num; i++) {
//            wantArr[i] = Integer.parseInt(bf.readLine());
//        }
//
//        Stack<Integer> stack = new Stack<>();
//        int arrNum = 0;
//        List<String> answer = new ArrayList<>();
//        for (int i=1; i<=num; i++) {
//            if (stack.empty()){
//                stack.push(i);
//                answer.add("+");
//            }
//            else if (wantArr[arrNum]< stack.peek()) {
//                answer.clear();
//                answer.add("NO");
//                break;
//            }
//            else if (stack.peek()!=wantArr[arrNum]) {
//                stack.push(i);
//                answer.add("+");
//            }
//            else if (stack.peek()==wantArr[arrNum]) {
//                while (stack.peek()==wantArr[arrNum]) {
//                    stack.pop();
//                    arrNum++;
//                    answer.add("-");
//                    if (stack.empty()) {
//                        break;
//                    }
//                    else if (wantArr[arrNum]< stack.peek()) {
//                        answer.clear();
//                        answer.add("NO");
//                        break;
//                    }
//                }
//                stack.push(i);
//                answer.add("+");
//            }
//            if (answer.get(0).equals("NO")) {
//                break;
//            }
//        }
//        if (!answer.get(0).equals("NO")) {
//            for (int i = 0; i < stack.size(); i++) {
//                answer.add("-");
//            }
//        }
//        for (String s : answer) {
//            bw.write(s+"\n");
//        }
//        bw.close();
//    }
//}
