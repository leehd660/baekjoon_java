package silver3;

import java.io.*;

public class S3_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String NMstr = bf.readLine();
        String[] NMarr = NMstr.split(" ");
        int N = Integer.parseInt(NMarr[0]);
        int M = Integer.parseInt(NMarr[1]);
        String numberStr = bf.readLine();
        String[] numStrArr = numberStr.split(" ");
//        int[] arr = new int[N+1];
        int[] dpSum = new int[N+1];
//        Deque<Integer> deque = new ArrayDeque<>();
//        Deque<Integer> keepDeque = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
//            arr[i] = Integer.parseInt(numStrArr[i]);
            dpSum[i] = Integer.parseInt(numStrArr[i-1])+dpSum[i-1];
//            deque.add(Integer.parseInt(numStrArr[i]));
        }
        for (int i=0; i<M; i++) {
            String ijStr = bf.readLine();
            String[] ijArr = ijStr.split(" ");
            int num1 = Integer.parseInt(ijArr[0]);
            int num2 = Integer.parseInt(ijArr[1]);
            int answer =0;
//            while(keepDeque.size() != num1-1) {
//                keepDeque.add(deque.pollFirst());
//            }
//            for (int j=0; j<num2-num1+1; j++) {
//                answer += deque.getFirst();
//                keepDeque.add(deque.pollFirst());
//            }
//            while (!keepDeque.isEmpty()) {
//                deque.addFirst(keepDeque.pollLast());
//            }
            answer = dpSum[num2]-dpSum[num1-1];
            bw.write(String.valueOf(answer + "\n"));
        }
        bw.close();
    }
}
