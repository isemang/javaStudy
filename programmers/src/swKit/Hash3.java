package swKit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Hash3 {

	public static void main (String [] args) {
		String [][] c1 = {{"crow_mask", "a"}, {"blue_sunglasses", "b"}, {"smoky_makeup", "c"}, 
						  {"crow_mask", "d"}, {"blue_sunglasses", "a"}, {"smoky_makeup", "b"}, 
						  {"smoky_makeup", "k"}};
		solution(c1);
	}
	
	static int solution(String[][] clothes) {
        int answer = 1;
        //사실상 종류에 따른 갯수가 몇개인지만 세면 됨
        //헤드기어 2개, 아이웨어 1개 이런식으로 세기만 하면 됨
        //clothes 정렬
        ArrayList<String> type = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for (int i=0; i<clothes.length; i++){
            type.add(clothes[i][1]);
            hs.add(clothes[i][1]);
        }
        Collections.sort(type);
        int [] num = new int [hs.size()];   
        //hs.size는 종류의 갯수, num 배열 각각에 저장된 값은 종류마다 몇개가 있는지
        num[0] = 1;
        int j=0;
        for (int i=1; i<clothes.length; i++) {
        	if(type.get(i-1).equals(type.get(i))){
        		num[j]++;
        	} else {
        		j++;
        		num[j]++;
        	}
        }
        //경우의 수를 구하는 공식은 4종류의 옷과 그 옷이 {n, m, o, p}의 개수로 있을 때 아래와 같다.
        //(n + 1) * (m + 1) * (o + 1) * (p + 1) - 1
        for (int i=0; i<num.length; i++){
            answer = answer*(num[i]+1);
        }
        return answer-1;
    }
}