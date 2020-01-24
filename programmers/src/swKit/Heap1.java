package swKit;

import java.util.*;

//01.22 문제: 더 맵게
//힙을 이용해서 우선순위 큐 구현할 수 있음.
//우선순위 큐 공부하기 !
//힙문제 = 우선순위큐로 풀면 됨~!
public class Heap1 {
	
	int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int aScoville: scoville){
            heap.add(aScoville);
        }
        
        while (heap.peek() < K){
            if (heap.size() == 1) {
                return -1;
            }
            // 저기 if문 못짰음 -> 충족하는 결과가 나오지 않는 경우도 생각해줘야 함!!!
            // 충족하는 결과가 나오지 않는 경우 == heap의 size가 1인데도 heap의 peek가 K보다 작은 경우
            // 따라서 그 경우에는 -1을 출력해야 함
            
            int a = heap.poll();
            int b = heap.poll();
            int nScoville = a + (b*2);
            heap.offer(nScoville);
            //heap을 최소힙으로 정렬해야함 .. root노드에 최소값이 있어야 함
            //--> 처음에는 그냥 add메서드를 사용했음
            //**priority queue에서 제공되는 offer메소드**
            //--> 변수를 priority queue 형식으로 자동 정렬해줌
            answer++;
        }
        return answer;
    }
	
}
