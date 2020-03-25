package level2;

import java.util.ArrayList;
import java.util.Collections;
//소수 만들기
public class MakingDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] b = {1,2,3,4};
		int [] c = {1,2,7,6,4};
		
		System.out.println(solution(b));
		System.out.println(solution(c));
	}

	static int solution(int[] nums) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                for (int k=j+1; k<nums.length; k++){
                    list.add(nums[i]+nums[j]+nums[k]);
                }
            }
        }
        Collections.sort(list);
        int[] arr = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            arr[i] = list.get(i);
        }
        int big = list.get(list.size()-1);
        list.clear();
        for(int i=2; i<big/2; i++){
            for(int j=0; j<arr.length; j++){
                if(arr[j]%i==0 && arr[j] != i){
                    arr[j]=0;
                }
            }
        }
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0) answer++;
        }
        return answer;
    }
}
