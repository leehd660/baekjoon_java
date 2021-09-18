package bronze1;

import java.util.Scanner;

public class 적어도대부분의배수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num1 = scanner.nextLong();
        long num2 = scanner.nextLong();
        long num3 = scanner.nextLong();
        long num4 = scanner.nextLong();
        long num5 = scanner.nextLong();
        scanner.close();

        Long minNum = Math.min(num5,Math.min(Math.min(num1,num2),Math.min(num3,num4)));
        Long addNum = minNum;

        while (true) {
            int count =0;
            if (minNum%num1 ==0){
                count ++;
            }
            if (minNum%num2 ==0){
                count ++;
            }
            if (minNum%num3 ==0){
                count ++;
            }
            if (minNum%num4 ==0){
                count ++;
            }
            if (minNum%num5 ==0){
                count ++;
            }
            if (count >= 3) {
                break;
            }
            else {
                minNum += addNum;
            }
        }
        System.out.println(minNum);
    }
}
