package swKit;

import java.util.*;

public class Sorting1 {
	int[] solution(int[] array, int[][] commands) {
		
        int[] answer = new int [commands.length];
        int [] arr = {};
        
        for (int i=0; i<commands.length; i++){
        	
            arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2]-1];
        }
        return answer;
    }
}
