package silver4;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class S4_4949 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        Scanner scanner = new Scanner(System.in);
//        String text = "";
//        while (scanner.hasNext()) {
//            text += scanner.nextLine();
//        }
////        String[] array = text.split(".");
////        for (String line : array) {
////            String answer = "";
////            if (line.equals("")) {
////
////            }
////            else {
////                Stack<String> stack = new Stack<>();
////                String[] arr = line.split("");
////                for (String s : arr) {
////                    if (s.equals("(") || s.equals("[") || s.equals("]") || s.equals(")")) {
////                        if (stack.empty() && (s.equals("]") || s.equals(")"))) {
////                            answer = "no";
////                            break;
////                        } else if (s.equals("(") || s.equals("[")) {
////                            stack.push(s);
////                        } else if (s.equals("]") || s.equals(")")) {
////                            if (check(stack.peek(), s)) {
////                                stack.pop();
////                                answer = "yes";
////                            } else {
////                                answer = "no";
////                                break;
////                            }
////                        }
////                    } else {
////                        continue;
////                    }
////                }
////                if (answer.equals("yes") && !stack.empty()) {
////                    answer = "no";
////                } else if (answer.equals("")) {
////                    answer = "yes";
////                }
////            }
////
////            bw.write(answer);
////            bw.write("\n");
////        }
//
//        for (String s : text.split("")){
//            String answer = "";
//            Stack<String> stack = new Stack<>();
//
//            if (s.equals("(") || s.equals("[") || s.equals("]") || s.equals(")")) {
//                if (stack.empty() && (s.equals("]") || s.equals(")"))) {
//                    answer = "no";
//                    break;
//                } else if (s.equals("(") || s.equals("[")) {
//                    stack.push(s);
//                } else if (s.equals("]") || s.equals(")")) {
//                    if (check(stack.peek(), s)) {
//                        stack.pop();
//                        answer = "yes";
//                    } else {
//                        answer = "no";
//                        break;
//                    }
//                }
//            }
//            else if (s.equals(".")){
//                if (answer.equals("yes") && !stack.empty()) {
//                    answer = "no";
//                } else if (answer.equals("")) {
//                    answer = "yes";
//                }
//                bw.write(answer);
//                bw.write("\n");
//                answer = "";
//                stack.clear();
//            }
//            else {
//                continue;
//            }
//        }
//
//
//        bw.close();
//    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            if (str.equals(".")){
                break;
            }
            String answer = "";
            Stack<String> stack = new Stack<>();
            for (String s : str.split("")) {
                if (s.equals("(") || s.equals("[") || s.equals("]") || s.equals(")")) {
                    if (stack.empty() && (s.equals("]") || s.equals(")"))) {
                        answer = "no";
                        break;
                    } else if (s.equals("(") || s.equals("[")) {
                        stack.push(s);
                    } else if (s.equals("]") || s.equals(")")) {
                        if (check(stack.peek(), s)) {
                            stack.pop();
                            answer = "yes";
                        } else {
                            answer = "no";
                            break;
                        }
                    }
                }
            }
            if (!stack.empty()) {
                    answer = "no";
            } else if (answer.equals("")) {
                    answer = "yes";
            }
            bw.write(answer);
            bw.write("\n");
            answer = "";
            stack.clear();

        }
        bw.close();
    }


    static boolean check (String s1, String s2) {
        if (s1.equals("[") && s2.equals("]")) {
            return true;
        }
        else if (s1.equals("(") && s2.equals(")")) {
            return true;
        }
        else {
            return false;
        }
    }
}
