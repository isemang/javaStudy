package swKit;
//기능 개발
import java.util.*;

public class StackQueue3 {

	public static void main(String [] args) {
		
		int [] p = {93,30,55};
		int [] s = {1,30,5};
		
		solution(p,s);
	}
	
	static void solution(int[] progresses, int[] speeds) {
        int[] res = new int [progresses.length];
        int j=0;
        int k=1;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i=0; i<progresses.length; i++) {
        	res[i] = (100-progresses[i]) / speeds[i];
        	if ((100-progresses[i]) % speeds[i] != 0) {
        		res[i]++;
        	}
        	
        }
        //res에 결과값을 구한다(며칠이나 걸리는지)
        for (int i=0; i<progresses.length-1; i++) {
        	q.add(res[i]);
        	if(q.peek()> res[i+1]) {
        		res[i+1] = q.poll();
        	}
        }
        
      //결과값을 토대로 answer을 구한다  (ex)예제의 경우 res= 7, 7, 9 인데 이걸 answer = 2, 1로 바꿔줘야 함
  
        q.clear();
        
        for (int i=0; i<res.length-1; i++) {
        	if (res[i] == res[i+1]) {
        		k++;
        	}
        	if (res[i] < res[i+1]) {
        		q.add(k);
        		k=1;
        	}
        }
        if (res[res.length-2] < res[res.length-1]) {
        	q.add(1);
        }
        
        int[] answer = new int[q.size()];
        
        for (int f: answer) {
        	f = q.poll();
        	System.out.print(f+" ");
        }
        
        
      
    }
}
