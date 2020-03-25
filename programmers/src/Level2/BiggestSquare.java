package level2;

public class BiggestSquare {
//가장 큰 정사각형 찾기
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] b = {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}};
		int [][] c = {{0,0,1,1}, {1,1,1,1}};
		System.out.println(solution(b));
		System.out.println(solution(c));
	}

	static int solution(int [][]board){
        int answer = 0;
        // int column = board.length;        //행
        // int row = board[0].length;        //열

        int[][] dp = new int[board.length+1][board[0].length+1];
        
        for(int i = 0 ; i < board.length ; i++) {
        	for(int j = 0 ; j <board[0].length ; j++) {
        		if(board[i][j]==1)
        			dp[i+1][j+1] = 1;
        		else
        			dp[i+1][j+1] = 0;
        	}
        }
        
        for(int i = 1 ; i < dp.length; i++) {
        	for(int j = 1 ; j < dp[0].length ; j++) {
        		if(dp[i][j]==1) {
        			int min = Math.min(dp[i-1][j], dp[i][j-1]);
        			min = Math.min(min, dp[i-1][j-1]);
        			
        			dp[i][j] = min + 1;
        			answer = Math.max(answer, dp[i][j]);
        		}
        	}
        }
    
        return answer*answer;
    }
}