package swKit;

public class DfsBfs1 {

	//봐도 모르겠는 문제.(재귀호출이 이루어지는 과정을 이해하지 못하겠음)
	public static void main(String[] args) {
		int [] a = {5,6,2,4,3};
		int b = -6;

		System.out.println(solution(a,b));
	}
	
	static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers,0,0,target);
        return answer;
    }
	
	private static int dfs(int[] numbers, int node, int sum, int target) {
		if(node == numbers.length) {
			if(sum==target)
				return 1;
			return 0;
		}
		return dfs(numbers, node+1, sum+numbers[node], target)
				+ dfs(numbers, node+1, sum-numbers[node],target);
	}
}