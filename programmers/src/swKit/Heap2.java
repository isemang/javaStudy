package swKit;

import java.util.*;

public class Heap2 {
	//초기 코드: Hashtable을 사용할 필요가 전혀 없음 .............
//	int solution(int stock, int[] dates, int[] supplies, int k) {
//		//최소힙 말고 최대힙을 어떻게 만드렁 ?!?! ㅠㅠㅠ
//		int answer = 0;
//		
//		Hashtable<Integer, Integer> htable = new Hashtable<>();
//		PriorityQueue<Integer> hash = new PriorityQueue<>();
//		
//		for (int i=0; i<dates.length; i++) {
//			htable.put(supplies[i], dates[i]);
//			hash.offer(supplies[i]);
//		}
//		
//		while (stock < k+1) {
//			if (htable.get(hash.peek()) <= stock) {
//				stock = stock + htable.get(hash.poll());
//				answer++;
//			}
//		}
//		
//		
//		return answer;
//	}
	public static void main(String[] args) {
		int a = 4;
		int [] b = {4,10,15};
		int [] c = {20,5,10};
		int k = 30;
		System.out.println(solution(a,b,c,k));
	}
	
	static int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		//최대힙 만드는 법: PriorityQueue<>(Comaparator.reverseOrder());
		Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
		
		int idx = 0; //배열 dates, supplies의 길이 위한 변수
		
		for (int i=0; i<k; i++) {
			if (idx < dates.length && i == dates[idx])
				heap.offer(supplies[idx++]);
			
			if(stock == 0) {
				stock = stock + heap.poll();
				answer++;
			}
			stock = stock -1; //(stock -= 1)
		}
		
		return answer;
	}
}
//어디에 우선순위 큐를 사용해야하는지 전혀 몰랐던 문제.
//다음에는 문제 풀기 전에!! 어디에 뭘 사용해야 하는지 최대한 고민하기.
//priorityqueue를 supplies에만 사용해야 됐었음!!!!!
//stock가 빠지기 전에 date가 오면 -> supplies값을 heap에 넣고 최대힙정렬
//stock가 0이 되면 -> supplies heap에 있는 최대 supplies 값을 넣으면 됨
//언제(date)에 얼마의(supplies) 쌀이 충전됐는지는 중요하지 않으므로, 그런건 하나도 기록 남길 필요가 없음
