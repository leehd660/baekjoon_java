package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S4_11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();
        String str = bf.readLine();
        for (int i=0; i<str.length(); i++) {
            String word = str.substring(i,str.length());
            list.add(word);
        }
        Collections.sort(list);
        for (String s:list){
            bw.write(s);
            bw.write("\n");
        }
        bw.close();
    }
}
