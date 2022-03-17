package silver1;

import java.io.*;
import java.util.PriorityQueue;

public class S1_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (Math.abs(o1) < Math.abs(o2)) {
//                    return 0;
//                }
//                else if (Math.abs(o1)==Math.abs(o2)){
//                    if (o1 < o2) {
//                        return -1;
//                    }
//                    else if (o1 == o2) {
//                        return 0;
//                    }
//                    else {
//                        return 1;
//                    }
//                }
//                else {
//                    return 1;
//                }
//            }
//        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->
                Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
        );
        for (int i=0; i<num; i++) {
            int n = Integer.parseInt(bf.readLine());
            if (n==0) {
                if (queue.isEmpty()) {
                    bw.write("0\n");
                }
                else {
                    bw.write(String.valueOf(queue.poll()) + "\n");
                }
            }
            else {
                queue.add(n);
            }
        }
        bw.close();
    }
}
