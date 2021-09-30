package bronze1;

import java.util.Arrays;
import java.util.Scanner;

public class 수정렬하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[num];

        for (int i=0; i<num; i++){
            arr[i]= scanner.nextInt();
        }
        Arrays.sort(arr);
        for (int i: arr){
            System.out.println(i);
        }
    }
}
