package swKit;

import java.util.*;

//01.22 ����: �� �ʰ�
//���� �̿��ؼ� �켱���� ť ������ �� ����.
//�켱���� ť �����ϱ� !
//������ = �켱����ť�� Ǯ�� ��~!
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
            // ���� if�� ��®�� -> �����ϴ� ����� ������ �ʴ� ��쵵 ��������� ��!!!
            // �����ϴ� ����� ������ �ʴ� ��� == heap�� size�� 1�ε��� heap�� peek�� K���� ���� ���
            // ���� �� ��쿡�� -1�� ����ؾ� ��
            
            int a = heap.poll();
            int b = heap.poll();
            int nScoville = a + (b*2);
            heap.offer(nScoville);
            //heap�� �ּ������� �����ؾ��� .. root��忡 �ּҰ��� �־�� ��
            //--> ó������ �׳� add�޼��带 �������
            //**priority queue���� �����Ǵ� offer�޼ҵ�**
            //--> ������ priority queue �������� �ڵ� ��������
            answer++;
        }
        return answer;
    }
	
}
