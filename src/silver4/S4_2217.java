package silver4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S4_2217 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Integer[] arr = new Integer[num];
        for (int i=0; i<num; i++) {
            int roop = scanner.nextInt();
            arr[i]= roop;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int maxNum = 0;
        for (int i=0; i<num; i++) {
            if (maxNum<arr[i]*(i+1)){
                maxNum = arr[i]*(i+1);
            }
        }
        System.out.println(maxNum);
    }
}
