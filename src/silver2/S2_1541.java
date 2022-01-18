package silver2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S2_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String formula = bf.readLine();
        String[] formulaArr = formula.split("");
        List<String> funcList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        String number = "";
        for (int i=0; i<formulaArr.length; i++) {
            if (formulaArr[i].equals("+") || formulaArr[i].equals("-")) {
                if (!number.equals("")) {
                    numList.add(Integer.parseInt(number));
                    number = "";
                }
                funcList.add(formulaArr[i]);
            }
            else if (i==0) {
                funcList.add("+");
                number += formulaArr[i];
            }
            else {
                number += formulaArr[i];
            }
        }
        numList.add(Integer.parseInt(number));
        for (int i=0; i<funcList.size(); i++) {
            if (funcList.get(i).equals("-")) {
                continue;
            }
            else if (funcList.get(i).equals("+") && i!=0){
                numList.set(i-1,numList.get(i-1)+numList.get(i));
                numList.remove(i);
                funcList.remove(i);
            }
        }
        int answer = 0;
        for (int i=0; i<funcList.size(); i++) {
            if (funcList.get(i).equals("+")) {
                answer += numList.get(i);
            }
            else {
                answer += (-1) * numList.get(i);
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
