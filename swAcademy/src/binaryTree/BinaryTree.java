package binaryTree;
//2020.01.16

import java.util.*;

public class BinaryTree<Key> {
	private Node<Key> root;
	
	//BinaryTree(n)�̶�� Main���� ������ �������ָ� n�� root�� ��!
	public BinaryTree(Node<Key> root) {
		this.root = root;
	}
	
	public Node<Key> getRoot() {
		return root;
	}
	
	public void setRoot(Node<Key> root) {
		this.root = root;
	}
	
	public boolean isEmpty() {
		if(root == null) return true;
		else			 return false;
	}
	
	//preorder(), inorder(), postorder(), levelorder()
	//size(), height() �� 6���� �޼��带 ���ʴ�� �����غ���!
	
	//1) preorder: ������ȸ �޼���(�� -> �� -> �� ������ ��ȸ)
	//**�ʱ� preorder �ڵ�**
//	public void preorder() {
//		if (root == null)	root.getRight();
//		else				root.getLeft();
//	}
	
	//TODO �̷��� �Ǹ� preorder(n.getLeft()); �ٸ� ����Ǵ°� �ƴϾ� ??
	public void preorder(Node<Key> n) {
		if (n != null) {
			System.out.print(n.getItem()+" ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	//2) inorder: ������ȸ �޼���(�� -> �� -> �� ������ ��ȸ)
	//**�ʱ� inorder �ڵ�**
	public void inorder(Node<Key> n) {
		if (n != null) {
			inorder(n.getLeft());
			System.out.print(n.getItem()+" ");
			inorder(n.getRight());
		}
	}
	
	//3) postorder: ������ȸ �޼���(�� -> �� -> �� ������ ��ȸ)
	//**�ʱ� postorder �ڵ�**
	public void postorder(Node<Key> n) {
		if (n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getItem()+" ");
		}
	}
	
	//4) levelorder: ������ȸ �޼���(å�� �д� �Ͱ� ���� �������� ������ �¿��� ��� �湮)
	//**�ʱ� levelorder �ڵ�**
//	public void levelorder(Node n) {
//		if (n.getRight() != null) {
//			System.out.println(n.getItem()+" ");
//			levelorder(n.getLeft());
//			//....�Ф� getRight() == null�� ��� ... �쿨
//		}
//	}
	//��Ʈ: ť ���
	//**ť ��� ��Ʈ �� levelorder �ڵ�**
	public void leveleorder(Node<Key> n) {
		Queue<Node> q = new LinkedList<Node>();
		Node t;
		q.add(root);
		while(!q.isEmpty()) {
			t = q.remove();		//ť���� ���� �տ� �ִ� ��� ����
			System.out.print(t.getItem()+" "); 	//���ŵ� ��� ���(�湮)
			if(t.getLeft() != null)				//���ŵ� ���� �ڽ��� null�� �ƴϸ�
				q.add(t.getLeft());				//ť�� ���� �ڽ� ����
			if(t.getRight() != null)			//���ŵ� ������ �ڽ��� null�� �ƴϸ�
				q.add(t.getRight());			//ť�� ������ �ڽ� ����
		}
		
	}
	
	//5) size: ����Ʈ���� ��� ���� ���ϴ� �޼���
	//**�ʱ� size �ڵ�** preorder�� �ϸ鼭 �� ������ ���� ���� ������ ??
	// --> �ƴ�. �ʹ� �ڵ尡 ���������� ������ ��� �䱸��
	//**�ٽ� ���̵��: Ʈ����  ��� �� = 1+(��Ʈ����� ���� ����Ʈ���� �ִ� ��� ��)+(��Ʈ����� ������ ����Ʈ���� �ִ� ��� ��)
	public int size(Node<Key> n) {
		if(n == null)	return 0;
		else			return 1+size(n.getLeft())+size(n.getRight());
	}
	
	//6) height: ����Ʈ���� ����(����)�� ���ϴ� �޼���
	//**�ʱ� height �ڵ�** size�� �������ιٲ۴� -> ������ �ڸ���-1 = height
	// --> �̰͵� �ƴ�. �ڵ尡 �ʹ� ���������� ������ ��� �䱸��
	//**�ٽ� ���̵��: Ʈ���� ���� = ������ ������ ���� ���� �� �� ���� ������ 1 ���� ��!
	// ���� ���� => �� ���� = max(������ ����, ������ ����)+1
	public int height(Node<Key> n) {
		if(n == null)	return 0;
		else			return Math.max(height(n.getLeft()), height(n.getRight()))+1;
	}

}
