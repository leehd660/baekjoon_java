package silver3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S3_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        int count =0;
//        while(num!=1){
//            if (num%3 == 1) {
//                num--;
//                count++;
//                num = num/3;
//            }
//            else if (num%3 == 0) {
//                num = num/3;
//            }
//            else if (num%2 ==2) {
//                num = num/2;
//            }
//            else {
//                num --;
//            }
//            count++;
//        }
        List<List> table = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(num);
        table.add(first);
        while (!table.get(table.size()-1).contains(1)){
            count++;
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<table.get(table.size()-1).size(); i++) {
                int n = (int) table.get(table.size()-1).get(i);
                if (n%2 == 0) {
                    list.add(n/2);
                }
                if (n%3 == 0){
                    list.add(n/3);
                }
                list.add(n-1);
            }
//            for (int k : list){
//                bw.write(String.valueOf(k));
//                bw.write("\n");
//            }
            table.add(list);
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
