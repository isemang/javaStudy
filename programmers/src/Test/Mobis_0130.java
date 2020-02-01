package Test;
//문제: 시계 만들기
//받는 값: String a = "PM 01:30:00", int n = 30
//출력하는 값:	String answer
//방식:		1) a를 PM 01 -> 13으로 바꿈
//			2) n만큼을 초에 더함 -> 30이 됨
//결론적으로 출력하는 값: "13:30:30" (String형)
//추가)		a = "PM 11:59:59" 이고 n = 1 이면
//출력값이		"00:00:00"이어야 함
//추가)		a = "AM 11:59:30" 이고 n = 72 이면
//출력값이		"12:00:42"로 표시됨
//추가)		a = "AM 09:09:09" 이고 n = 30 이면
//출력값이		"09:09:39"로 표시됨

import java.util.*;

public class Mobis_0130 {

	public static void main (String [] args) {
		
		String a = "AM 01:00:00";
		int n = 190000;		//190000: 52시간 46분 40초 후-> AM하고 5시간(24+24+12+5시간)-> AM 06시 46분 40초
		System.out.println(solution(a,n));
		
		String a1 = "PM 11:59:59";
		int n1 = 20;
		System.out.println(solution(a1,n1));
		
		String a2 = "AM 11:59:59";
		int n2 = 3;
		System.out.println(solution(a2,n2));
	}
	
	static String solution(String a, int n) {
		
		StringTokenizer st = null;
		st = new StringTokenizer(a);
		String ampm = st.nextToken();
		String all = st.nextToken();
		
		st = new StringTokenizer(all, ":");
		String h = st.nextToken();
		String m = st.nextToken();
		String s = st.nextToken();
		
		int ih = Integer.parseInt(h);
		int im = Integer.parseInt(m);
		int is = Integer.parseInt(s);
		
		is = n+is;
		
		im = is/60 + im;
		is = is%60;

		while (true) {
			if (ampm.equals("PM") && ih<12) {
				ih = ih + 12;
				break;
			}
			if (ampm.equals("PM") && ih>=12) {
				ih = ih - 12;
				break;
			}
			else {
				break;
			}
		}
		
		ih = im/60 + ih;
		im = im%60;
		
		//65나누기 24 = 2하고 17 남음 -> ㅠㅠ 오후 1시의 52시간 뒤는 !? -> 이틀 하고도 4시간 후: 오후 5시
		ih = ih%24;
		
		//스트링으로 합치기
		StringBuilder sb = new StringBuilder();
		//새벽 5시 -> 05로 나오도록 바꿔야 함/ 5분 -> 05로 나오도록 바꿔야 함
		if (ih<10) {
			sb.append("0");
		}
		sb.append(ih);
		sb.append(":");
		
		if (im<10) {
			sb.append("0");
		}
		sb.append(im);
		sb.append(":");
		
		if (is<10) {
			sb.append("0");
		}
		sb.append(is);
		String answer = sb.toString();

		return answer;
	}
	
}
