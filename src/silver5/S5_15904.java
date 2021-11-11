package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S5_15904 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sentence = bf.readLine();
        String[] strArr = sentence.split("");
        List<String> table = new ArrayList<>();
        for (String s : strArr) {
            if (s.charAt(0) >= 65 && s.charAt(0) <= 90) {
                table.add(s);
            }
        }
        String[] test = {"U", "C", "P", "C"};
        int order = 0;
        for (String s:table) {
            if (s.equals(test[order])){
                order++;
                if (order == 4) {
                    break;
                }
            }

        }
        if (order >= 4){
            bw.write("I love UCPC");
        }
        else {
            bw.write("I hate UCPC");
        }
        bw.close();
    }
}
