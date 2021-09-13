package bronze3;

import java.util.Scanner;

public class 꼬리를무는숫자나열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        int a_x =0;
        int a_y =0;
        int b_x =0;
        int b_y =0;

        if (a%4==0){
            a_x = (a/4)-1;
            a_y = 4;
        }
        else {
            a_x = (a / 4);
            a_y = a % 4;
        }
        if (b%4==0){
            b_x = (b/4)-1;
            b_y = 4;
        }
        else {
            b_x = (b / 4);
            b_y = b % 4;
        }
        int answer = Math.abs(a_x - b_x) + Math.abs(a_y - b_y);
        System.out.println(answer);
    }
}
