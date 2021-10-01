package silver5;

import java.io.*;
import java.util.Arrays;

public class 수정렬하기2 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
////        List<Integer> arr = new ArrayList<>();
////        List<Integer> miArr = new ArrayList<>();
//        Map<Integer,Boolean> map = new HashMap<>();
//
//        for (int i=0; i<num; i++){
//            int n = scanner.nextInt();
//            map.put(n,true);
////            if (n>=0){
////                arr.add(n);
////            }
////            else {
////                miArr.add(n);
////            }
//        }
////        Collections.sort(arr);
////        Collections.sort(miArr);
//        for (int i: map.keySet()){
//            System.out.println(i);
//        }
////        for (int i: arr){
////            System.out.println(i);
////        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        Object[] arr = new Object[num];
        for (int i=0; i<num; i++){
            int n = Integer.parseInt(bf.readLine());
            arr[i] = n;
        }
        Arrays.sort(arr);
        for (Object i : arr){
            bw.write(i+"\n");
        }
        bw.close();
    }
}

