package level2;
//카카오 2020: 문자열 압축

import java.util.ArrayList;
public class StringCompress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("aabbaccc"));
	}
	//문자열 자르기를 못하겠음 ㅜㅜ 근데 사실 안해도 될 것 같기는 한데
	static int solution(String s) {
        int answer = s.length();    //아무짓도 안했을 때의 길이
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
                    k++;	//자리수에 따라 추후 나눠야 함
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
