package swKit;

import java.util.*;

public class Hash1 {
	String solution(String[] participant, String[] completion) {
		String answer = "";
		int num = 0;
		
		Map<String, Integer> hm = new HashMap<>();
		
		for (String p: participant) {
			if (hm.get(p) == null)
				hm.put(p, 1);
			else {
				num = hm.get(p) + 1;
				hm.put(p, num);
			}
		}
		
		for (String c: completion) {
			num = hm.get(c) - 1;
			hm.put(c, num);
		}
		
		for (String key: hm.keySet()) {
			if(hm.get(key) == 1) answer = key;
		}
		
		return answer;
	}
}
