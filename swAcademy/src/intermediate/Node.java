package intermediate;

//20.01.16
public class Node<Key> {
//	MyBinaryTree�� �����ϱ� ���� Ŭ����
//	NodeŬ��������
//	1) Key(��忡 ����Ǵ� ��)
//	2) �ش� ����� ���ʳ��
//	3) �ش� ����� ������ ���
//	�� �����Ǿ� �־�� ��
	private Key item;
	private Node<Key> left;
	private Node<Key> right;
	
	//Node�� ������
	//���⼭ left, right�� ��Ȯ�� �����ڸ� item(�ڽ�)�� ���� �ڽİ� ������ �ڽ��� ����!
	public Node(Key item, Node<Key> left, Node<Key> right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}
	
	//getter, setter
	//1) getter: item/left/right ���� ����ϴ�(?) �޼���, ���� return!
	//item�� ����Ÿ���� Key -> public Key getItem()�� ��
	//left�� right�� ����Ÿ���� Node<Key> -> public Node<Key> getLeft()�� ��
	public Key getItem() {
		return item;
	}
	
	public Node<Key> getLeft() {
		return left;
	}
	
	public Node<Key> getRight() {
		return right;
	}
	
	//2) setter: item, left, right�� set�ϴ�(�����ϴ�??) �޼���
	public void setItem(Key item) {
		this.item = item;
	}
	
	public void setLeft(Node<Key> left) {
		this.left = left;
	}
	
	public void setRight(Node<Key> right) {
		this.right = right;
	}

	
}