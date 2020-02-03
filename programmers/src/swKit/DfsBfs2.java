package swKit;
//��Ʈ��ũ
//��Ǯ���� �Ф�
//https://geehye.github.io/programmers-dfs-bfs-02/#
//�ʿ� ����
//1) boolean[][] link:
public class DfsBfs2 {

	public static void main(String[] args) {

		int n = 4;
		int[][] computers = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1} };

		System.out.println(solution(n, computers));
	}

	static boolean[][] link;

	static void dfs(int[][] computers, int idx, int n) {
 		for (int i = 0; i < n; i++) {
			if (computers[idx][i] == 1 && !link[idx][i]) {
				link[idx][i] = link[i][idx] = true;
				dfs(computers, i, n);
			}
		}
	}
	
	//�⺻ ����: ��尣�� ���� ������ �ȵǾ������� dfs�� ����.
	//computer[i][i]= �׻� 1�ΰ� Ȱ��
	//���࿡ ��尣�� ���� ������ �ȵǾ������� -> dfs�� ������ link[i][i] = true��°� ǥ�ø� ����!
	//���� link[i][i] = false�� ������(������ true���� �ϴµ�, dfs�� �����Ƽ� false�ΰ���)
	//-> dfs�� ���鼭 link[i][i]�� true�� �ٲ��ְ�, �� �㿡 dfs�� �� ���鼭 �ֺ� ��带 true�� �ٲ��� �� ���� ������ �ٲ��� �㿡
	//�ٽ� solution���� ���ƿͼ� answer�� ++�����ִ°��� !!
	static int solution(int n, int[][] computers) {
		int answer = 0;
		link = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			if (!link[i][i]) {
				dfs(computers, i, n);
				answer++;
			}
		}
		return answer;
	}
	//++) ���� ¥����
	//1 1 0 0
	//1 1 0 1
	//0 0 1 1
	//0 1 1 1		�� ��쿡 1/1/1/1 �밢�� �߰� �ؿ����� �������� �Ȱ��� -> �׷� �ؿ��� ���� ��Ʈ��ũ�� �ľ��� �� ���� ������?!

}
