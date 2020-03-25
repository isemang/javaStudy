package level2;

import java.util.Arrays;
import java.util.HashSet;
public class PhoneKemon {
	//ÆùÄÏ
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int solution(int[] nums) {
        int answer = nums.length/2;
        Arrays.sort(nums);
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }
        if(answer > hs.size()){
            answer = hs.size();
        }
        return answer;
    }
}