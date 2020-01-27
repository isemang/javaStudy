package swKit;

import java.util.*;

public class StackQueue1 {

   public static void main(String [] args) {
      int[] heights = {6,9,5,7,4};      // [0,0,2,2,4]
      int[] heights2 = {3,9,9,3,5,7,2};   // [0,0,0,3,3,3,6]
      int[] heights3 = {1,5,3,6,7,6,5};   // [0,0,2,0,0,5,6]
      
      solution(heights);
      solution(heights2);
      solution(heights3);
   }
   
   //코드 수정 완료
   
   static void solution(int[] heights) {
      Stack<Integer>stk=new Stack<>();
       int[] answer = new int[heights.length];
       for(int i=0;i<heights.length;i++) {
          stk.push(heights[i]);
          
       }
       while(!stk.isEmpty()) {
          int tmp=stk.pop();
          //System.out.println(stk.size());
          
          for(int i=stk.size();i>=0;i--) {
             if(tmp<heights[i]) {
                answer[stk.size()]=i+1;
                break;
             }
           }
          
       }
       
        for (int u:answer) {
           System.out.print(u+" ");
        }
        System.out.println();
    }
}