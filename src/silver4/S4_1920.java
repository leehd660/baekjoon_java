package silver4;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class S4_1920 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numSet = scanner.nextInt();
        Set<Integer> set = new HashSet();
        for (int i=0; i<numSet; i++) {
            int n = scanner.nextInt();
            set.add(n);
        }
        int testNum = scanner.nextInt();
        int[] answer = new int[testNum];
        for (int i=0; i<testNum; i++) {
            int testN = scanner.nextInt();
            if (set.contains(testN)){
                answer[i] = 1;
            }
            else {
                answer[i] = 0;
            }
        }
        for (int i : answer){
            System.out.println(i);
        }
    }
}
