package swKit;

import java.util.*;

//소수찾기
//문제 완전 어려움 !! 악 !!!!!
public class BruteForce2 {
	public static void main(String[] args) {
		String n1 = "17";
		String n2 = "35241";
		
		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}
	//문제의 접근 방법
	//1) 숫자 조각으로 만들 수 있는 모든 숫자를 만들고, 그 숫자들 중 소수의 개수를 세는 방법(초반에 내가 생각했던 방법)
	//**2) 숫자 조각으로 구할 수 있는 최대 수까지 소수를 모두 구한 뒤, 모든 소수를 검사하여 해당 소수가 숫자 조각들로 이루어질 수 있는지 확인하는 방법
	
	
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
		
		//숫자조각으로 만들 수 있는 가장 큰 수인 biggest 구하기
		for (int i=size-1; i>=0; i--) {
			biggest = (int) (biggest+ aList.get(i)*Math.pow(10, i));
		}
		
		//biggest까지 소수들 sosuList에 저장하기
		
		
		//sosuList에 있는 소수가 숫자조각으로 만들 수 있는것인지 확인하기
		
		return answer;
	}
}