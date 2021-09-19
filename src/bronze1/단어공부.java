package bronze1;

import java.util.*;

public class 단어공부 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        word = word.toUpperCase(Locale.ROOT);
        Map<String, Integer> map = new HashMap<>();
        for (String s : word.split("")){
            if (map.containsKey(s)){
                map.put(s,map.get(s)+1);
            }
            else {
                map.put(s,1);
            }

        }
        int compare = 0;
        String answer = "";
        for (String s : map.keySet()){
            if (compare<map.get(s)){
                compare = map.get(s);
                answer = s;
            }
//            else if (compare == map.get(s)){
//                answer = "?";
//                break;
//            }
        }
        int count =0;
        for (String s: map.keySet()){
            if (compare == map.get(s)){
                count++;
            }
        }
        if (count >1){
            answer="?";
        }
        System.out.println(answer);
    }
}
