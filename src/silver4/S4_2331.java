package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S4_2331 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = bf.readLine();
        String[] arr = line.split(" ");
        int num = Integer.parseInt(arr[0]);
        int P = Integer.parseInt(arr[1]);
        List<Integer> list = new ArrayList<>();
        list.add(num);
        int index = 0;
        int answerNum = 0;
        while (true) {
            String beforeNumStr = String.valueOf(list.get(index));
            String[] numSplit = beforeNumStr.split("");
            int answer = 0;
            for (String s : numSplit){
                answer += Math.pow(Integer.parseInt(s),P);
            }
            if (list.contains(answer)) {
                for (int i=0; i<list.size(); i++){
                    if (list.get(i) == answer) {
                        answerNum = i;
                        break;
                    }
                }
                break;
            }
            else {
                list.add(answer);
                index ++;
                continue;
            }
        }
        bw.write(String.valueOf(answerNum));
        bw.close();
    }
}
