package swKit;
//���̽�ƽ

/*���� ������ ��� ������ ������ �� ���� �ְ�, ������ ������ ��� ���� ������ �� ���� �ֽ��ϴ�.
�� ������ �ǿܷ� ������ �κ��� �ֽ��ϴ�.
�Դٰ����ϴ°� ���� �����? ���������� ���������θ� �� ����� ����Ű�� �Ѿ�� �������θ� �� ����� ����?
AAZAAAAAAAAAAAAAAAAAAAZAAA �� ���,
���������θ� ���� 24���� ����, �������θ� ���� 26���� ����, (�������� �� ���̴� 20�� ����������)
��� �Դٰ����ϸ� 10���� ��������, �ᱹ ���� ����� ����ؾ� �մϴ�.
 *  �׷��� �� �̵��� �� �� ����� �� �ϳ��� �ص� �Ǵ��� �����.
ó�� ĭ���� ������Ű�� ������ �ٲ� ���ڸ� ������ ���� ������, ����Ű�� ������ �ٲ� ���ڸ� ������ ���� ������ �����մϴ�.
�׷��� AZAAZAAZAAAAAAAAVAAAZAAZAAZ �� ���,
�ʹݿ��� 1ĭ / 1ĭ���� ����, �� ������ 2ĭ / 2ĭ���� ����, �� ������ 2ĭ / 2ĭ, .. �׷��ٰ� 9ĭ / 4ĭ���� ���̰� ���ϴ�.
AZAAZAAZAAAAAAAAVAAAZAAZAAZA �� ���,
ó���� ���������� 1ĭ �����̴°� ����Ű�� �Ѿ�� 2ĭ �����̴� �ͺ��� ȿ������ �� ������,
������ ���ٽ��� �ᱹ�� �ƴϰ� �˴ϴ�.(1ĭ ���̷��� 4ĭ ���غ�..)
���� ���� �Ǵܸ����� ��ü�� �Ǵ��ϱ�� ��ƴٴ� ����.
��ó: https://ydeer.tistory.com/26 [������ ��������] */
public class Greedy2 {

	public static void main(String[] args) {
		
		String n1 = "JAZ";		//��:2	/��:1	->1(��)
		String n2 = "JEROEN";	//��:5	/��:5	->5(�Ѵ�)
		String n3 = "JAANE";	//��:4	/��:2	->2(��)
		String n4 = "JANAE";	//��:4	/��:3	->3(��)
		String n5 = "JNAZAA";	//��:3	/��:5	->3(��)
		String n6 = "JNAZKA";	//��:4	/��:5	->4(��)
		String n7 = "JAUKJFA";	//��:5	/��:5	->5(�Ѵ�)
		String n8 = "JAAKJFA";	//��:5	/��:4	->4(��)
		String n9 = "AAZAAAAAAAAAAAAAAAAAAAZAAA";
		//�Ѹ���� ��°�� A�� ���� �̵�, �������� A�� ���� �̵�, ��A��A�� �Ѵ� ��� x
		//��°�� A�ε� ��°�� A �̷��Ŵ� �ɼ���. ���� �� �� �̵��� �� �ɼ�
		//�������� A�ε� ������-1�� A �̰͵� �ɼ�. ���� �� �� �̵� �Ǵ� �ɼ�
		//�������� A�� ��°�� A�� ��� ..?!
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
        // n�� name�� ����, leftOrRight�� Ŀ�� �̵� ��ġ�� ���ϱ� ���� ����
        
        for(int i = 0; i < n; i++){
            int next = i + 1;
            char target = name.charAt(i);
            if(target <= 'N') answer += target - 'A';
            else answer += 'Z' - target + 1;
            //else���� ���Ʒ� �����̸鼭 ���ĺ� ��ü�� �ٲٴ� �� !
            
            //�̺κ� ���� ��Ҹ��� �𸣰��� .. �ФФФ�(��, �� ���ϴ� �κ�)
            while(next < n && name.charAt(next) == 'A') next++; // ���ڰ� 'A'�� ��� next�� 1 ����
            int b = i + n - next + Math.min(i, n - next); // �� ��ġ���� �¿� �����̴� �� �� ���� ���� ���ϴ� ��
            leftOrRight = Math.min(leftOrRight, b);
            // i�� ���� ���ڸ� �ٲٴ� �ܾ��� ��ġ, n�� name�� �� ����
            // next�� ���� ��ġ���� A�� �ƴ� ���ڷ� �󸶳� �� �� �ִ��� �Ǵ�
        }
        answer += leftOrRight;
        return answer;
    }
}	
	//int solution(String name) {
//        //char a = 'A';     //�����ڵ� int�� 65(int k = (int) a)
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
//        //��, �� ���� �Ф� �ؾ��� // ��¥ �𸣰��� ..
//        for(int i=0; i<unicode.length; i++){
//            
//        }
//        
//        //��, �Ʒ� ����! �Ϸ�
//        for(int i=0; i<unicode.length; i++){
//            if(unicode[i]>77)   answer = answer+(91 - unicode[i]);
//            else                answer = answer+(unicode[i] - 65);
//        }
//        
//        return answer;
//    }
