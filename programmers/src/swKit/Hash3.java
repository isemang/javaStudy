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
        //��ǻ� ������ ���� ������ ������� ���� ��
        //����� 2��, ���̿��� 1�� �̷������� ���⸸ �ϸ� ��
        //clothes ����
        ArrayList<String> type = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for (int i=0; i<clothes.length; i++){
            type.add(clothes[i][1]);
            hs.add(clothes[i][1]);
        }
        Collections.sort(type);
        int [] num = new int [hs.size()];   
        //hs.size�� ������ ����, num �迭 ������ ����� ���� �������� ��� �ִ���
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
        //����� ���� ���ϴ� ������ 4������ �ʰ� �� ���� {n, m, o, p}�� ������ ���� �� �Ʒ��� ����.
        //(n + 1) * (m + 1) * (o + 1) * (p + 1) - 1
        for (int i=0; i<num.length; i++){
            answer = answer*(num[i]+1);
        }
        return answer-1;
    }
}