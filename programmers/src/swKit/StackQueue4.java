package swKit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//������
public class StackQueue4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] priorities = { 2, 1, 3, 2 };
		int[] priorities2 = { 1, 1, 9, 1, 1, 1 };
		int[] p = {1,2,2,3,4,5};
		
		int location = 2;
		int location2 = 0;
		
//		solution(p,location);
//		solution(priorities, location);
		System.out.println(solution(priorities2, location2));
	}
	
	static int solution(int[] priorities, int location) {
		int answer = 0;
		int [][] array = new int[priorities.length][2];
		ArrayList<Integer> aList = new ArrayList<>();
		
		for(int i=0; i<priorities.length; i++) {
			array[i][0] = i;
			array[i][1] = priorities[i];
			aList.add(priorities[i]);
		}
		
		Collections.sort(aList, Collections.reverseOrder());
		Queue<Integer> q = new LinkedList<>();
		
		for (int i=0; i<aList.size(); i++) {
			q.add(aList.get(i));
		}
		
		int j=0;
		while(!q.isEmpty()) {
			if(j >= priorities.length) {
				j = 0;
			}
			if(array[j][1] == q.peek()) {
				q.poll();
				answer++;
				if(array[j][0] == location) {
					break;
				}
			}
			//������ q.poll �ϰ� j�� �ű��
			//Ʋ���� q.poll �ȵ�,j �ű��
			j++;
		}
		
		return answer;
	}

}