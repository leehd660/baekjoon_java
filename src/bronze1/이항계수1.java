package bronze1;

import java.util.Scanner;

public class 이항계수1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a= scanner.nextInt();
        int b= scanner.nextInt();
        int aF = 1;
        int bF = 1;
        int abF = 1;
        for (int i=a; i>=1; i--){
            aF = aF*i;
        }
        for (int i=b; i>=1; i--){
            bF = bF*i;
        }
        for (int i=a-b; i>=1; i--){
            abF = abF*i;
        }
        int answer = aF/(bF*abF);
        System.out.println(answer);;
    }
}
