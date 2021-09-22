package bronze1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 팰린드롬수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> answer = new ArrayList<>();
        while (true) {
            String pelindrome = "yes";
            String word = scanner.next();
            if (word.equals("0")){
                break;
            }
            else {
                String[] wordArr = word.split("");
                for (int i=0; i<wordArr.length/2; i++){
                    if (!wordArr[i].equals(wordArr[wordArr.length-1-i])){
                        pelindrome = "no";
                        break;
                    }
                }
                answer.add(pelindrome);
            }
        }
        for (String s : answer){
            System.out.println(s);
        }
    }
}
