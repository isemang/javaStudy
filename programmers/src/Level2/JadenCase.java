package level2;

public class JadenCase {
	//JadenCase 문자열 만들기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("3people unFollowed me"));
		System.out.println(solution("jadenCase"));
		System.out.println(solution("for the last week"));
	}

	static String solution(String s) {
//		String answer = "";
		char[] split = s.toCharArray(); // 아스키코드 " " = 32;
		// 아스키코드 대문자 = 65 ~ 90
		// 아스키코드 소문자 = 97 ~ 122
		// 대문자 -> 소문자 변환: a(변수) + 32
		// 소문자 -> 대문자 변환: a(변수) - 32
		StringBuilder sb = new StringBuilder();
		if((int) split[0] >= 97 && split[0] <= 122) {
			int ch = (int) split[0] - 32;
			split[0] = (char) ch;
		}
		sb.append(split[0]);
		for (int i = 1; i < split.length; i++) {
			int ch = (int) split[i];
			if ((int) split[i - 1] == 32) {
				if (ch >= 97 && ch <= 122) {
					ch = ch - 32;
					// ch로 바꿔줍니다
					split[i] = (char) ch;
				}
			} else {
				if (ch >= 65 && ch <= 90) {
					ch = ch + 32;
					split[i] = (char) ch;
				}
			}
			sb.append(split[i]);
		}
//		for (int i = 0; i < split.length; i++) {
//			System.out.print(split[i]);
//		}
		return sb.toString();
	}
}
