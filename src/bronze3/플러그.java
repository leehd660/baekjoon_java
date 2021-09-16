package bronze3;

import java.util.Scanner;

public class 플러그 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plugNum = scanner.nextInt();
        int ableNum = 1;

        for (int i=0; i<plugNum; i++){
            int num = scanner.nextInt();
            ableNum = ableNum+num-1;
        }
        System.out.println(ableNum);
    }
}
