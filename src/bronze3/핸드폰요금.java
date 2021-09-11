package bronze3;

import java.util.Scanner;

public class 핸드폰요금 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int costY = 0;
        int costM = 0;
        for (int i=0; i<n; i++){
            int useTime = scanner.nextInt();
            costM += ((useTime/60)+1)*15;
            costY += ((useTime/30)+1)*10;
        }

        if (costY==costM) {
            System.out.println("Y M "+costM);
        }
        else if (costY>costM) {
            System.out.println("M "+costM);
        }
        else {
            System.out.println("Y "+costY);
        }
    }
}
