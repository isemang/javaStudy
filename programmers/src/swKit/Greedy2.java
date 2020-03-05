package swKit;
//조이스틱

/*왼쪽 끝에서 ←로 오른쪽 끝으로 갈 수도 있고, 오른쪽 끝에서 →로 왼쪽 끝으로 갈 수도 있습니다.
이 문제는 의외로 더러운 부분이 있습니다.
왔다갔다하는건 동선 낭비다? 시작점에서 오른쪽으로만 간 결과와 왼쪽키로 넘어가서 왼쪽으로만 간 결과만 본다?
AAZAAAAAAAAAAAAAAAAAAAZAAA 일 경우,
오른쪽으로만 가면 24번의 조작, 왼쪽으로만 가면 26번의 조작, (문제에서 총 길이는 20자 이하이지만)
섞어서 왔다갔다하면 10번의 조작으로, 결국 섞는 결과를 고려해야 합니다.
 *  그러면 이 이동을 둘 중 가까운 것 하나만 해도 되는지 볼까요.
처음 칸에서 오른쪽키만 눌러서 바꿀 문자를 만나는 것이 빠른지, 왼쪽키만 눌러서 바꿀 문자를 만나는 것이 빠른지 봐야합니다.
그런데 AZAAZAAZAAAAAAAAVAAAZAAZAAZ 일 경우,
초반에는 1칸 / 1칸으로 같고, 그 다음도 2칸 / 2칸으로 같고, 그 다음도 2칸 / 2칸, .. 그러다가 9칸 / 4칸으로 차이가 납니다.
AZAAZAAZAAAAAAAAVAAAZAAZAAZA 일 경우,
처음에 오른쪽으로 1칸 움직이는게 왼쪽키로 넘어가서 2칸 움직이는 것보다 효율적일 것 같지만,
위에서 보다시피 결국은 아니게 됩니다.(1칸 줄이려다 4칸 손해봄..)
다음 번의 판단만으로 전체를 판단하기는 어렵다는 거죠.
출처: https://ydeer.tistory.com/26 [현록의 기록저장소] */
public class Greedy2 {

	public static void main(String[] args) {
		
		String n1 = "JAZ";		//오:2	/왼:1	->1(왼)
		String n2 = "JEROEN";	//오:5	/왼:5	->5(둘다)
		String n3 = "JAANE";	//오:4	/왼:2	->2(왼)
		String n4 = "JANAE";	//오:4	/왼:3	->3(왼)
		String n5 = "JNAZAA";	//오:3	/왼:5	->3(오)
		String n6 = "JNAZKA";	//오:4	/왼:5	->4(오)
		String n7 = "JAUKJFA";	//오:5	/왼:5	->5(둘다)
		String n8 = "JAAKJFA";	//오:5	/왼:4	->4(왼)
		String n9 = "AAZAAAAAAAAAAAAAAAAAAAZAAA";
		//한마디로 둘째가 A면 왼이 이득, 마지막이 A면 오가 이득, 둘A마A면 둘다 상관 x
		//둘째가 A인데 셋째도 A 이런거는 옵션임. 왼이 더 더 이득이 될 옵션
		//마지막이 A인데 마지막-1도 A 이것도 옵션. 오가 더 더 이득 되는 옵션
		//마지막도 A고 둘째도 A면 어떡행 ..?!
//		System.out.println(solution(n1));
//		System.out.println(solution(n2));
		System.out.println(solution(n3));
		System.out.println(solution(n4));
		System.out.println(solution(n5));
//		System.out.println(solution(n6));
//		System.out.println(solution(n7));
		System.out.println(solution(n8));
		System.out.println(solution(n9));
	}
	static int solution(String name){
        int answer = 0;
        int n = name.length();
        int leftOrRight = name.length() - 1;
        // n은 name의 길이, leftOrRight는 커서 이동 위치를 구하기 위한 변수
        
        for(int i = 0; i < n; i++){
            int next = i + 1;
            char target = name.charAt(i);
            if(target <= 'N') answer += target - 'A';
            else answer += 'Z' - target + 1;
            //else까지 위아래 움직이면서 알파벳 자체를 바꾸는 거 !
            
            //이부분 완전 몬소린지 모르겠음 .. ㅠㅠㅠㅠ(왼, 오 구하는 부분)
            while(next < n && name.charAt(next) == 'A') next++; // 글자가 'A'인 경우 next를 1 증가
            int b = i + n - next + Math.min(i, n - next); // 현 위치에서 좌우 움직이는 수 중 작은 수를 구하는 식
            leftOrRight = Math.min(leftOrRight, b);
            // i는 현재 글자를 바꾸는 단어의 위치, n은 name의 총 길이
            // next는 현재 위치에서 A가 아닌 문자로 얼마나 갈 수 있는지 판단
        }
        answer += leftOrRight;
        return answer;
    }
}	
	//int solution(String name) {
//        //char a = 'A';     //유니코드 int로 65(int k = (int) a)
//        int answer = 0;
//        char [] nameArr = name.toCharArray();
//        int [] unicode = new int [nameArr.length];
//        boolean isLastA = false;
//        boolean isSecondA = false;
//        
//        for(int i=0; i<nameArr.length; i++){
//            unicode[i] = (int) nameArr[i];
//            if(i==1 && unicode[i]==65) isSecondA = true;
//            if(i==nameArr.length-1 && unicode[i]==65) isLastA = true;
//        }
//        
//        //오, 왼 여부 ㅠㅠ 해야함 // 진짜 모르겠음 ..
//        for(int i=0; i<unicode.length; i++){
//            
//        }
//        
//        //위, 아래 여부! 완료
//        for(int i=0; i<unicode.length; i++){
//            if(unicode[i]>77)   answer = answer+(91 - unicode[i]);
//            else                answer = answer+(unicode[i] - 65);
//        }
//        
//        return answer;
//    }
