package level2;

import java.util.ArrayList;
import java.util.Collections;

public class MakingDecimal2 {
//소수만들기(다른 코드)
	public static void main(String[] args) {
		
		int [] p = {1,2,3,4};
		System.out.println(solution(p));
	}
	
	static int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for (int k=j+1; k<nums.length; k++){
                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        
        Collections.sort(list);
        boolean [] ans = new boolean[list.size()];
        for (int i=0; i<ans.length; i++) {
			if((int) list.get(i) == 0)	continue;
			else {
				for (int j=2; j< list.get(i); j++) {
					if((int) list.get(i) % j == 0)	{
						ans[i] = true;
						break;
					}
				}
			}
		}
        for(int i=0; i<ans.length; i++){
            if(!ans[i]) answer++;
        }
        
        return answer;
    }
}
