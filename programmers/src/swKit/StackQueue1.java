package swKit;

import java.util.*;

public class StackQueue1 {

	public static void main(String [] args) {
//		int[] heights = {6,9,5,7,4};
//		int[] heights2 = {3,9,9,3,5,7,2};
		int[] heights3 = {1,5,3,6,7,6,5};
		
//		solution(heights);
//		solution(heights2);
		solution(heights3);
	}
	
	//수행결과 heights3예제가 잘못됐음(i=2일때)
	//생각해 보고 코드 수정 예정
	
	static void solution(int[] heights) {
        int[] answer = new int[heights.length];
        Queue<Integer> q = new LinkedList<>();
        int k= heights.length-1;
        
        for (int i=heights.length-1; i>=0; i--){
            q.add(heights[i]);         
            while (q.peek()<heights[i]){
                q.poll();
                answer[k] = i+1;
                k--;
            }
        }
        for (int u:answer) {
        	System.out.print(u+" ");
        }
        System.out.println();
    }
}