package swKit;

public class DfsBfs1 {

	//봐도 모르겠는 문제.(재귀호출이 이루어지는 과정을 이해하지 못하겠음)
	//26일이나 25일에 오빠한테 물어보고 다시 커밋 하기!!
	public static void main(String[] args) {
		int [] a = {5,6,2,4,3};
		int b = -6;

		System.out.println(solution(a,b));
	}
	
	//이게 왜  Dfs, Bfs를 사용해서 푸는문제야 ..?
	//도데체 어떻게 사용해야 함!?!?!
	//문제에 대해 좀 더 생각해 본 결과, DFS를 이용해야 한다는 사실을 알았음
	//각각의 노드를 +, - 하고, 그거를 노드에 저장
	//그렇게 하면서 DFS 방식으로 노드를 탐색
	//만약에 dfs 노드 맨 끝 결과값이 target값이랑 다르면 -> 또 dfs
	//근데 계산 한 번은 덜 해도 됨(예제의 경우 첫 시작을 -1로 할 필요 없음)
	//왜냐면 +1로 시작한 거에 결과값이 -3이면 -> -1에서 시작한 거에 결과값이 +3인게 하나 있다는 뜻
	//근데 이걸 어떻게 코드로 구현하지 !?!?
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