package gold5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class G5_1107 {
    private static String[] chArr;
    private static int wantCh;
    private static int ableMin;
    private static String chooseNum;
    private static boolean[] check;
    private static List<String> list;

    public static void main (String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String chStr = bf.readLine();
        chArr = chStr.split("");
        wantCh = Integer.parseInt(chStr);
        check = new boolean[10];
        int wrongNum = Integer.parseInt(bf.readLine());
        list = new ArrayList<>();
        if (wrongNum!=0) {
            String wrongStr = bf.readLine();
            for (String wrongNumStr : wrongStr.split(" ")) {
                list.add(wrongNumStr);
            }
        }
        ableMin = 5000000;
        chooseNum = "";
        //숫자 누를 수 있는 것 중에 제일 근접한 수 찾기
        List<String> list = new ArrayList<>();
        DFS();
        int answer1 = ableMin+chooseNum.length();
        int answer2 = Math.abs(100-wantCh);
        bw.write(String.valueOf(Math.min(answer1, answer2)));
        bw.close();
    }
    static void DFS() {
        for (int i=0; i<=1000000; i++) {
            boolean answer = true;
            String str = String.valueOf(i);
            for (String s : list) {
                if (str.contains(s)) {
                    answer = false;
                    break;
                }
            }
            if (answer) {
                if (ableMin>Math.abs(wantCh - Integer.parseInt(str))) {
                    ableMin = Math.abs(wantCh - Integer.parseInt(str));
                    chooseNum = str;
                }
            }
        }
    }


//    static int FindMin() {
//        String minNum = "";
//        boolean minCheck = false;
//        for (int i=0; i<chArr.length; i++) {
//            if (!minCheck) {
//                int index = Integer.parseInt(chArr[i]);
//                if (!check[index]) {
//                    minNum += String.valueOf(index);
//                } else {
//                    while (check[index]) {
//                        index--;
//                    }
//                    minNum += String.valueOf(index);
//                    minCheck = true;
//                }
//            }
//            else {
//                minNum += String.valueOf(ableMax);
//            }
//        }
//        return Integer.parseInt(minNum);
//    }
//    static int FindMax() {
//        String maxNum = "";
//        boolean maxCheck = false;
//        for (int i=0; i<chArr.length; i++) {
//            if (!maxCheck) {
//                int index = Integer.parseInt(chArr[i]);
//                if (!check[index]) {
//                    maxNum += String.valueOf(index);
//                } else {
//                    while (check[index]) {
//                        index++;
//                    }
//                    maxNum += String.valueOf(index);
//                    maxCheck = true;
//                }
//            }
//            else {
//                maxNum += String.valueOf(ableMin);
//            }
//        }
//        return Integer.parseInt(maxNum);
//    }
}
