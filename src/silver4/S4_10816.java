package silver4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class S4_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> card = new HashMap<>();

        String nStr = bf.readLine();
        int n = Integer.parseInt(nStr);
        String nArrStr = bf.readLine();
        String[] nArr = nArrStr.split(" ");

        for (int i=0; i<n; i++) {
            String str = nArr[i];
            if (card.keySet().contains(str)) {
                card.put(str, card.get(str)+1);
            }
            else {
                card.put(str, 1);
            }
        }

        String mStr = bf.readLine();
        int m = Integer.parseInt(mStr);
        String mArrStr = bf.readLine();
        String[] mArr = mArrStr.split(" ");

        for (int i=0; i<m; i++) {
            String str = mArr[i];
            if (card.keySet().contains(str)) {
                bw.write(String.valueOf(card.get(str)));
            }
            else {
                bw.write("0");
            }
            bw.write(" ");
        }
        bw.close();
    }
}
