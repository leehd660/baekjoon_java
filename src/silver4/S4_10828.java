package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S4_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> stackArr = new ArrayList<>();
        String strNum = bf.readLine();
        int num = Integer.parseInt(strNum);
        for (int i=0; i<num; i++) {
            String instruction = bf.readLine();
            String[] instructArr = instruction.split(" ");
            switch (instructArr[0]) {
                case "push" : stackArr.add(Integer.parseInt(instructArr[1])); break;
                case "pop" : if (stackArr.size()==0) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(String.valueOf(stackArr.get(stackArr.size()-1)));
                    bw.write("\n");
                    stackArr.remove(stackArr.size()-1);
                }
                    break;
                case "size" : bw.write(String.valueOf(stackArr.size()));bw.write("\n");break;
                case "empty" : if (stackArr.size()==0){
                    bw.write("1\n");
                }
                else {
                    bw.write("0\n");
                }
                break;
                case "top" : if (stackArr.size()==0) {
                    bw.write("-1\n");
                }
                else {
                    bw.write(String.valueOf(stackArr.get(stackArr.size()-1)));
                    bw.write("\n");
                }
                break;
            }
        }
        bw.close();
    }
}
