package swKit;

import java.util.*;

//�Ҽ�ã��
//���� ���� ����� !! �� !!!!!
public class BruteForce2 {
	public static void main(String[] args) {
		String n1 = "17";
		String n2 = "35241";
		
		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}
	//������ ���� ���
	//1) ���� �������� ���� �� �ִ� ��� ���ڸ� �����, �� ���ڵ� �� �Ҽ��� ������ ���� ���(�ʹݿ� ���� �����ߴ� ���)
	//**2) ���� �������� ���� �� �ִ� �ִ� ������ �Ҽ��� ��� ���� ��, ��� �Ҽ��� �˻��Ͽ� �ش� �Ҽ��� ���� ������� �̷���� �� �ִ��� Ȯ���ϴ� ���
	
	
	static int solution(String numbers) {
		int biggest = 0;
		int answer = 0;
		ArrayList<Integer> aList = new ArrayList<>();
		ArrayList<Integer> sosuList = new ArrayList<>();
		
		char [] numArr = numbers.toCharArray();
		
		for (int i=0; i<numArr.length; i++) {
			aList.add(Character.getNumericValue(numArr[i]));
		}
		
		Collections.sort(aList);
		
		int size = aList.size();
		
		//������������ ���� �� �ִ� ���� ū ���� biggest ���ϱ�
		for (int i=size-1; i>=0; i--) {
			biggest = (int) (biggest+ aList.get(i)*Math.pow(10, i));
		}
		
		//biggest���� �Ҽ��� sosuList�� �����ϱ�
		
		
		//sosuList�� �ִ� �Ҽ��� ������������ ���� �� �ִ°����� Ȯ���ϱ�
		
		return answer;
	}
}