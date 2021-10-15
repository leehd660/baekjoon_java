package silver5;

import java.util.Scanner;

public class 돌게임 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int n3 = num/3;
        int n1 = num - 3*n3;
        if ((n3+n1)%2 == 0){
            System.out.println("CY");
        }
        else {
            System.out.println("SK");
        }
    }
}
