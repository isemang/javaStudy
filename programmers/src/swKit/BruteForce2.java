package swKit;

import java.util.*;

//�Ҽ�ã��
//���� ���� ����� !! �� !!!!!
public class BruteForce2 {
	static HashSet<Integer> permArr = new HashSet<>();
	public static void main(String[] args) {
		String n1 = "17";
		String n2 = "35241";

//		solution("1234");
		System.out.println(solution("17"));
		System.out.println(solution("110"));
		//int [] a = {1,2,3,4};
		//perm(a, 0,4,3);�̸� 123 124 132 134 143 �̷��� ���ڸ� �� ��µ�
		//perm(a,0,4,4); �̸� 1234 1243 �̷��� ���ڸ��� ��µ�
	}

	static int solution(String numbers) {
		char[] c = numbers.toCharArray();
		

		// �ѹ����� int �迭 arr�� �ٲٱ�
		int[] arr = new int[c.length];
		for (int i = 0; i < c.length; i++)
			arr[i] = Character.getNumericValue(c[i]);

		// �ѹ��� �迭�� ���� �� �ִ� ��� ���� ����� �����ϱ�(����)
		for(int i=1; i<c.length+1; i++) {
			perm(arr, 0, c.length, i);
		}		
		
		//perm�� �����佺�׳׽� ü�� �ɷ��ֱ�, 0���� ������ֱ�
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
		//����� return�ϱ�
		int answer = 0;
		for (int i=0; i<o.length; i++) {
			if((int) o[i] == 0 || (int) o[i] == 1) continue;
			else answer++;
		}
		permArr.clear();
		return answer;
		
	}
	//�������� ���ϴ� ��
	static void perm(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			// �ѹ� depth �� k�� �����ϸ� ����Ŭ�� ������. �����.
			save(arr, k);
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}
	//���ο� perm�� ������ �����ϱ�-> HashSet�� �̿��Ͽ� �ߺ��� ����
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