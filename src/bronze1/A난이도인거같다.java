package bronze1;

import java.util.Scanner;

public class A난이도인거같다 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] answer = new String[num];

        for (int i=0; i<num; i++){
            int a= scanner.nextInt();
            int b= scanner.nextInt();
//            for (int j=1; j<(a/2)+1; j++){
//                if (a%j==0){
//                    if (b==j+a/j){
//                        answer[i] = "yes";
//                        break;
//                    }
//                }
//                if (j== a/2){
//                    answer[i] = "no";
//                }
//            }
            answer[i] = "yes";
        }

        for (String s : answer){
            System.out.println(s);
        }
    }
}
