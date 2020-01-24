package swKit;

import java.util.*;

public class Heap2 {
	//�ʱ� �ڵ�: Hashtable�� ����� �ʿ䰡 ���� ���� .............
//	int solution(int stock, int[] dates, int[] supplies, int k) {
//		//�ּ��� ���� �ִ����� ��� ���巷 ?!?! �ФФ�
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
		//�ִ��� ����� ��: PriorityQueue<>(Comaparator.reverseOrder());
		Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
		
		int idx = 0; //�迭 dates, supplies�� ���� ���� ����
		
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
//��� �켱���� ť�� ����ؾ��ϴ��� ���� ������ ����.
//�������� ���� Ǯ�� ����!! ��� �� ����ؾ� �ϴ��� �ִ��� ����ϱ�.
//priorityqueue�� supplies���� ����ؾ� �ƾ���!!!!!
//stock�� ������ ���� date�� ���� -> supplies���� heap�� �ְ� �ִ�������
//stock�� 0�� �Ǹ� -> supplies heap�� �ִ� �ִ� supplies ���� ������ ��
//����(date)�� ����(supplies) ���� �����ƴ����� �߿����� �����Ƿ�, �׷��� �ϳ��� ��� ���� �ʿ䰡 ����
