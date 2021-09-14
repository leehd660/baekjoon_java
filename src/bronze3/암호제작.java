package bronze3;

import java.util.Scanner;

public class 암호제작 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String testCode = scanner.next();
//        int compareNum = scanner.nextInt();
//        scanner.close();
//        String answer = "";
//        if (testCode.length() > 12){
//            answer = "GOOD";
//            System.out.println(answer);
//        }
//        else {
//            long num = Long.parseLong(testCode);
//            long a = 0;
//            long b = 0;
//            if (num%2 == 0){
//                a = 2;
//            }
//            else {
//                for (long i = 3; i < Math.sqrt(num) + 1; i += 2) {
//                    if (num % i == 0) {
//                        a = i;
//                        b = num / i;
//                        break;
//                    }
//                }
//            }
//            if (a<compareNum){
//                answer = "BAD";
//                System.out.println(answer+" "+a);
//            }
//            else {
//                answer = "GOOD";
//                System.out.println(answer);
//            }
//        }
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        int k = scanner.nextInt();
        boolean answer = true;
        int n =0;
        for (int j=2; j<k+1; j++) {
            for (int i = 0; i < num.length(); i++) {
                char a = num.charAt(i);
                n = ((n * 10) + (a - '0')) % j;
            }
            if (n==0){
                answer = false;
                System.out.println("BAD "+j);
                break;
            }
            n=0;
        }
        if (answer == true){
            System.out.println("GOOD");
        }
    }
}
