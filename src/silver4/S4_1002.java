package silver4;

import java.io.*;

public class S4_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++) {
            String str = bf.readLine();
            String[] table = str.split(" ");
            int x1 = Integer.parseInt(table[0]);
            int y1 = Integer.parseInt(table[1]);
            int r1 = Integer.parseInt(table[2]);
            int x2 = Integer.parseInt(table[3]);
            int y2 = Integer.parseInt(table[4]);
            int r2 = Integer.parseInt(table[5]);
            double between = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));
            double r3 = Math.sqrt(Math.pow(r1+r2,2));
            if (x1 == x2 && y1 == y2) {
                if (r1 == r2){
                    bw.write("-1\n");
                }
                else {
                    bw.write("0\n");
                }
            }
            else if (between < Math.max(r1,r2)){
                if (between+Math.min(r1,r2) == Math.max(r1,r2)) {
                    //내접
                    bw.write("1\n");
                }
                else if (between+Math.min(r1,r2) < Math.max(r1,r2)) {
                    // 내접하는데 접점 0
                    bw.write("0\n");
                }
                else if (between+Math.min(r1,r2) > Math.max(r1,r2)) {
                    bw.write("2\n");
                }
            }
            else {
                if (between == r3) {
                    bw.write("1\n");
                }
                else if (between > r3) {
                    bw.write("0\n");
                }
                else if (between < r3) {
                    bw.write("2\n");
                }
            }
        }
        bw.close();
    }
}
