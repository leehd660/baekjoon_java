package silver3;

import java.io.*;
import java.util.*;

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
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String allComputerNum = bf.readLine();
        String numStr = bf.readLine();
        int num = Integer.parseInt(numStr);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<num; i++) {
            String net = bf.readLine();
            String[] netArr = net.split(" ");
            int a = Integer.parseInt(netArr[0]);
            int b = Integer.parseInt(netArr[1]);
            if (map.keySet().contains(a)){
                map.get(a).add(b);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(b);
                map.put(a,list);
            }
            if (map.keySet().contains(b)){
                map.get(b).add(a);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                map.put(b,list);
            }
        }
        boolean[] vst = new boolean[Integer.parseInt(allComputerNum)+1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        vst[1] = true;

    }
}
