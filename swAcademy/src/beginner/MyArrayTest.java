package beginner;
public class MyArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyArray arr = new MyArray(5);
		for (int i=1; i< 6; i++) {
			arr.add("������-"+i);
		}
		
		System.out.println("<<MyArray ��ü�� ����� ��ҵ� >>");
		System.out.println(arr.toString());
		System.out.println("<<MyArray 0�� index�� ����� ��ҵ� >>");
		System.out.println(arr.get(0));
		System.out.println("<<MyArray 3�� index�� ����� ��ҵ� >>");
		System.out.println(arr.get(3));
		
		arr.remove(3);
		System.out.println("<<MyArray 3�� index ���� ��, ���� ��ҵ� >>");
		System.out.println(arr.toString());
		
		arr.add("������-4");
		System.out.println("<<���ο� ������ ��� ��, ��ҵ�>>");
		System.out.println(arr.toString());
	}

}
