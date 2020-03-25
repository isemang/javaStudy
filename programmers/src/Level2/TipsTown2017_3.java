package level2;
//예상 대진표
public class TipsTown2017_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(solution(8,4,7));
		System.out.println(solution(16,9,11));	//2
		System.out.println(solution(16,10,13));	//3
	}
	
	static int solution(int n, int a, int b) {
		int answer = 0;
		if(a>b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while (b-a >= 1) {
			if(b%2 == 1) {
				b = b/2 +1;
			} else {
				b = b/2;
			}
			if(a%2 == 1) {
				a = a/2 +1;
			} else {
				a = a/2;
			}
			answer++;
		}
		return answer;
	}
}