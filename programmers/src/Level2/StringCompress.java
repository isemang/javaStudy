package level2;
//īī�� 2020: ���ڿ� ����

import java.util.ArrayList;
public class StringCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("aabbaccc"));
	}
	//���ڿ� �ڸ��⸦ ���ϰ��� �̤� �ٵ� ��� ���ص� �� �� ����� �ѵ�
	static int solution(String s) {
        int answer = s.length();    //�ƹ����� ������ ���� ����
        String [] str;
        for(int i=1; i<s.length()/2; i++){
            if(s.length()%i != 0) {
            	int q = s.length()/i+1;
            	str = s.split("", q);
            }
            else {
            	int q = s.length()/i;
            	str = s.split("", q);
            }
            int k=1;
            int sum = 0;
            for(int j=1; j<str.length; j++){
                if(str[j-1].equals(str[j])) {
                    k++;	//�ڸ����� ���� ���� ������ ��
                    continue;
                } else {
                    if (k == 1) {
                    	sum = sum+i;
                    	k=1;
                    	continue;
                    } else if (k>1 && k<=9) {
                    	sum = sum+i+1;
                    	k=1;
                    	continue;
                    } else if (k>10 && k<=99) {
                    	sum = sum+i+2;
                    	k = 1;
                    	continue;
                    } else {
                    	sum = sum+i+3;
                    	k = 1;
                    	continue;
                    }
                }
            }
            if (sum < answer) answer = sum;
        }
        ArrayList<Integer> list = new ArrayList<>();
//        list.
        
        return answer;
    }
}
