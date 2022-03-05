package SWM2022.codingTest1;

import java.util.Scanner;

public class num1 {
    private static String[] keyWordArr;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int keyWordNum = sc.nextInt();
        String[] keyWordArr = new String[keyWordNum];
        for (int i=0; i<keyWordNum; i++) {
            keyWordArr[i] = sc.next();
        }
        int testWordNum = sc.nextInt();
        String[] testNum = new String[testWordNum];
        for (int i=0; i<testWordNum; i++) {
            testNum[i] = sc.next();
        }
        for (int i=0; i<testWordNum; i++) {
//            String testWord = sc.next();
            String testWord = testNum[i];
            String[] testWordArr = testWord.split("");
            int count =0;
            for (int test=0; test<keyWordArr.length; test++) {
                String[] keyArr = keyWordArr[test].split("");
                if (keyArr.length>=testWord.length()) {
                    boolean check = true;
                    for (int j = 0; j < testWord.length(); j++) {
                        if (testWordArr[i].equals(keyArr[i])) {
                            continue;
                        }
                        else {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
