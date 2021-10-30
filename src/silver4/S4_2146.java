package silver4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S4_2146 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
//        List<Integer> arr = new ArrayList<>();
//        for (int i=1; i<=num; i++){
//            arr.add(i);
//        }
//        int a =0;
//        while (true) {
//            for (int i:arr) {
//                bw.write(String.valueOf(i));
//                bw.write(" ");
//            }
//            bw.write("\n");
//            if (a%2 ==0) {
//                arr.remove(0);
//            }
//            else {
//                arr.add(arr.get(0));
//                arr.remove(0);
//            }
////            arr.remove(0);
////            arr.add(arr.get(0));
////            arr.remove(0);
//            if (arr.size()==1){
//                bw.write(String.valueOf(arr.get(0)));
//                break;
//            }
//            a++;
//        }

        Deque<Integer> arr = new ArrayDeque<>();
        for (int i=1; i<num+1; i++) {
            arr.add(i);
        }
        while (arr.size()!=1) {
            arr.removeFirst();
            arr.addLast(arr.getFirst());
            arr.removeFirst();
        }
        bw.write(String.valueOf(arr.getFirst()));
        bw.close();
    }
}
