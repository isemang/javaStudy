package swKit;

//����Ʈ
public class Greedy4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p1 = {70, 50, 80, 50};
		int[] p2 = {70, 80, 50};
		int[] p3 = {20, 50, 50, 80};
		System.out.println(solution(p1,100));
		System.out.println(solution(p2,100));
		System.out.println(solution(p3,100));		//2
	}
	
	static int solution(int[] people, int limit) {
        int answer = 0, boatW = 0, left = people.length, boatP = 0;
        //boatW = ��Ʈ�� �ִ� ����, left=����� �����ִ� ��, i=index, boatP = ��Ʈ�� ź ��� ��
        int[] rescue = new int[people.length];
        while(left>0) {
        	for (int i=answer; i<people.length; i++) {
        		if(rescue[i]==0 && boatW+people[i]<=limit) {
        			boatP++;
        			boatW=people[i]+boatW;
        			rescue[i]=1;
        			left--;
        		}
        		if(boatP==2) break;
        		else if(boatW == limit) break;
        	}
        	answer++;
        	boatP=0;
        	boatW=0;
        }
        
        return answer;
    }
}
