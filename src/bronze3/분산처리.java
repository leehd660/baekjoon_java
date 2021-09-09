package bronze3;

import java.util.Scanner;

public class 분산처리 {
    //
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] arr = new long[n];

        for (int i=0; i<n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            arr[i] = Computer(a,b);
        }
        for (long i : arr){
            System.out.println(i);
        }
    }

    public static long Computer(int a, int b){
        long answer = 1;
//        answer = (int)Math.pow(a,b) % 10;
        int num=1;
        for (int i = 0; i<b; i++){
            num = (num*a)%10;
            if (num == 0){
                num = 10;
            }
            answer = num;
        }
//        if (answer == 0){
//            answer = 10;
//        }

        return answer;
    }
}

