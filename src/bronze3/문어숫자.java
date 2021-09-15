package bronze3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 문어숫자 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> answerList = new ArrayList<>();

        while (true) {
            long answer = 0;
            String octStr = scanner.next();
            if (octStr.equals("#")){
                break;
            }
            else {
                int a = 0;
                for (int i=0; i<octStr.length(); i++){
                    switch (octStr.substring(i,i+1)){
                        case "-": a=0; break;
                        case "\\": a=1; break;
                        case "(": a=2; break;
                        case "@": a=3; break;
                        case "?": a=4; break;
                        case ">": a=5; break;
                        case "&": a=6; break;
                        case "%": a=7; break;
                        case "/": a=-1; break;
                    }
                    answer += a*(Math.pow(8,(octStr.length()-1-i)));
                }
            }
            answerList.add(answer);
        }
        for (long i : answerList){
            System.out.println(i);
        }
    }
}
