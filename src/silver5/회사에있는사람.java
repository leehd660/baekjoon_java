package silver5;

import java.io.*;
import java.util.*;

public class 회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Map<String, String> gigle = new HashMap<>();
        for (int i=0; i<num; i++) {
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            gigle.put(strArr[0], strArr[1]);
        }
        List<String> arr = new ArrayList<>();
        for (String s: gigle.keySet()){
            if (gigle.get(s).equals("enter")) {
                arr.add(s);
            }
        }
        Collections.sort(arr);
        for (int i=0; i<arr.size(); i++){
            bw.write(arr.get(arr.size()-1-i)+'\n');
        }
        bw.close();
    }
}
