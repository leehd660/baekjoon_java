package silver4;

import java.io.*;

public class S4_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = bf.readLine();
        String findWord = bf.readLine();
        int count = 0;
        for (int i=0; i<(word.length()-findWord.length()+1); i++) {
            String compareWord = word.substring(i,i+findWord.length());
            if (compareWord.equals(findWord)) {
                i += findWord.length()-1;
                count++;
            }
            else{
                continue;
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }
}
