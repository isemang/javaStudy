package binarySearchTree;

public class Node<Key extends Comparable<Key>, Value> {
	private Key key;
	private Value value;
	private Node<Key, Value> left;
	private Node<Key, Value> right;
	
	public Node(Key key, Value value) {
		this.key = key;
		this.value = value;
		left = right = null;
	}
	
	public Key getKey() {
		return key;
	}
	
	public Value getValue() {
		return value;
	}
	
	public Node<Key, Value> getLeft() {
		return left;
	}
	
	public Node<Key, Value> getRight() {
		return right;
	}
	
	public void setKey(Key key) {
		this.key = key;
	}
	
	public void setValue(Value value) {
		this.value = value;
	}
	
	public void setLeft(Node<Key, Value> left) {
		this.left = left;
	}
	
	public void setRight(Node<Key, Value> right) {
		this.right = right;
	}
	
}
