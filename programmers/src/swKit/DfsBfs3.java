package swKit;

import java.util.*;

public class DfsBfs3 {
	
	public static void main(String [] args) {
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND","IAD"}, {"JFK","HND"}};
		String[][] tickets2 = {{"ICN","SFO"}, {"SFO","ATL"}, {"ICN","ATL"}, {"ATL","ICN"}, {"ATL","SFO"}};
		String[][] tickets3 = {{"ICN","SFO"}, {"ICN","ATL"}, {"SFO","ATL"}, {"ATL","ICN"}, {"ATL","SFO"}};
		String[][] tickets4 = {{"ICN","JFK"}, {"SFO","ICN"}, {"JFK","ATL"}, {"ATL","ICN"}, {"ATL","SFO"}, {"ICN","ATL"}, {"ATL","ICN"}, {"ICN","SFO"}, {"SFO", "ATL"}};	
		//1 답: ["ICN", "JFK", "HND", "IAD"]
		//2 답: ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
		//3 답: ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]
		//4 답: ["ICN", "ATL", "ICN", "JFK", "ATL", "ICN", "SFO", "ATL", "SFO", "ICN"]
		
		
//		solution(tickets1);
//		solution(tickets2);
//		//세번째 tickets3 확인 후 고칠 예정
//		solution(tickets3);
		solution(tickets4);
	}
	
	static boolean[][] link;
	static ArrayList<String> aList = new ArrayList<>();
    
    static void dfs(String[][] tickets, String from){
        for (int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(from) && !link[i][0]){
                link[i][0] = link[i][1] = true;
                aList.add(tickets[i][1]);
                dfs(tickets, tickets[i][1]);
            }
        }
    }
    
    static void solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        link = new boolean[tickets.length][2];
        aList.add("ICN");
        
        Queue<Integer> q = new LinkedList<>();
        List<String> s = new ArrayList<>();
        
        for (int k=0; k<tickets.length-1; k++) {
         	for (int i=k; i<tickets.length; i++) {
            	if (tickets[k][0].equals(tickets[i][0])) {
            		q.add(i);
                    s.add(tickets[i][1]);
                }
            }
            
            Collections.sort(s);
            int j = q.size();
            
            for (int i=0; i<j; i++){
                tickets[q.poll()][1] = s.get(i);
            }
            q.clear();
            s.clear();
        }
        
        //dfs 수행하기
        for (int i=0; i<tickets.length; i++){
            if(!link[i][0]){
            	dfs(tickets, "ICN");
            }
        }

        for (int i=0; i<aList.size(); i++) {
        	answer[i] = aList.get(i);
        }
                
        for (String str: aList) {
        	System.out.print(str+" ");
        }
        System.out.println();
        
        aList.clear();
    }
}
