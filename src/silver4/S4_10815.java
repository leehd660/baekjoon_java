package silver4;

import java.io.IOException;
import java.util.*;

public class S4_10815 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<num1; i++) {
            int n = scanner.nextInt();
            set.add(n);
        }
        int num2 = scanner.nextInt();
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<num2; i++) {
            int n = scanner.nextInt();
            if (set.contains(n)) {
                answer.add(1);
            }
            else {
                answer.add(0);
            }
        }
        for (int i:answer) {
            System.out.print(i + " ");
        }
    }
}
