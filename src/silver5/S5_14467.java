package silver5;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class S5_14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i=0; i<num; i++) {
            String str = bf.readLine();
            String[] strArr = str.split(" ");
            int cowNum = Integer.parseInt(strArr[0]);
            int cowRoad = Integer.parseInt(strArr[1]);
            if (map.keySet().contains(cowNum)) {
                if (map.get(cowNum) == cowRoad) {
                    continue;
                }
                else {
                    map.put(cowNum,cowRoad);
                    answer ++;
                }
            }
            else {
                map.put(cowNum, cowRoad);
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
