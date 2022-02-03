package silver1;

import java.io.*;
import java.util.StringTokenizer;

public class S1_11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(bf.readLine());
        StringTokenizer cardToken = new StringTokenizer(bf.readLine());
        int[] price = new int[num+1];
        for (int i=1; i<=num; i++) {
            price[i] = Integer.parseInt(cardToken.nextToken());
        }
//        int[] dp = new int[num+1];
//        dp[1] = price[1];
        for (int i=2; i<num+1; i++) {
            for (int j=1; j<=(i/2)+1; j++) {
                price[i] = Math.max(price[i], price[j]+price[i-j]);
            }
        }
        bw.write(String.valueOf(price[num]));
        bw.close();
    }
}

//    가장 처음 DFS방법으로 문제를 해결했지만, 시간초과가 발생함.

//    private static int num;
//    private static int answer;
//    private static int[] card;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        num = Integer.parseInt(bf.readLine());
//        StringTokenizer cardDeck = new StringTokenizer(bf.readLine());
//        card = new int[num];
//        for (int i=0; i<num; i++) {
//            card[i] = Integer.parseInt(cardDeck.nextToken());
//        }
//        List<Integer> list = new ArrayList<>();
//        answer = 0;
//        for (int i=0; i<num; i++) {
////            list.add(card[i]);
//            DFS(i+1, card[i]);
////            list.remove(list.size()-1);
//        }
//        bw.write(String.valueOf(answer));
//        bw.close();
//    }
//
//    static void DFS (int cardNum, int price) {
//        if (cardNum == num) {
////            int totalPrice = 0;
////            for (int price : list) {
////                totalPrice += price;
////            }
//            answer = Math.max(answer, price);
//        }
//        else {
//            for (int i=0; i<num; i++) {
//                if (cardNum+i+1 > num) break;
//                else {
////                    list.add(card[i]);
//                    DFS(cardNum+i+1, price+card[i]);
////                    list.remove(list.size()-1);
//                }
//            }
//        }
//    }

