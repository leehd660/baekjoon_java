package gold5;

import java.io.*;
import java.util.*;

public class G5_5430 {
    private static Deque<String> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String instruction = "";
        String[] instructArr;
        String strArr = "";
        deque = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();
        int way = 0;
        boolean check = true;
        int testNum = Integer.parseInt(bf.readLine());
        for (int test=0; test<testNum; test++) {
            instruction = bf.readLine();
            instructArr = instruction.split("");
            int size = Integer.parseInt(bf.readLine());
            strArr = bf.readLine();
            numToList(strArr, size);
            //way가 0이면, 앞에서부터, way가 1이면 뒤에서부터
            for (int i=0; i<instructArr.length; i++) {
                if (instructArr[i].equals("R")) {
                    if (way==0) {
                        way=1;
                    }
                    else {
                        way=0;
                    }
                }
                else {
                    //D이면
                    if (deque.size()==0) {
                        check = false;
                        break;
                    }
                    else {
                        if (way==0) {
                            deque.pollFirst();
                        }
                        else {
                            deque.pollLast();
                        }
                    }
                }
            }
            if (check) {
                answer.append("[");
                int len = deque.size();
                if (way == 0) {
                    for (int i = 0; i < len; i++) {
                        answer.append(deque.pollFirst());
                        if (i !=len- 1) {
                            answer.append(",");
                        }
                    }
                }
                else {
                    for (int i = 0; i < len; i++) {
                        answer.append(deque.pollLast());
                        if (i != len - 1) {
                            answer.append(",");
                        }
                    }
                }
                answer.append("]");
            }
            else {
                answer.append("error");
            }
            bw.write(String.valueOf(answer));
            bw.write("\n");
            answer.setLength(0);
            way = 0;
            check = true;
        }
        bw.close();
    }

    static void numToList(String str, int size) {
        str = str.substring(1,str.length()-1);
        StringTokenizer token = new StringTokenizer(str,",");
        for (int i=0; i<size; i++) {
            deque.add(token.nextToken());
        }
    }
}
