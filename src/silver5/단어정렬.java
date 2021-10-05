package silver5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
//        List<String> arr = new ArrayList<>();
        List<String> wordArr = new ArrayList<>();
        List<Word> arr = new ArrayList<>();
        Checker checker = new Checker();

        for (int i=0; i<num; i++){
            String word = bf.readLine();
            if (wordArr.contains(word)){
                continue;
            }
            else{
                arr.add(new Word(word));
                wordArr.add(word);
            }
        }
//        for (int i=0; i<arr.size(); i++){
//            for (int j=0; j<arr.size(); j++){
//                String first = arr.get(i);
//                String second = arr.get(j);
//                if (i==j){
//                    continue;
//                }
//                else if (i<j){
//                    if (first.length()>second.length()){
//                        arr.set(i,second);
//                        arr.set(j,first);
//                    }
//                    else if (first.length()<second.length()){
//                        continue;
//                    }
//                    else {
//                        if (first.compareTo(second) >0){
//                            arr.set(i,second);
//                            arr.set(j,first);
//                        }
//                    }
//                }
//                else {
//                    if (first.length()>second.length()){
//                        arr.set(j,second);
//                        arr.set(i,first);
//                    }
//                    else if (first.length()<second.length()){
//                        continue;
//                    }
//                    else {
//                        if (first.compareTo(second) >0){
//                            arr.set(j,second);
//                            arr.set(i,first);
//                        }
//                    }
//                }
//            }
//        }
        Collections.sort(arr,checker);
        for (Word s : arr){
            bw.write(s.word+'\n');
        }
        bw.close();
    }

}

class Checker implements Comparator<Word> {
    @Override
    public int compare(Word a, Word b) {
        int answer = -1;
        if (a.word.length()>b.word.length()){
            answer = 1;
        }
        else if (a.word.length()==b.word.length()){
            if (a.word.compareTo(b.word)>0){
                answer = 1;
            }
            else {
                answer = -1;
            }
        }
        return answer;
    }
}

class Word {
    String word;

    Word(String word) {
        this.word = word;
    }
}