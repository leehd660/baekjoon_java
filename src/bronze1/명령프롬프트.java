package bronze1;

import java.util.Scanner;

public class 명령프롬프트 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String findStr = scanner.next();
        String[] answerArr = findStr.split("");
        String answer = "";

        for (int i=0; i<num-1; i++) {
            String[] str = scanner.next().split("");
            for (int j=0; j<answerArr.length; j++){
                if (answerArr[j].equals(str[j])){
                    continue;
                }
                else {
                    answerArr[j] = "?";
                }
            }
        }
        for (String s:answerArr){
            answer += s;
        }
        System.out.println(answer);
    }
}
