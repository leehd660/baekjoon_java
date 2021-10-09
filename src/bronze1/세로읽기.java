package bronze1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<List<String>> outArr = new ArrayList<>();
        int bigLen = 0;

        for (int i=0; i<5; i++){
            List<String> inArr = new ArrayList<>();
            String str = bf.readLine();
            if (bigLen < str.length()){
                bigLen = str.length();
            }
            outArr.add(Arrays.asList(str.split("")));
        }

        String answer = "";
        for (int i=0; i<bigLen; i++){
            for (int j=0; j<5; j++){
                try {
                    answer += outArr.get(j).get(i);
                }
                catch (IndexOutOfBoundsException e){
                    continue;
                }
            }
        }
        bw.write(answer);
        bw.close();
    }
}
