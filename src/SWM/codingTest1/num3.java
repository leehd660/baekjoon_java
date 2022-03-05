package SWM.codingTest1;

import java.util.Scanner;

public class num3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //a와 b 구하기
        int a = sc.nextInt();
        int b = sc.nextInt();
        String word = sc.next();
        String answer = "";
        String[] wordArr = word.split("");
        for (String s : wordArr) {
            for (int i=0; i<26; i++) {
//                System.out.println(Character.toString(i+(char)'a'));
                int w = (a*(int)(Character.toString(i+(char)'a').charAt(0)-(char)'a')+b)%26;
//                System.out.println((int)s.charAt(0) + "gg");
                if (w == (int)(s.charAt(0)-(char)'a')) {
                    answer += Character.toString(i+(char)'a');
                    break;
                }
            }
//            int w = (a*(s.charAt(0)-(char)'a')+b)%b;
//            answer += Character.toString(w+(char)'a');
        }
        System.out.print(answer);
    }
}
