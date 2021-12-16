package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S4_2776 {
    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int T = scanner.nextInt();
        String Tstr = bf.readLine();
        int T = Integer.parseInt(Tstr);
        for (int i=0; i<T; i++) {
            String arr1Str = bf.readLine();
            int arr1Num = Integer.parseInt(arr1Str);
            List<Integer> arr1 = new ArrayList<>();
            String arr1NumStr = bf.readLine();
            String[] arr1NumArr = arr1NumStr.split(" ");
            for (String s : arr1NumArr) {
                int num = Integer.parseInt(s);
                arr1.add(num);
            }
            Collections.sort(arr1);
            String arr2Str = bf.readLine();
            int arr2Num = Integer.parseInt(arr2Str);
            String arr2NumStr = bf.readLine();
            String[] arr2NumArr = arr2NumStr.split(" ");
            for (String s : arr2NumArr) {
                int num = Integer.parseInt(s);
                if (arr1.contains(num)) {
                    bw.write("1\n");
                }
                else {
                    bw.write("0\n");
                }
            }
        }
        bw.close();
    }

    static boolean containTest(int[] arr, int findNum) {
        int num = arr.length/2;
//        if (arr.length)
        if(findNum == arr[num]) {
            return true;
        }
        else if (findNum < arr[num]){
            return containTest(arr, num/2);
        }
        else {
            return containTest(arr, (int)(num+(num/2)));
        }
    }

//    static int[] makeArr (int[] arr, int num) {
//
//    }
}
