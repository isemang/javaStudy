package swKit;

import java.util.*;

public class Sorting2 {

	String solution(int[] numbers) {
		
        String answer = "";
        
        String[] arr = new String[numbers.length];
        for (int i=0; i<numbers.length; i++){
            arr[i] = (String.valueOf(numbers[i]));
        }
        
        Arrays.sort(arr, new Comparator<String>() {
           @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        if (arr[0].equals("0")) return "0";
        
        for (int i=0; i<arr.length; i++){
            answer += arr[i];
        }
        
        return answer;
        
    }
}
