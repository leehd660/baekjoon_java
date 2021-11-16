package silver4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class S4_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<num; i++) {
            String book = bf.readLine();
            if (map.keySet().contains(book)){
                map.put(book,map.get(book)+1);
            }
            else {
                map.put(book,1);
            }
        }
        int maxNum = 0;
        String bestseller = "";
        for (String s : map.keySet()){
            int bookNum = map.get(s);
            if (maxNum < bookNum) {
                maxNum = bookNum;
                bestseller = s;
            }
            else if (maxNum == bookNum) {
                if (bestseller.compareTo(s) > 0) {
                    bestseller = s;
                }
            }
        }
        bw.write(bestseller);
        bw.close();
    }
}
