package silver4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class S4_11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Map<Long, Integer> map = new HashMap<>();
        for (int i=0; i<num; i++) {
            String numberStr = bf.readLine();
            Long number = Long.parseLong(numberStr);
            if (map.keySet().contains(number)) {
                map.put(number, map.get(number)+1);
            }
            else {
                map.put(number, 1);
            }
        }
        long answer = 0;
        int maxNum = 0;
        for (Long s:map.keySet()){
            if (maxNum<map.get(s)) {
                maxNum = map.get(s);
                answer = s;
            }
            if (maxNum == map.get(s)){
                if (answer < s){
                    continue;
                }
                else {
                    answer = s;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
