package gold5;

import java.io.*;
import java.util.*;

public class G5_1759 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int L;
    private static int C;
    private static List<String> vowels;
    private static String[] wordArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer LCToken = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(LCToken.nextToken());
        C = Integer.parseInt(LCToken.nextToken());
        String word = bf.readLine();
        wordArr = word.split(" ");
        Arrays.sort(wordArr);
        String[] vowelsArr = {"a","e","i","u","o"};
        vowels = Arrays.asList(vowelsArr);
        List<String> list = new ArrayList<>();
        for (int i=0; i<C; i++) {
            list.add(wordArr[i]);
            DFS(list, i);
            list.remove(list.size()-1);
        }
        bw.close();
    }

    static void DFS(List<String> list, int index) throws IOException {
        if (list.size()==L) {
            int vowelsNum = 0;
            int another = 0;
            for (String s : list) {
                if (vowels.contains(s)) {
                    vowelsNum++;
                }
                else {
                    another++;
                }
            }
            if (vowelsNum>=1 && another>=2) {
                for (String s : list) {
                    bw.write(s);
                }
                bw.write("\n");
            }
        }
        else {
            for (int i=index+1; i<C; i++) {
                list.add(wordArr[i]);
                DFS(list, i);
                list.remove(list.size()-1);
            }
        }
    }
}
