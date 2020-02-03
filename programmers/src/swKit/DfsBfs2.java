package swKit;
//네트워크
//못풀었음 ㅠㅜ
//https://geehye.github.io/programmers-dfs-bfs-02/#
//필요 변수
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
	
	//기본 성질: 노드간에 서로 연결이 안되어있으면 dfs도 끝남.
	//computer[i][i]= 항상 1인거 활용
	//만약에 노드간에 서로 연결이 안되어있으면 -> dfs를 돌더라도 link[i][i] = true라는걸 표시를 못함!
	//따라서 link[i][i] = false일 때마다(원래는 true여야 하는데, dfs를 못돌아서 false인거임)
	//-> dfs를 돌면서 link[i][i]를 true로 바꿔주고, 그 담에 dfs를 다 돌면서 주변 노드를 true로 바꿔줄 수 있을 때까지 바꿔준 담에
	//다시 solution으로 돌아와서 answer를 ++시켜주는거임 !!
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
	//++) 새로 짜볼것
	//1 1 0 0
	//1 1 0 1
	//0 0 1 1
	//0 1 1 1		이 경우에 1/1/1/1 대각선 긋고 밑에꺼랑 위에꺼랑 똑같음 -> 그럼 밑에만 보고도 네트워크를 파악할 수 있지 않을까?!

}
