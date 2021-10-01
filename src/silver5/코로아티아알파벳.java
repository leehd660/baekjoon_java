package silver5;

import java.util.Scanner;

public class 코로아티아알파벳 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.next();
        scanner.close();
        String[] wordArr = sentence.split("");
        int count =0;
        for(int i=0; i< wordArr.length; i++){
            if (wordArr[i].equals("c")&& i<=wordArr.length-2){
                if (wordArr[i+1].equals("=")){
                    count++;
                    i++;
                    continue;
                }
                else if (wordArr[i+1].equals("-")){
                    count++;
                    i++;
                    continue;
                }
                count++;
                continue;
            }
            else if (wordArr[i].equals("d")&& i<=wordArr.length-3) {
                if (wordArr[i + 1].equals("z") && i <= wordArr.length - 3) {
                    if (wordArr[i + 2].equals("=") && i <= wordArr.length - 3) {
                        count++;
                        i += 2;
                        continue;
                    } else {
                        count++;
                        continue;
                    }
                }
                else if (wordArr[i+1].equals("-")&& i<=wordArr.length-2){
                    count++;
                    i++;
                    continue;
                }
                count++;
                continue;
            }
            else if (wordArr[i].equals("d")&& i<=wordArr.length-2) {
                if (wordArr[i+1].equals("-")&& i<=wordArr.length-2){
                    count++;
                    i++;
                    continue;
                }
                count++;
                continue;
            }
            else if (wordArr[i].equals("l")&& i<=wordArr.length-2){
                if (wordArr[i+1].equals("j")){
                    count++;
                    i++;
                    continue;
                }
                count++;
                continue;
            }
            else if (wordArr[i].equals("n")&& i<=wordArr.length-2){
                if (wordArr[i+1].equals("j")){
                    count++;
                    i++;
                    continue;
                }
                count++;
                continue;
            }
            else if (wordArr[i].equals("s")&& i<=wordArr.length-2){
                if (wordArr[i+1].equals("=")){
                    count++;
                    i++;
                    continue;
                }
                count++;
                continue;
            }
            else if (wordArr[i].equals("z")&& i<=wordArr.length-2){
                if (wordArr[i+1].equals("=")){
                    count++;
                    i++;
                    continue;
                }
                count++;
                continue;
            }
            else {
                count++;
                continue;
            }
        }
        System.out.println(count);
    }
}
