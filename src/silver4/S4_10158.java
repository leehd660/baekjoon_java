package silver4;

import java.io.*;

public class S4_10158 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String W_Hstr = bf.readLine();
//        String[] whArr = W_Hstr.split(" ");
//        int w = Integer.parseInt(whArr[0]);
//        int h = Integer.parseInt(whArr[1]);
//        String initStr = bf.readLine();
//        String[] initArr = initStr.split(" ");
//        int x = Integer.parseInt(initArr[0]);
//        int y = Integer.parseInt(initArr[1]);
//        int t = Integer.parseInt(bf.readLine());
//        int version = 1;
//
//        for (int i=0; i<t; i++) {
//            switch (version) {
//                case 1 : if (x+1 <= w && y+1 <= h){
//                    x++;
//                    y++;
//                }
//                else if (x+1<=w && y+1>h){
//                    version = 4;
//                    x++;
//                    y--;
//                }
//                else if (x+1>w && y+1 <=h){
//                    version = 2;
//                    x--;
//                    y++;
//                }
//                else if (x+1>w && y+1>h) {
//                    version = 3;
//                    x--;
//                    y--;
//                }
//                break;
//                case 2 : if (x-1 >= 0 && y+1 <= h){
//                    x--;
//                    y++;
//                }
//                else if (x-1>=0 && y+1>h){
//                    version = 3;
//                    x--;
//                    y--;
//                }
//                else if (x-1<0 && y+1 <=h){
//                    version = 1;
//                    x++;
//                    y++;
//                }
//                else if (x-1<0 && y+1>h) {
//                    version = 4;
//                    x++;
//                    y--;
//                }
//                break;
//                case 3 : if (x-1 >= 0 && y-1 >= 0){
//                    x--;
//                    y--;
//                }
//                else if (x-1>=0 && y-1<0){
//                    version = 2;
//                    x--;
//                    y++;
//                }
//                else if (x-1<0 && y-1 >=0){
//                    version = 4;
//                    x++;
//                    y--;
//                }
//                else if (x-1<0 && y-1<0) {
//                    version = 1;
//                    x++;
//                    y++;
//                }
//                break;
//                case 4 : if (x+1 <= w && y-1 >= 0){
//                    x++;
//                    y--;
//                }
//                else if (x+1<=w && y-1<0){
//                    version = 1;
//                    x++;
//                    y++;
//                }
//                else if (x+1>w && y-1 >=0){
//                    version = 3;
//                    x--;
//                    y--;
//                }
//                else if (x+1>w && y-1<0) {
//                    version = 2;
//                    x--;
//                    y++;
//                }
//                break;
//            }
//        }
//        bw.write(String.valueOf(x) + " " + String.valueOf(y));
//        bw.close();
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String W_Hstr = bf.readLine();
        String[] whArr = W_Hstr.split(" ");
        int w = Integer.parseInt(whArr[0]);
        int h = Integer.parseInt(whArr[1]);
        String initStr = bf.readLine();
        String[] initArr = initStr.split(" ");
        int x = Integer.parseInt(initArr[0]);
        int y = Integer.parseInt(initArr[1]);
        int t = Integer.parseInt(bf.readLine());

        if (w - x <= t) {
            if (((t-(w-x))/w)%2 == 1){
                x = ((t-(w-x))%w);
            }
            else {
                x = w- ((t-(w-x))%w);
            }
        }
        else {
            x = x+t;
        }

        if (h - y <= t) {
            if (((t-(h-y))/h)%2 == 1){
                y = ((t-(h-y))%h);
            }
            else {
                y = h-((t-(h-y))%h);
            }
        }
        else {
            y = y+t;
        }
        bw.write(String.valueOf(x));
        bw.write(" ");
        bw.write(String.valueOf(y));
        bw.close();
    }
}
