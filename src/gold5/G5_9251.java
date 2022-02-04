package gold5;

import java.io.*;

public class G5_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word1 = bf.readLine();
        String[] word1Arr = word1.split("");
        String word2 = bf.readLine();
        String[] word2Arr = word2.split("");
        int[][] dp = new int[word1Arr.length][word2Arr.length];
        if (word1Arr[0].equals(word2Arr[0])) {
            dp[0][0] = 1;
        }
        else {
            dp[0][0] = 0;
        }
        for (int i=1; i<word1Arr.length; i++) {
            if (word1Arr[i].equals(word2Arr[0])) {
                if (dp[i-1][0] == 0) {
                    dp[i][0] = 1;
                }
                else {
                    dp[i][0] = 1;
                }
            }
            else {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i=1; i<word2Arr.length; i++) {
            if (word2Arr[i].equals(word1Arr[0])) {
                if (dp[0][i-1] == 0) {
                    dp[0][i] = 1;
                }
                else {
                    dp[0][i] = dp[0][i-1];
                }
            }
            else {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i=1; i<word1Arr.length; i++) {
            for (int j=1; j<word2Arr.length; j++) {
                if (word1Arr[i].equals(word2Arr[j])) {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        bw.write(String.valueOf(dp[word1Arr.length-1][word2Arr.length-1]));
        bw.close();
    }
}

// 확실히 골드부터는 새로운 알고리즘이 나타나는거 같음.. LCS공부하고 다시 풀이

//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String word1 = bf.readLine();
//        String[] word1Arr = word1.split("");
//        String word2 = bf.readLine();
//        String[] word2Arr = word2.split("");
//        //len은 그 글자로 끝날 수 있는 최대의 길이
//        //index는 최대 길이일 때, word2에서 그 글자의 위치(-1이면 없는거)
//        int[] len = new int[word1.length()];
//        int[] index = new int[word1.length()];
//        int answer = 0;
//        for (int i=0; i<word1.length(); i++) {
//            if (i==0) {
//                if (word2.contains(word1Arr[i])) {
//                    len[i] = 1;
//                    index[i] = word2.indexOf(word1Arr[i]);
//                }
//                else {
//                    len[i] = 0;
//                    index[i] = -1;
//                }
//            }
//            else {
//                if (word2.contains(word1Arr[i])) {
//                    for (int j=i-1; j>=0; j--) {
//                        if (-1 == word2.indexOf(word1Arr[i], index[j]+1)) {
//                            continue;
//                        }
//                        else {
//                            if (len[j]+1 > len[i]) {
//                                len[i] = len[j]+1;
//                                index[i] = word2.indexOf(word1Arr[i], index[j]+1);
//                            }
//                            else if (len[j]+1 == len[i]){
//                                if (index[i] != -1) {
//                                    index[i] = Math.min(index[i], word2.indexOf(word1Arr[i], index[j] + 1));
//                                }
//                                else {
//                                    index[i] = word2.indexOf(word1Arr[i], index[j] + 1);
//                                }
//                            }
//                        }
//                    }
//                    if (len[i]==0) {
//                        len[i] = 1;
//                        index[i] = word2.indexOf(word1Arr[i]);
//                    }
//                }
//                else {
//                    len[i] = 0;
//                    index[i] = -1;
//                }
//            }
//            answer = Math.max(answer, len[i]);
//        }
//        bw.write(String.valueOf(answer));
//        bw.close();
//    }
//}
