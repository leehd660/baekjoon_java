package bronze1;

import java.util.Scanner;

public class 뒤집힌덧셈 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        scanner.close();
        String c = Integer.toString(reverseNum(a) + reverseNum(b));
        System.out.println(reverseNum(c));
    }
    public static int reverseNum(String n){
        String answer ="";
        String[] nArr = n.split("");
        for (int i=0; i<nArr.length; i++){
            answer += nArr[nArr.length-1-i];
        }
        return Integer.parseInt(answer);
    }
}
