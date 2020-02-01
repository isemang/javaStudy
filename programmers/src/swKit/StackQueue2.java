package swKit;

import java.util.*;
//�ٸ��� ������ Ʈ��
public class StackQueue2 {
	
	public static void main(String[] args) {
		int bl = 2;
		int bl2 = 100;
		
		int w = 10;
		
		int [] tw = {7,4,5,6};							//8
		int [] tw2 = {10};								//101
		int [] tw3 = {10,10,10,10,10,10,10,10,10,10};	//110

		System.out.println(solution(bl,w,tw));
		System.out.println(solution(bl2,bl2,tw2));
		System.out.println(solution(bl2,bl2,tw3));
	}

	static int solution(int bridge_length, int weight, int[] truck_weights) {
		int time = 0;
		
		//�ٸ��� �ǳʱ� �� ��� Ʈ�� ����Ʈ
		Queue<Truck> qWait = new LinkedList<>();
		//�ٸ��� �ǳʴ� Ʈ�� ����Ʈ
		Queue<Truck> qOnBridge = new LinkedList<>();
		
		int onBridgeWeight = 0;
		
		for (int w : truck_weights) {
			qWait.add(new Truck(w, 0));
		}
		
		onBridgeWeight = onBridgeWeight+ qWait.peek().weight;
		qOnBridge.add(qWait.poll());
		
		
		while(!qOnBridge.isEmpty()) {
			time++;
			
			for (Truck t: qOnBridge) {
				//�ٸ��� Ʈ������ ������
				t.index++;
			}
			
			//Ʈ���� �ٸ� ���� �ٴٸ�
			if (qOnBridge.peek().index > bridge_length) {
				onBridgeWeight = onBridgeWeight - qOnBridge.poll().weight;
			}
			
			//����� Ʈ���� �ٸ��� �ø�(���� ����ؾ� ��)
			if(!qWait.isEmpty() && qWait.peek().weight+ onBridgeWeight <= weight) {
				onBridgeWeight = onBridgeWeight+qWait.peek().weight;
				qWait.peek().index++;
				qOnBridge.add(qWait.poll());
			}
		}		
		
		return time;
	}
	
	static class Truck {
		int weight;
		int index;
		
		public Truck(int weight, int index) {
			this.weight = weight;
			this.index = index;
		}
	}

}
