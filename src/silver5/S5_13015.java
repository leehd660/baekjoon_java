package silver5;

import java.io.*;
import java.util.Stack;

public class S5_13015 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Stack<String> stack = new Stack<>();

        String line = "";
        for (int j=0; j<num; j++) {
            line += "*";
        }
        for (int j=0; j<2*num-3; j++)  {
            line += " ";
        }
        for (int j=0; j<num; j++) {
            line += "*";
        }
        stack.push(line);
        bw.write(line+" \n");
        for (int i=0; i<num-2; i++) {
            String addLine = "";
            for (int j=0; j<i+1; j++) {
                addLine += " ";
            }
            addLine += "*";
            for (int j=0; j<num-2; j++) {
                addLine += " ";
            }
            addLine += "*";
            for (int j=0; j<(2*num-3)-2*(i+1); j++) {
                addLine += " ";
            }
            addLine += "*";
            for (int j=0; j<num-2; j++) {
                addLine += " ";
            }
            addLine += "*";
            for (int j=0; j<i+1; j++) {
                addLine += " ";
            }
            bw.write(addLine+" \n");
            stack.push(addLine);
        }
        String middleLine = "";
        for (int i=0; i<num-1; i++) {
            middleLine += " ";
        }
        middleLine+="*";
        for (int i=0; i<num-2; i++) {
            middleLine+=" ";
        }
        middleLine+="*";
        for (int i=0; i<num-2; i++) {
            middleLine+=" ";
        }
        middleLine+="*";
        for (int i=0; i<num-1; i++) {
            middleLine += " ";
        }
        bw.write(middleLine);
        while (!stack.empty()) {
            bw.write(" \n");
            bw.write(stack.pop());
        }
        bw.close();
    }
}
