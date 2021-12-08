package silver5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class S5_5568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String cardNumStr = bf.readLine();
        int cardNum = Integer.parseInt(cardNumStr);
        String kStr = bf.readLine();
        int k = Integer.parseInt(kStr);
        String[] cardDeck = new String[cardNum];
        for (int i=0; i<cardNum; i++) {
            String card = bf.readLine();
            cardDeck[i] = card;
        }
        Set<String> cardSet = new HashSet<>();
        if (k == 2) {
            for (int i=0; i<cardNum; i++){
                for (int j=0; j<cardNum; j++){
                    if (i==j) {
                        continue;
                    }
                    else {
                        String makeCard = cardDeck[i]+cardDeck[j];
                        cardSet.add(makeCard);
                    }
                }
            }
        }
        else if (k == 3){
            for (int m=0; m<cardNum; m++){
                for (int i=0; i<cardNum; i++) {
                    for (int j = 0; j < cardNum; j++) {
                        if (i == j || i==m || m==j) {
                            continue;
                        } else {
                            String makeCard = cardDeck[m] + cardDeck[i] + cardDeck[j];
                            cardSet.add(makeCard);
                        }
                    }
                }
            }
        }
        else if (k == 4){
            for (int n=0; n<cardNum; n++) {
                for (int m = 0; m < cardNum; m++) {
                    for (int i = 0; i < cardNum; i++) {
                        for (int j = 0; j < cardNum; j++) {
                            if ( i == j || i == m || m == j || i==n || j==n || n==m ) {
                                continue;
                            } else {
                                String makeCard = cardDeck[n] + cardDeck[m] + cardDeck[i] + cardDeck[j];
                                cardSet.add(makeCard);
                            }
                        }
                    }
                }
            }
        }
        int answer = cardSet.size();
        bw.write(String.valueOf(answer));
        bw.close();
    }
}
