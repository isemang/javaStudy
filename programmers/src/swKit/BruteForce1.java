package swKit;

import java.util.*;

public class BruteForce1 {

	public static void main(String[] args) {
		int[] answers1 = {1,2,3,4,5};
		int[] answers2 = {1,3,2,4,2};
		
		solution(answers1);
		solution(answers2);
	}
	
	static void solution(int[] answers) {
		int[] result = new int[3];
		int[] one = { 1, 2, 3, 4, 5 };
		int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		// 몇문제 맞았는지
		for (int i = 0; i < answers.length; i++) {
			if (one[i % 5] == answers[i]) {
				result[0]++;
			}
			if (two[i % 8] == answers[i]) {
				result[1]++;
			}
			if (three[i % 10] == answers[i]) {
				result[2]++;
			}
		}

		int biggest = result[0]; // 가장 점수 큰 거 기억하기

		for (int i = 0; i < result.length; i++) {
			if (biggest < result[i]) {
				biggest = result[i];
			}
		}

		ArrayList<Integer> aList = new ArrayList<>();
		for (int i = 0; i < result.length; i++) {
			if (result[i] == biggest) {
				aList.add(i + 1);
			}
		}

		int size = aList.size();
		int[] answer = new int[size];
		for (int i = 0; i < size; i++) {
			answer[i] = aList.get(i);
		}

		for(int a: answer) {
			System.out.print(a+" ");
		}
		System.out.println();
	}
}
