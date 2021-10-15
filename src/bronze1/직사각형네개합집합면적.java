package bronze1;

import java.util.Scanner;

public class 직사각형네개합집합면적 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int answer = 0;
        boolean[][] table = new boolean[100][100];
        for (int i=0; i<4; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            for (int x=a; x<c; x++){
                for (int y=b; y<d; y++){
                    table[x][y] = true;
                }
            }
        }
        for (int i=0; i<100; i++){
            for (int j=0; j<100; j++){
                if (table[i][j]){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
