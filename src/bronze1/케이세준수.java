package bronze1;

import java.util.Scanner;

public class 케이세준수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.close();
        int answer = k-1;

        for (int i=k+1; i<num+1; i++){
            if (i%2==0){
                if (i/2<=k){
                    answer++;
                    System.out.println(i+"gg");
                }
                continue;
            }
            else {
                if (Math.sqrt(i)<k){
                    answer++;
                    System.out.println(i+"gg");
                    continue;
                }
                else {
                    for (int j = 3; j <= Math.sqrt(num) + 1; j += 2) {
                        if (i % j == 0) {
                            if (i / j <= k) {
                                answer++;
                                System.out.println(i + "gg");
                            }
                            continue;
                        }
                        if (j==(int)(Math.sqrt(num)+1) || j==(int)(Math.sqrt(num)+1)-1){
                            answer++;
                            System.out.println(i+"gg");
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
