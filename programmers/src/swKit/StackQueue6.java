package swKit;

public class StackQueue6 {
	int[] solution(int[] prices) {
		
        int n = prices.length;
        int [] answer = new int [n];
                
        for (int i=0; i<n; i++) {
        	answer[i] = 0;
        	for (int j=i+1; j<n; j++) {
        		if (prices[i]<=prices[j]) {
        			answer[i]++;
        			continue;
        		}
        		else {
        			answer[i]++;
        			break;
        		}
        	}
        }
        answer[n-1] = 0;
        return answer;
    }
}
