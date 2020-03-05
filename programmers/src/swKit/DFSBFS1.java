package swKit;

public class DfsBfs1 {

	//봐도 모르겠는 문제.(재귀호출이 이루어지는 과정을 이해하지 못하겠음)
	public static void main(String[] args) {
		int [] a = {5,6,2,4,3};
		int b = -6;
//		System.out.println("Answer\t"+ qwer(0,true));

		System.out.println(solution(a,b));
	}
	
	static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = test(numbers,1,numbers[0],Math.abs(target));
        return answer;
    }
	
	private static int test(int[] numbers, int index, int sum, int target) {
		if(index == numbers.length) {
			if(Math.abs(sum)==target)
				return 1;
			return 0;
		}
		return test(numbers, index+1, sum+numbers[index], target)
				+ test(numbers, index+1, sum-numbers[index],target);
	}
	
	//
	private static int myTest(int[] numbers, int index, int sum, int target) {
		if(index == numbers.length) {
			if(sum==target)
				return 1;
			return 0;
		}
		return test(numbers, index+1, sum+numbers[index], target)
				+ test(numbers, index+1, sum-numbers[index],target);
	} 
	
	static int qwer(int index,boolean isPlus) {
		if(index ==5) {
			if(isPlus) {
				return 1;
			} else {
				return 2;
			}
		}
		return qwer(index+1,isPlus)
				+ qwer(index+1,!isPlus);
		
	}
}