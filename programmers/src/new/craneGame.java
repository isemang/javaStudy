import java.util.Stack;

public class craneGame {
    public static void main(String[] args) {
        int[][] b = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] m = {1,5,3,5,1,2,1,4};

        System.out.println(solution(b,m));
    }


    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack stack = new Stack();

        for(int i=0; i<moves.length; i++){
            int num = moves[i]-1;
            for(int j=0; j<board.length; j++){
                if(board[j][num] !=0){
                    int tmp = board[j][num];
                    board[j][num] = 0;
                    if(stack.size() != 0) {
                        if((int)stack.peek() == tmp) {
                            stack.pop();
                            answer++;
                            break;
                        } else{
                            stack.add(tmp);
                            break;
                        }
                    } else {
                        stack.add(tmp);
                        break;
                    }

                }
            }
        }
        return answer*2;
    }
}
