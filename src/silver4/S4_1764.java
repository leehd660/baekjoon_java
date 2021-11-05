package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S4_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        String[] arr = numStr.split(" ");
        int num1 = Integer.parseInt(arr[0]);
        int num2 = Integer.parseInt(arr[1]);
        List<String> list = new ArrayList<>();
//        for (int i=0; i<num1; i++) {
//            String name = bf.readLine();
//            list.add(name);
//        }
//        List<String> answerArr = new ArrayList<>();
//        for (int i=0; i<num2; i++) {
//            String compareName = bf.readLine();
//            if (list.contains(compareName)) {
//                answerArr.add(compareName);
//            }
//        }
//        Collections.sort(answerArr);
//        bw.write(String.valueOf(answerArr.size()));
//        bw.write("\n");
//        for (String s : answerArr){
//            bw.write(s);
//            bw.write("\n");
//        }
//        bw.close();

        List<String> answerList = new ArrayList<>();
        int count = 0;
        for (int i=0; i<num1+num2; i++) {
            String name = bf.readLine();
            list.add(name);
        }
        Collections.sort(list);
        for (int i=1; i< num1+num2; i++) {
            if (list.get(i-1).equals(list.get(i))){
                answerList.add(list.get(i));
            }
        }
        bw.write(String.valueOf(answerList.size()));
        bw.write("\n");
        for (String s : answerList){
            bw.write(s);
            bw.write("\n");
        }
        bw.close();
    }
}
