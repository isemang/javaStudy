package swKit;
//��� ����
import java.util.*;

public class StackQueue3 {

	public static void main(String [] args) {
		
		int [] p = {93,30,93,55,55,55,93};
		int [] s = {1,30,1,5,5,5,1};
		
		solution(p,s);
	}
	
	static void solution(int[] progresses, int[] speeds) {
        int[] res = new int [progresses.length];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<progresses.length; i++) {
        	res[i] = (100-progresses[i]) / speeds[i];
        	if ((100-progresses[i]) % speeds[i] != 0) {
        		res[i]++;
        	}
        	
        }
        //res�� ������� ���Ѵ�(��ĥ�̳� �ɸ�����)
        for (int i=0; i<progresses.length-1; i++) {
        	q.add(res[i]);
        	if(q.peek() > res[i+1]) {
        		res[i+1] = q.peek();
        	}
        	q.poll();
        }
        
        for (int i:res) {
        	System.out.print(i+" ");
        }
        System.out.println();
        
        //������� ���� answer�� ���Ѵ�  (ex)������ ��� res= 7, 7, 9 �ε� �̰� answer = 2, 1�� �ٲ���� ��
        //answer�� ��� ����Ʈ�� ??
        int cnt = 0;
        int data = res[0];
        ArrayList<Integer> aList = new ArrayList<>();
        
        for (int i=0; i<res.length; i++) {
        	if (data == res[i]) { //data�� num�̶� ���� ��� //7,7,9 7�̶� 7�̶� ���� ��
        		cnt++;
        	}
        	else {
    			aList.add(cnt);
    			data = res[i];
    			cnt = 1;
        	}
        	
        	if(i== res.length-1) {
        		aList.add(cnt);
        	}
        	
        }
        
        int[] answer = new int[aList.size()];

        int size=0;
        for (int temp: aList) {
        	answer[size++]= temp;
        }
        
        for (int i:answer) {
        	System.out.print(i+" ");
        }
        
	}
}
