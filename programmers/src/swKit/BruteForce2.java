package swKit;

import java.util.*;

//소수찾기
//문제 완전 어려움 !! 악 !!!!!
public class BruteForce2 {
	static HashSet<Integer> permArr = new HashSet<>();
	public static void main(String[] args) {
		String n1 = "17";
		String n2 = "35241";

//		solution("1234");
		System.out.println(solution("17"));
		System.out.println(solution("110"));
		//int [] a = {1,2,3,4};
		//perm(a, 0,4,3);이면 123 124 132 134 143 이렇게 세자리 수 출력됨
		//perm(a,0,4,4); 이면 1234 1243 이렇게 네자리수 출력됨
	}

	static int solution(String numbers) {
		char[] c = numbers.toCharArray();
		

		// 넘버스를 int 배열 arr로 바꾸기
		int[] arr = new int[c.length];
		for (int i = 0; i < c.length; i++)
			arr[i] = Character.getNumericValue(c[i]);

		// 넘버스 배열로 만들 수 있는 모든 수를 만들어 저장하기(순열)
		for(int i=1; i<c.length+1; i++) {
			perm(arr, 0, c.length, i);
		}		
		
		//perm을 에라토스테네스 체로 걸러주기, 0으로 만들어주기
		Object[] o = permArr.toArray();
		for (int i=0; i<o.length; i++) {
			if((int) o[i] == 0)	continue;
			else {
				for (int j=2; j< (int) o[i]; j++) {
					if((int) o[i] % j == 0)	{
						o[i] = 0;
						break;
					}
				}
			}
		}
		//결과값 return하기
		int answer = 0;
		for (int i=0; i<o.length; i++) {
			if((int) o[i] == 0 || (int) o[i] == 1) continue;
			else answer++;
		}
		permArr.clear();
		return answer;
		
	}
	//순열값을 구하는 곳
	static void perm(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			// 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
			save(arr, k);
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}
	//새로운 perm에 순열값 저장하기-> HashSet을 이용하여 중복을 제거
	static void save(int[] arr, int k) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			if (i == k - 1) {
				sb.append(arr[i]);
				String str = sb.toString();
				permArr.add(Integer.parseInt(str));
				sb.delete(0,k-1);				
			}
			else {
				sb.append(arr[i]);
			}

		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}