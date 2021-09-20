package bronze1;

import java.util.Scanner;

public class 분수찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long i = scanner.nextLong();
        long count = 1;
        long a = 0;
        long b = 0;
        while (true){
            if (i-count <= 0){
                if (count%2 ==0) {
                    long total = count + 1;
                    a = i;
                    b = total - i;
                    break;
                }
                else {
                    long total = count +1;
                    a=total -i;
                    b=i;
                    break;
                }
            }
            else {
                i -= count;
                count++;
            }
        }
        System.out.println(a + "/" + b);
    }
}
