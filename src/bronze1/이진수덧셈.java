package bronze1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 이진수덧셈 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        scanner.close();
        int countA = 0;
        int countB = 0;
        for (String s : a.split("")){
            if (s.equals("1")){
                break;
            }
            else{
                countA++;
            }
        }
        for (String s : b.split("")){
            if (s.equals("1")){
                break;
            }
            else{
                countB++;
            }
        }
        a = a.substring(countA);
        b = b.substring(countB);
        if (a.equals("")){
            a="0";
        }
        if (b.equals("")){
            b="0";
        }
        int bigLen = Math.max(a.length(),b.length());


        List<String> aArr = new ArrayList<>();
        List<String> bArr = new ArrayList<>();
        if (a.length()<bigLen){
            for (int i=0; i<bigLen-a.length(); i++){
                aArr.add("0");
            }
            for (String s : a.split("")){
                aArr.add(s);
            }
        }
        else {
            for (String s : a.split("")){
                aArr.add(s);
            }
        }
        if (b.length()<bigLen){
            for (int i=0; i<bigLen-b.length(); i++){
                bArr.add("0");
            }
            for (String s : b.split("")){
                bArr.add(s);
            }
        }
        else {
            for (String s : b.split("")){
                bArr.add(s);
            }
        }

        List<String> answer = new ArrayList<>();
        int count = 0;
        for (int i=1; i<bigLen+1; i++){
            int aNum = Integer.parseInt(aArr.get(bigLen-i));
            int bNum = Integer.parseInt(bArr.get(bigLen-i));
            int sum = aNum + bNum + count;
            count = sum/2;
            answer.add(String.valueOf(sum%2));
            if (i==bigLen && count==1){
                answer.add("1");
            }
        }

        for (int i=1; i<answer.size()+1; i++) {
            System.out.print(answer.get(answer.size()-i));
        }
    }
}
