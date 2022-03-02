package silver1;

import java.io.*;
import java.util.StringTokenizer;

public class S1_1074 {
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(token.nextToken());
        int r = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        count = 0;
        findOrder(N,r,c);
        bw.write(String.valueOf(count));
        bw.close();
    }
    static void findOrder (int n, int x, int y) {
        if (n==1) {
            if (x==0 && y==0) {
                count += 0;
            }
            else if (x==0 && y==1) {
                count += 1;
            }
            else if (x==1 && y==0) {
                count += 2;
            }
            else {
                count += 3;
            }
        }
        else {
            if (x/(int)Math.pow(2,n-1) == 0 && y/(int)Math.pow(2,n-1) == 0) {
                findOrder(n-1,x,y);
            }
            else if (x/(int) Math.pow(2,n-1) == 0 && y/(int)Math.pow(2,n-1) == 1) {
                count += Math.pow(2,n-1)*Math.pow(2,n-1);
                findOrder(n-1, x, (int) (y-Math.pow(2,n-1)));
            }
            else if (x/(int)(Math.pow(2,n-1)) == 1 && y/(int)Math.pow(2,n-1) == 0) {
                count += 2*Math.pow(2,n-1)*Math.pow(2,n-1);
                findOrder(n-1, (int) (x-Math.pow(2,n-1)), y);
            }
            else {
                count += 3*Math.pow(2,n-1)*Math.pow(2,n-1);
                findOrder(n-1, (int) (x-Math.pow(2,n-1)), (int) (y-Math.pow(2,n-1)));
            }
        }
    }
}
