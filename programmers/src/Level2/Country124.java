package level2;

public class Country124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(1));
		System.out.println(solution(2));
		System.out.println(solution(3));
		System.out.println(solution(4));
	}

	static String solution(int n) {
		String answer = "";
		StringBuilder sb = new StringBuilder();
		int rmd=0;
		while (n> 0) {
			rmd = n%3;
			n = n/3;
			
			if(rmd == 0) {
				n -=1;
				rmd = 4;
			}
			answer = rmd + answer;
		}

		return answer;
	}
}