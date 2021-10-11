package silver5;

import java.util.Arrays;
import java.util.Scanner;

public class 방번호 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arr = new int[9];
        while(true) {
            int n = num%10;
            if (n==9){
                n=6;
            }
            arr[n]++;
            if (num/10==0){
                break;
            }
            else{
                num = num/10;
            }
        }
        arr[6] = (int)Math.ceil((double) arr[6]/2);
        Arrays.sort(arr);
        System.out.println(arr[arr.length-1]);
    }
}
