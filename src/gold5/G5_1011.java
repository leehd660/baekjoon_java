package gold5;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class G5_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testNum = Integer.parseInt(bf.readLine());
        for (int test=0; test<testNum; test++) {
            String XYstr = bf.readLine();
            StringTokenizer XYtoken = new StringTokenizer(XYstr);
            int x = Integer.parseInt(XYtoken.nextToken());
            int y = Integer.parseInt(XYtoken.nextToken());
            int distance = y-x;
            if (distance == 1) {
                bw.write(String.valueOf(1)+"\n");
            }
            else if (distance == 2) {
                bw.write(String.valueOf(2)+"\n");
            }
            else {
                Stack<Integer> stackX = new Stack<>();
                Stack<Integer> stackY = new Stack<>();
                int total = 2;
                stackX.add(1);
                stackY.add(1);
                while (total!=distance) {
                    int beforeNumX = stackX.peek();
                    if (distance-total > beforeNumX) {
                        stackX.add(beforeNumX+1);
                        total += beforeNumX+1;
                    }
                    else if (distance - total == beforeNumX) {
                        stackX.add(beforeNumX);
                        total += beforeNumX;
                    }
                    else if (distance - total >= beforeNumX-1) {
                        if (beforeNumX-1>0) {
                            stackX.add(beforeNumX-1);
                            total += beforeNumX-1;
                        }
                    }
                    if (total==distance) {
                        break;
                    }
                    else {
                        int beforeNumY = stackY.peek();
                        if (distance-total > beforeNumY) {
                            stackY.add(beforeNumY+1);
                            total += beforeNumY+1;
                        }
                        else if (distance - total == beforeNumY) {
                            stackY.add(beforeNumY);
                            total += beforeNumY;
                        }
                        else if (distance - total >= beforeNumY-1) {
                            if (beforeNumY-1>0) {
                                stackY.add(beforeNumY-1);
                                total += beforeNumY-1;
                            }
                        }
                    }
                }
                bw.write(String.valueOf(stackX.size()+stackY.size())+"\n");
            }
        }
        bw.close();
    }
}
