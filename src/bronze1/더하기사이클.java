package bronze1;

import java.util.Scanner;

public class 더하기사이클 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int compareNum = num;
        int count = 0;

        while (true) {
            count ++;
            int a = compareNum/10;
            int b = compareNum%10;
            int c = (a+b)%10;
            compareNum = 10*b + c;
            if (compareNum==num){
                break;
            }
        }
        System.out.println(count);
    }
}
