package swKit;

public class DfsBfs1 {

	//���� �𸣰ڴ� ����.(���ȣ���� �̷������ ������ �������� ���ϰ���)
	//26���̳� 25�Ͽ� �������� ����� �ٽ� Ŀ�� �ϱ�!!
	public static void main(String[] args) {
		int [] a = {5,6,2,4,3};
		int b = -6;

		System.out.println(solution(a,b));
	}
	
	//�̰� ��  Dfs, Bfs�� ����ؼ� Ǫ�¹����� ..?
	//����ü ��� ����ؾ� ��!?!?!
	//������ ���� �� �� ������ �� ���, DFS�� �̿��ؾ� �Ѵٴ� ����� �˾���
	//������ ��带 +, - �ϰ�, �װŸ� ��忡 ����
	//�׷��� �ϸ鼭 DFS ������� ��带 Ž��
	//���࿡ dfs ��� �� �� ������� target���̶� �ٸ��� -> �� dfs
	//�ٵ� ��� �� ���� �� �ص� ��(������ ��� ù ������ -1�� �� �ʿ� ����)
	//�ֳĸ� +1�� ������ �ſ� ������� -3�̸� -> -1���� ������ �ſ� ������� +3�ΰ� �ϳ� �ִٴ� ��
	//�ٵ� �̰� ��� �ڵ�� �������� !?!?
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