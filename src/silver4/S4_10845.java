package silver4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S4_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        List<Integer> table = new ArrayList<>();
        for (int i=0; i<num; i++){
            String instru = bf.readLine();
            String[] arr = instru.split(" ");
            if (arr.length==2){
                table.add(Integer.parseInt(arr[1]));
            }
            else {
                if (arr[0].equals("pop")) {
                    if (table.size()==0){
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(String.valueOf(table.get(0)));
                        bw.write("\n");
                        table.remove(0);
                    }
                }
                else if (arr[0].equals("size")) {
                    bw.write(String.valueOf(table.size()));
                    bw.write("\n");
                }
                else if (arr[0].equals("empty")) {
                    if (table.size()!=0){
                        bw.write("0\n");
                    }
                    else {
                        bw.write("1\n");
                    }
                }
                else if (arr[0].equals("front")) {
                    if (table.size()==0){
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(String.valueOf(table.get(0)));
                        bw.write("\n");
                    }
                }
                else if (arr[0].equals("back")) {
                    if (table.size()==0){
                        bw.write("-1\n");
                    }
                    else {
                        bw.write(String.valueOf(table.get(table.size()-1)));
                        bw.write("\n");
                    }
                }
            }
        }
        bw.close();
    }
}
