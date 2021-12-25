package silver3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class S3_2606 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String allComputerNum = bf.readLine();
//        String numStr = bf.readLine();
//        int num = Integer.parseInt(numStr);
//        List<Set<String>> network = new ArrayList<>();
//        for (int i=0; i<num; i++){
//            String pairNetworkStr = bf.readLine();
//            String[] pairNet = pairNetworkStr.split(" ");
//            boolean test = false;
//            int overlap = 0;
//            int keepNum = 0;
//            Set<String> overlapSet = new HashSet<>();
//            for (int j=0; j<network.size(); j++){
//                if ((network.get(j).contains(pairNet[0]) || network.get(j).contains(pairNet[1])) && overlap==0){
//                    network.get(j).add(pairNet[0]);
//                    network.get(j).add(pairNet[1]);
//                    test = true;
//                    overlap=1;
//                    overlapSet = network.get(j);
//                    keepNum = j;
//                }
//                else if ((network.get(j).contains(pairNet[0]) || network.get(j).contains(pairNet[1])) && overlap==1) {
//                    for (Object str : network.get(j).toArray()){
//                        overlapSet.add(String.valueOf(str));
//                    }
//                    network.remove(network.get(j));
//                    network.remove(network.get(keepNum));
//                    network.add(overlapSet);
//                }
//            }
//            if (!test) {
//                Set<String> set = new HashSet<>();
//                set.add(pairNet[0]);
//                set.add(pairNet[1]);
//                network.add(set);
//            }
//        }
//        for (int i=0; i<network.size(); i++){
//            for (Object str : network.get(i)){
//                bw.write(String.valueOf(str)+"\n");
//            }
//            bw.write("ss\n");
//        }
//        int answer = 0;
//        for (Set s : network) {
//            if (s.contains("1")){
//                answer = s.size()-1;
//                break;
//            }
//        }
//        bw.write(String.valueOf(answer));
//        bw.close();
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String allComputerNum = bf.readLine();
//        String numStr = bf.readLine();
//        int num = Integer.parseInt(numStr);
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i=0; i<num; i++) {
//            String net = bf.readLine();
//            String[] netArr = net.split(" ");
//            int a = Integer.parseInt(netArr[0]);
//            int b = Integer.parseInt(netArr[1]);
//            if (map.keySet().contains(a)){
//                map.get(a).add(b);
//            }
//            else {
//                List<Integer> list = new ArrayList<>();
//                list.add(b);
//                map.put(a,list);
//            }
//            if (map.keySet().contains(b)){
//                map.get(b).add(a);
//            }
//            else {
//                List<Integer> list = new ArrayList<>();
//                list.add(a);
//                map.put(b,list);
//            }
//        }
//        boolean[] vst = new boolean[Integer.parseInt(allComputerNum)+1];
//        Queue<Integer> queue = new ArrayDeque<>();
//        queue.add(1);
//        vst[1] = true;
//
//    }

    // 12월 25일 재도전
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int comNum = Integer.parseInt(bf.readLine());
        int pairCom = Integer.parseInt(bf.readLine());
//        List<Integer> inner = new ArrayList<>();
        List[] table = new List[comNum+1];
        for (int i=0; i<comNum+1; i++) {
            List<Integer> inner = new ArrayList<>();
            table[i] = inner;
        }
        for (int i=0; i<pairCom; i++) {
            String pair = bf.readLine();
            String[] pairArr = pair.split(" ");
            int com1 = Integer.parseInt(pairArr[0]);
            int com2 = Integer.parseInt(pairArr[1]);
            if (!table[com1].contains(com2)) {
                table[com1].add(com2);
            }
            if (!table[com2].contains(com1)) {
                table[com2].add(com1);
            }
        }
        boolean[] check = new boolean[comNum+1];
        Deque<Integer> deque = new ArrayDeque<>();
        checkFuntion(1, deque, table, check);
        while (!deque.isEmpty()) {
            int num = deque.pollFirst();
            checkFuntion(num, deque, table, check);
        }
        int answerCount = 0;
        for (int i=0; i<comNum+1; i++) {
            if (check[i]) {
                answerCount++;
            }
        }
        bw.write(String.valueOf(answerCount-1));
        bw.close();
    }

    static void checkFuntion (int num, Deque deque, List[] table, boolean[] check) {
        for (int i=0; i<table[num].size(); i++) {
            int testNum = (int) table[num].get(i);
            if (!check[testNum]){
                check[testNum] = true;
                deque.add(testNum);
            }
        }
    }
}
