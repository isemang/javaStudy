package swKit;

import java.util.Arrays;

//구명보트
public class Greedy4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p1 = {70, 50, 80, 50};
		int[] p2 = {70, 80, 50};
		int[] p3 = {20, 50, 50, 80};
		int[] p4 = {20, 30, 30, 50, 70, 80, 90};
		System.out.println(solution(p1,100));
		System.out.println(solution(p2,100));
		System.out.println(solution(p3,100));		//2
		System.out.println(solution(p4,100));
	}
	
	static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int i=0, j;
        for (j = people.length-1; i<j; j--) {
        	if(people[i]+people[j]>limit) answer++;
        	else {
        		answer++;
        		i++;
        	}
        }
        if(i==j) answer++;
        
        return answer;
    }
}
