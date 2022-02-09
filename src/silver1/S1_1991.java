package silver1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class S1_1991 {
    private static String[][] connect;
    private static String preAnswer;
    private static String inAnswer;
    private static String postAnswer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int nodeNum = Integer.parseInt(bf.readLine());
        connect = new String[nodeNum][3];
        for (int i=0; i<nodeNum; i++) {
            StringTokenizer nodeToken = new StringTokenizer(bf.readLine());
            connect[i][0] = nodeToken.nextToken();
            connect[i][1] = nodeToken.nextToken();
            connect[i][2] = nodeToken.nextToken();
        }
        Arrays.sort(connect, Comparator.comparing(ol->ol[0]));
        preAnswer = "";
        inAnswer = "";
        postAnswer = "";
        Pre_order(0);
        In_order(0);
        Post_order(0);
        bw.write(preAnswer+"\n");
        bw.write(inAnswer+"\n");
        bw.write(postAnswer+"\n");
        bw.close();
    }
    static void Pre_order(int headIndex) {
        preAnswer += connect[headIndex][0];
        if (!connect[headIndex][1].equals(".")) {
            Pre_order((int)connect[headIndex][1].charAt(0)-65);
        }
        if (!connect[headIndex][2].equals(".")) {
            Pre_order((int)connect[headIndex][2].charAt(0)-65);
        }
    }
    static void In_order(int headIndex) {
        if (!connect[headIndex][1].equals(".")) {
            In_order((int)connect[headIndex][1].charAt(0)-65);
        }
        inAnswer += connect[headIndex][0];
        if (!connect[headIndex][2].equals(".")) {
            In_order((int)connect[headIndex][2].charAt(0)-65);
        }
    }
    static void Post_order(int headIndex) {
        if (!connect[headIndex][1].equals(".")) {
            Post_order((int)connect[headIndex][1].charAt(0)-65);
        }
        if (!connect[headIndex][2].equals(".")) {
            Post_order((int)connect[headIndex][2].charAt(0)-65);
        }
        postAnswer += connect[headIndex][0];
    }
}
