package swKit;

import java.util.ArrayList;

public class DfsBfs3 {
	
	public static void main(String [] args) {
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND","IAD"}, {"JFK","HND"}};
		String[][] tickets2 = {{"ICN", "ATL"}, {"ICN","SFO"}, {"SFO","ATL"}, {"ATL","ICN"}, {"ATL", "SFO"}};
		String[][] tickets3 = {{"ICN", "SFO"}, {"ICN","ATL"}, {"SFO","ATL"}, {"ATL","ICN"}, {"ATL", "SFO"}};
		
		solution(tickets1);
		solution(tickets2);
		//세번째 tickets3 확인 후 고칠 예정
		solution(tickets3);
	}
	
	static boolean[][] link;
	static ArrayList<String> temp = new ArrayList<>();
    
    static void dfs(String[][] tickets, String from){
        for (int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(from) && !link[i][0]){
                link[i][0] = link[i][1] = true;
                temp.add(tickets[i][1]);
                dfs(tickets, tickets[i][1]);
            }
        }
    }
    
    static void solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        link = new boolean[tickets.length][2];
        temp.add("ICN");
        for (int i=0; i<tickets.length; i++){
            if(!link[i][0]){
            	dfs(tickets, "ICN");
            }
        }

        for (int i=0; i<temp.size(); i++) {
        	answer[i] = temp.get(i);
        }
                
        for (String str: temp) {
        	System.out.print(str+" ");
        }
        System.out.println();
        
        temp.clear();
    }
}
