package bronze1;

import java.util.Scanner;

public class 유진수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        scanner.close();
        String answer = "YES";

        if (num.length()==1){
            answer = "NO";
        }
        else {
            for (int i = 1; i < num.length(); i++) {
                String num1 = num.substring(0, i);
                String num2 = num.substring(i, num.length());
                int value1 = 1;
                int value2 = 1;
                System.out.println(num1 + "gg" + num2 + "gg");
                for (String s : num1.split("")) {
                    value1 = value1 * Integer.parseInt(s);
                }
                for (String s : num2.split("")) {
                    value2 = value2 * Integer.parseInt(s);
                }
                System.out.println(value1 + "hh" + value2);
                if (value1 == value2) {
                    break;
                }
                if (i == num.length() - 1) {
                    answer = "NO";
                }
            }
        }
        System.out.println(answer);
    }
}
