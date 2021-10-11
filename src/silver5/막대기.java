package silver5;

import java.util.Scanner;

public class 막대기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int want = scanner.nextInt();
        int answer =0;
        for (int i=6; i>=0; i--) {
            if ((int)(want/Math.pow(2,i)) != 0){
                answer += want/Math.pow(2,i);
                want = want - (int)((int)(want/Math.pow(2,i))*Math.pow(2,i));
            }
            else {
                continue;
            }
        }
        System.out.println(answer);
    }
}
