import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class failureRate {
    public static void main(String[] args){
        int [] s = {2, 1, 2, 6, 2, 4, 3, 3};
        int [] s2 = {4,4,4,4,4};
        solution(5,s2); //[3,4,2,1,5] 답
    }

    public static void solution(int N, int[] stages) {
        HashMap<Integer, Double> hmap = new HashMap<>();

        int[] nowArr = new int [N+2];
        for(int i=0; i<stages.length; i++){
            nowArr[stages[i]]++;
        }
        int all = stages.length;    //전체 사람 수
        for(int i=1; i<N+1; i++){
            all = all-nowArr[i-1];
            if(all == 0) hmap.put(i, 0.0);
            else         hmap.put(i, (double) nowArr[i]/all);
        }
        ArrayList<Integer> val = new ArrayList<>(hmap.keySet());
        Collections.sort(val, (o1, o2) -> (hmap.get(o2).compareTo(hmap.get(o1))));

        int[] answer = new int[val.size()];

        for(int i=0; i<val.size(); i++){
            answer[i] = val.get(i);
        }

        for(int arr: answer){
            System.out.println(arr);
        }

//        return answer;
    }
}
