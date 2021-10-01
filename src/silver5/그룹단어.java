package silver5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 그룹단어 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;

        for (int i=0; i<num; i++){
            String word = scanner.next();
            boolean answer = true;
            List<String> containArr = new ArrayList<>();
            String beforeW = "";
            for (String s : word.split("")){
                if (!containArr.contains(s)){
                    containArr.add(s);
                }
                else if (containArr.contains(s) && !beforeW.equals(s)){
                    answer = false;
                    break;
                }
                beforeW = s;
            }
            if (answer == true){
                count++;
            }
        }
        System.out.println(count);
    }
}
