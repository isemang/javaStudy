package level2;
//level2_멀쩡한 사각형
public class IntactSquare {

	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}

	static long solution(int w,int h) {
		long answer = 1;
        long big, small;
        if(w>h){
            big = w;
            small = h;
        } else{
            big = h;
            small = w;
        }
        long gcd = gcd(big,small);
        answer = big*small-(big/gcd+small/gcd-1)*gcd;
		return answer;
	}
    
    static long gcd(long big, long small){
        if (big % small == 0)   return small;
        return gcd(small, big%small);
    }
}