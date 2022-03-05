package SWM.codingTest1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class num5 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        //처음 들어가는 수 2개
        list.add(sc.nextInt());
        list.add(sc.nextInt());
        int plusCase = sc.nextInt();
        String[] answer = new String[plusCase];
        for (int i=1; i<=plusCase; i++) {
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            list.add(sc.nextInt());
            Collections.sort(list);
            answer[i-1] = list.get(i) + " " + list.get(2*i+1);
        }
        for (int i=0; i<plusCase; i++) {
            if (i==plusCase-1) {
                System.out.print(answer[i]);
            }
            else {
                System.out.println(answer[i]);
            }
        }
    }
}
