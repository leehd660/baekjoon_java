package silver4;

import java.io.*;

public class S4_10157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String C_Rstr = bf.readLine();
        String[] strArr = C_Rstr.split(" ");
        int c = Integer.parseInt(strArr[0]);
        int r = Integer.parseInt(strArr[1]);
        int k = Integer.parseInt(bf.readLine());
        if (k>c*r) {
            bw.write("0");
        }
        else {
            int totalLine = (int)Math.round(r/2.0);
            int line = 0;
            int min = 1;
            int max = 2 * (c - 1) + 2 * (r - 1);

            for (int i=0; i<totalLine; i++) {
                if (min <= k && k <= max) {
                    line = i+1 ;
                    break;
                }
                else {
                    min = max+1;
                    max = min + (2*(c-1-2*(i+1))+2*(r-1-2*(i+1))) -1 ;
                }
            }
            int x = line;
            int y = line;
            if (min <= k && k<= min + (r-2*(line-1)-1)){
                x = line;
                y = line + (k-min);
            }
            else if (min + (r-2*(line-1)-1)<k && k<= min + (r-2*(line-1)-1) + (c-2*(line-1)-1)) {
                y = line + (r-2*(line-1)-1);
                x = line + (-(min + (r-2*(line-1)-1)) +k);
            }
            else if (min + (r-2*(line-1)-1) + (c-2*(line-1)-1)<k
                    && k<= min + (r-2*(line-1)-1) + (c-2*(line-1)-1) + (r-2*(line-1)-1)) {
                x = line + (c-2*(line-1)-1);
                y = (line + (r-2*(line-1)-1)) - (-(min + (r-2*(line-1)-1) + (c-2*(line-1)-1)) +k);
            }
            else {
                x = (line + (c-2*(line-1)-1)) - (-(min + (r-2*(line-1)-1) + (c-2*(line-1)-1) + (r-2*(line-1)-1)) +k);
                y = line;
            }
            bw.write(String.valueOf(x) + " " + String.valueOf(y));
        }
        bw.close();
    }
}
