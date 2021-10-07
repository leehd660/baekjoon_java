package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class 요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        String[] strArr = numStr.split(" ");
        int num = Integer.parseInt(strArr[0]);
        int k = Integer.parseInt(strArr[1]);
        List<Integer> people = new ArrayList<>();
        for (int i=1; i<num+1; i++){
            people.add(i);
        }
        bw.write("<");
        int i = 0;
        while (true) {
            if (people.size()==0){
                break;
            }
            else if (people.size()==1){
                bw.write(people.get(0)+">");
                people.remove(0);
            }
            else if ((i+1)%k==0){
                bw.write(people.get(0)+", ");
                people.remove(0);
            }
            else {
                people.add(people.get(0));
                people.remove(0);
            }
            i++;
        }
        bw.close();
    }
}
