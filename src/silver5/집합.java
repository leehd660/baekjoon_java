package silver5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class 집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> set = new HashSet<>();
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        for (int i=0; i<num; i++){
            String str = bf.readLine();
            String[] arr = str.split(" ");
            if (arr[0].equals("add")){
                set.add(arr[1]);
            }
            else if (arr[0].equals("remove")){
                set.remove(arr[1]);
            }
            else if (arr[0].equals("check")){
                if (set.contains(arr[1])){
                    bw.write(String.valueOf(1)+'\n');
                }
                else{
                    bw.write(String.valueOf(0) + '\n');
                }
            }
            else if (arr[0].equals("toggle")){
                if (set.contains(arr[1])){
                    set.remove(arr[1]);
                }
                else{
                    set.add(arr[1]);
                }
            }
            else if (arr[0].equals("all")){
                for (int j=1; j<=20; j++){
                    set.add(String.valueOf(j));
                }
            }
            else if (arr[0].equals("empty")){
                set.clear();
            }
        }
        bw.close();
    }
}
