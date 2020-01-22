package binarySearchTree;

//이진탐색트리
//01.21
public class BST<Key extends Comparable<Key>, Value> {

	public Node root;
	
	public Node getRoot() {
		return root;
	}
	
	public BST(Key key, Value value) {
		root = new Node(key, value);
	}
	
	//get, put, min, deleteMin, delete 메소드 선언
	//1) get 메서드(탐색) ********
	public Value get(Key key) {	return get(root, key);}
	public Value get(Node node, Key key) {
		if (node == null) return null;
		int t = node.getKey().compareTo(key);
		if (t > 0) return get(node.getLeft(), key);
		else if (t < 0) return get(node.getRight(), key);
		else return (Value) node.getValue();
	}
	
	//2) put 메서드(삽입)
	public void put(Key key, Value value) {	root = put(root, key, value);}
	////꼭 꼭 다시보기 ㅠ ㅁ ㅠ
	public Node put(Node node, Key key, Value value) {
		if (node == null) return new Node(key, value);
		int t = node.getKey().compareTo(key);
		if (t > 0) node.setLeft(put(node.getLeft(), key, value));
		else if (t < 0) node.setRight(put(node.getRight(), key, value));
		else node.setValue(value);
		return node;
	}
	
	public void inorder(Node node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.print(node.getKey()+":"+node.getValue()+" ");
			inorder(node.getRight());
		}
	}
	
	//3) min 메서드(최솟값 찾기)
	public Key min() {
		if (root == null) return null;
		return (Key) min(root).getKey();
	}
	//(Key)로 캐스팅을 해야 하는 이유 ? ! ㅠㅠ ㅠㅠ ㅠㅠ ㅠㅠㅠ
	
	public Node min(Node node) {
		if (node.getLeft() == null) return node;
		return min(node.getLeft());
	}
	
	public void deleteMin() {
		if (root == null) System.out.println("empty tree");
		else root = deleteMin(root);
	}
	
	private Node deleteMin(Node node) {
		if (node.getLeft() == null) return node.getRight();
		node.setLeft(deleteMin(node.getLeft()));
		return node;
	}
	
}