package swKit;

//ū �� �����
public class Greedy3 {

	public static void main(String[] args) {
		System.out.println(solution("1924",2));
		System.out.println(solution("1231234",3));
		System.out.println(solution("4177252841",4));
		System.out.println(solution("1111",2));
		System.out.println(solution("10000",2));
	
	}
	
	static String solution(String number, int k) {
        int y=0, z=0;   //y�� idx�� ���� ū �� ����, z�� ���� ū �� ����
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[number.length()];

        for(int i=0; i<number.length(); i++) {
            arr[i] = number.charAt(i)-48;
        }

        k = arr.length-k; //k�ڸ��� �ΰ��� ~~~!!!
        int i=0;
        while (k>0){
            if (i < arr.length && arr.length-i >= k){
                if(z<arr[i]){
                    z = arr[i];
                    y = i;
                }
                i++;
                if(z==9) i = arr.length;
            }
            else{
                i = y+1;
                k--;
                sb.append(z);
                z=0;
            }
        }
        return sb.toString();
    }
}