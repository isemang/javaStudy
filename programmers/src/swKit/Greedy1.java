package swKit;

import java.util.Arrays;

//체육복
public class Greedy1 {

	public static void main(String[] args) {
		int[] l1 = { 1, 3, 4, 5 };
		int[] l2 = { 3, 5 };
		int[] l3 = { 2, 3 };
		int[] l4 = { 7, 8, 11, 12 };
		int[] l5 = { 12, 13, 16, 17, 19, 20, 21, 22 };
		int[] l6 = {2,3,4};
		
		int[] r1 = { 1, 4 };
		int[] r2 = {};
		int[] r3 = { 1 };
		int[] r4 = { 1, 6, 8, 10 };
		int[] r5 = { 1, 22, 16, 18, 9, 10 };
		int[] r6 = {3,4,5};
		
		int n1 = 6;
		int n3 = 3;
		int n4 = 18;
		int n5 = 24;
		int n6 = 5;

//		System.out.println(solution(n1, l1, r1));		//4
//		System.out.println(solution(n1, l2, r2));		//4
//		System.out.println(solution(n3, l3, r3));		//2
//		System.out.println(solution(n4, l4, r4));		//17
//		System.out.println(solution(n5, l5, r5));		//19
		System.out.println(solution(n6, l6, r6));		//4
	}

	static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int [] arrL = new int [n+1];
        int [] arrR = new int [n+1];
        int p = 0;
        int q = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i=1; i<n+1; i++){
            if (p<lost.length){
                if(lost[p]==i){
                    arrL[i]=1;
                    p++;
                }
            }
            if (q<reserve.length){
                if(reserve[q]==i){
                    arrR[i]=1;
                    q++;
                }
            }
        }
        
        for (int i=1; i<n+1; i++){
            //1. 잃어버린 자기 자신이 여벌의 체육복이 있으면 자기가 쓴다
            if(arrL[i]==1 && arrR[i]==1){
                arrL[i] = arrR[i] = 0;
            }
        }
        
        for (int i=1; i<n+1; i++){
            //2. arrL[i]가 1인데 arrR의 i-1(exception주의)이나 i+1(exception주의)이 1이면 준다
            if(arrL[i]==1 && arrR[i-1]==1){
                arrL[i] = arrR[i-1] = 0;
            }
            if(arrL[i]==1 && i<n){
                if(arrR[i+1] ==1){
                    arrL[i] = arrR[i+1] = 0;
                }
            }
        }
        
        for (int i=1; i<n+1; i++){
            if(arrL[i]==0) answer++;
        }
             
        return answer;
    }
}