package silver5;

import java.io.*;

public class S5_1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String xStr = bf.readLine();
        int count =0;
        while (xStr.length()!=1) {
            String[] xArr = xStr.split("");
            int changeNum = 0;
            for (String xPart : xArr) {
                changeNum += Integer.parseInt(xPart);
            }
            xStr = String.valueOf(changeNum);
            count++;
        }
        int xNum = Integer.parseInt(xStr);
        bw.write(String.valueOf(count) + "\n");
        if (xNum ==3 || xNum==6 || xNum==9) {
            bw.write("YES");
        }
        else {
            bw.write("NO");
        }
        bw.close();
    }
}
