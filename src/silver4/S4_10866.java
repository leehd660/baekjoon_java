package silver4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class S4_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Deque<Integer> arr = new ArrayDeque<>();
        for (int i=0; i<num; i++){
            String a = "push_front";
            String b = "push_back";
            String c = "pop_front";
            String d = "pop_back";
            String e = "size";
            String f = "empty";
            String g = "front";
            String h = "back";
            String instruction = bf.readLine();
            String[] instArr = instruction.split(" ");
            if (instArr.length>1){
                if (instArr[0].equals(a)){
                    arr.addFirst(Integer.parseInt(instArr[1]));
                }
                else {
                    arr.addLast(Integer.parseInt(instArr[1]));
                }
            }
            else {
                if (instArr[0].equals(e)) {
                    bw.write(String.valueOf(arr.size()));
                    bw.write("\n");
                }
                else if (instArr[0].equals(f)) {
                    if (arr.size()==0){
                        bw.write("1\n");
                    }
                    else {
                        bw.write("0\n");
                    }
                }
                else {
                    if (arr.size()==0) {
                        bw.write("-1\n");
                    }
                    else {
                        if (instArr[0].equals(c)) {
                            bw.write(String.valueOf(arr.getFirst()));
                            bw.write("\n");
                            arr.removeFirst();
                        }
                        else if (instArr[0].equals(d)){
                            bw.write(String.valueOf(arr.getLast()));
                            bw.write("\n");
                            arr.removeLast();
                        }
                        else if (instArr[0].equals(g)){
                            bw.write(String.valueOf(arr.getFirst()));
                            bw.write("\n");
                        }
                        else if (instArr[0].equals(h)){
                            bw.write(String.valueOf(arr.getLast()));
                            bw.write("\n");
                        }
                    }
                }
            }
        }
        bw.close();
    }
}
