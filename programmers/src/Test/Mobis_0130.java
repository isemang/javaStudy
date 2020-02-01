package Test;
//����: �ð� �����
//�޴� ��: String a = "PM 01:30:00", int n = 30
//����ϴ� ��:	String answer
//���:		1) a�� PM 01 -> 13���� �ٲ�
//			2) n��ŭ�� �ʿ� ���� -> 30�� ��
//��������� ����ϴ� ��: "13:30:30" (String��)
//�߰�)		a = "PM 11:59:59" �̰� n = 1 �̸�
//��°���		"00:00:00"�̾�� ��
//�߰�)		a = "AM 11:59:30" �̰� n = 72 �̸�
//��°���		"12:00:42"�� ǥ�õ�
//�߰�)		a = "AM 09:09:09" �̰� n = 30 �̸�
//��°���		"09:09:39"�� ǥ�õ�

import java.util.*;

public class Mobis_0130 {

	public static void main (String [] args) {
		
		String a = "AM 01:00:00";
		int n = 190000;		//190000: 52�ð� 46�� 40�� ��-> AM�ϰ� 5�ð�(24+24+12+5�ð�)-> AM 06�� 46�� 40��
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
		
		//65������ 24 = 2�ϰ� 17 ���� -> �Ф� ���� 1���� 52�ð� �ڴ� !? -> ��Ʋ �ϰ� 4�ð� ��: ���� 5��
		ih = ih%24;
		
		//��Ʈ������ ��ġ��
		StringBuilder sb = new StringBuilder();
		//���� 5�� -> 05�� �������� �ٲ�� ��/ 5�� -> 05�� �������� �ٲ�� ��
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
