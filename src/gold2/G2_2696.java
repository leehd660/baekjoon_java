package gold2;

import java.io.*;
import java.util.*;

public class G2_2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int testNum = Integer.parseInt(bf.readLine());
        for (int test=0; test<testNum; test++) {
            int len = Integer.parseInt(bf.readLine());
            bw.write(String.valueOf(len/2+1)+"\n");
            PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> big = new PriorityQueue<>();
            List<Integer> list = new ArrayList<>();
            for (int line=0; line<=(len-1)/10; line++) {
                StringTokenizer token = new StringTokenizer(bf.readLine());
                while (token.hasMoreTokens()) {
                    list.add(Integer.parseInt(token.nextToken()));
                }
            }
            int count =0;
            for (int i=0; i<len; i++) {
                int num = list.get(i);
                if (big.isEmpty() || small.isEmpty()) {
                    small.add(num);
                    if (small.size()-big.size()>1) {
                        big.add(small.poll());
                    }
                }
                else {
                    if (num > big.peek()) {
                        big.add(num);
                        if (small.size()-big.size()<1) {
                            small.add(big.poll());
                        }
                    } else {
                        small.add(num);
                        if (small.size() - big.size() > 1) {
                            big.add(small.poll());
                        }
                    }
                }
                if (i%2 ==0) {
                    bw.write(String.valueOf(small.peek())+" ");
                    count++;
                    if (count%10==0) {
                        bw.write("\n");
                    }
                }
            }
            bw.write("\n");
        }
        bw.close();
    }
}
