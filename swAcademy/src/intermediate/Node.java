package intermediate;

//20.01.16
public class Node<Key> {
//	MyBinaryTree를 구현하기 위한 클래스
//	Node클래스에는
//	1) Key(노드에 저장되는 값)
//	2) 해당 노드의 왼쪽노드
//	3) 해당 노드의 오른쪽 노드
//	가 구현되어 있어야 함
	private Key item;
	private Node<Key> left;
	private Node<Key> right;
	
	//Node의 생성자
	//여기서 left, right는 정확히 말하자면 item(자신)의 왼쪽 자식과 오른쪽 자식을 말함!
	public Node(Key item, Node<Key> left, Node<Key> right) {
		this.item = item;
		this.left = left;
		this.right = right;
	}
	
	//getter, setter
	//1) getter: item/left/right 등을 출력하는(?) 메서드, 따라서 return!
	//item의 변수타입은 Key -> public Key getItem()이 됨
	//left와 right의 변수타입은 Node<Key> -> public Node<Key> getLeft()이 됨
	public Key getItem() {
		return item;
	}
	
	public Node<Key> getLeft() {
		return left;
	}
	
	public Node<Key> getRight() {
		return right;
	}
	
	//2) setter: item, left, right을 set하는(설정하는??) 메서드
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