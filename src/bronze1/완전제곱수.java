package bronze1;

import java.util.Scanner;

public class 완전제곱수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int total = 0;
        int min = 0;
        int b = (int)Math.floor(Math.sqrt(n));
        int a = (int)Math.ceil(Math.sqrt(m));
        for (int i = a; i<=b; i++){
            total += Math.pow(i,2);
            if (min==0){
                min =(int)Math.pow(i,2);
            }
        }
        if (total ==0){
            System.out.println(-1);
        }
        else{
            System.out.println(total);
            System.out.println(min);
        }
    }
}
