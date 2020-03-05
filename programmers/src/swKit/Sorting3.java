package swKit;

import java.util.*;

//H-Index
public class Sorting3 {

	public static void main(String[] args) {		

		int [] c1 = {3,0,6,1,5};
		int [] c2 = {1,7,0,1,6,4};
		int [] c3 = {1545,2,999,790,540,10,22};
		int [] c4 = {0};
		int [] c5 = {7};
		
		System.out.println(solution(c1));
		System.out.println(solution(c2));
		System.out.println(solution(c3));
		System.out.println(solution(c4));
		System.out.println(solution(c5));

	}
	
	static int solution(int[] citations) {
        int answer = 0;
        ArrayList<Integer> aList = new ArrayList<>();
        
        for (int i=0; i<citations.length; i++){
            aList.add(citations[i]);
        }
        Collections.sort(aList, Collections.reverseOrder());
        
        int j=0;
        while(true) {
            if (j >= citations.length){
                answer = citations.length;
                break;
            }
            
            if(aList.get(j) > j){
                j++;
                continue;
            } else{
                answer = j;
                break;
            }
        }
        
        return answer;
    }
}