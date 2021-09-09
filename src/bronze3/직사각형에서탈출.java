package bronze3;

import java.util.Scanner;

public class 직사각형에서탈출 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        answer = Math.min(Math.min(x-0,y),Math.min(w-x,h-y));
        System.out.println(answer);
    }
}
