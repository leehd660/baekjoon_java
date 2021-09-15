package bronze3;

import java.util.Scanner;

public class 오각형오각형 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        scanner.close();
        long answer = 5;
        if (num == 1){
            System.out.println(answer);
        }
        else {
            for (long n = 2; n < num + 1; n++) {
                answer = (answer+(n*5)-((n*2)-1))%45678;
            }
            System.out.println(answer);
        }
    }
}
