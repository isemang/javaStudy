package binaryTree;
//2020.01.16

import java.util.*;

public class BinaryTree<Key> {
	private Node<Key> root;
	
	//BinaryTree(n)이라고 Main에서 생성자 설정해주면 n이 root가 됨!
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
	//size(), height() 총 6가지 메서드를 차례대로 구현해보자!
	
	//1) preorder: 전위순회 메서드(근 -> 좌 -> 우 순으로 순회)
	//**초기 preorder 코드**
//	public void preorder() {
//		if (root == null)	root.getRight();
//		else				root.getLeft();
//	}
	
	//TODO 이렇게 되면 preorder(n.getLeft()); 줄만 실행되는거 아니야 ??
	public void preorder(Node<Key> n) {
		if (n != null) {
			System.out.print(n.getItem()+" ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}
	
	//2) inorder: 중위순회 메서드(좌 -> 근 -> 우 순으로 순회)
	//**초기 inorder 코드**
	public void inorder(Node<Key> n) {
		if (n != null) {
			inorder(n.getLeft());
			System.out.print(n.getItem()+" ");
			inorder(n.getRight());
		}
	}
	
	//3) postorder: 후위순회 메서드(좌 -> 우 -> 근 순으로 순회)
	//**초기 postorder 코드**
	public void postorder(Node<Key> n) {
		if (n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getItem()+" ");
		}
	}
	
	//4) levelorder: 레벨순회 메서드(책을 읽는 것과 같은 형식으로 레벨별 좌에서 우로 방문)
	//**초기 levelorder 코드**
//	public void levelorder(Node n) {
//		if (n.getRight() != null) {
//			System.out.println(n.getItem()+" ");
//			levelorder(n.getLeft());
//			//....ㅠㅠ getRight() == null일 경우 ... 우엥
//		}
//	}
	//힌트: 큐 사용
	//**큐 사용 힌트 후 levelorder 코드**
	public void leveleorder(Node<Key> n) {
		Queue<Node> q = new LinkedList<Node>();
		Node t;
		q.add(root);
		while(!q.isEmpty()) {
			t = q.remove();		//큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getItem()+" "); 	//제거된 노드 출력(방문)
			if(t.getLeft() != null)				//제거된 왼쪽 자식이 null이 아니면
				q.add(t.getLeft());				//큐에 왼쪽 자식 삽입
			if(t.getRight() != null)			//제거된 오른쪽 자식이 null이 아니면
				q.add(t.getRight());			//큐에 오른쪽 자식 삽입
		}
		
	}
	
	//5) size: 이진트리의 노드 수를 구하는 메서드
	//**초기 size 코드** preorder를 하면서 그 개수를 세면 되지 않으까 ??
	// --> 아님. 너무 코드가 복잡해지고 과도한 계산 요구됨
	//**핵심 아이디어: 트리의  노드 수 = 1+(루트노드의 왼쪽 서브트리에 있는 노드 수)+(루트노드의 오른쪽 서브트리에 있는 노드 수)
	public int size(Node<Key> n) {
		if(n == null)	return 0;
		else			return 1+size(n.getLeft())+size(n.getRight());
	}
	
	//6) height: 이진트리의 레벨(높이)를 구하는 메서드
	//**초기 height 코드** size를 이진수로바꾼다 -> 이진수 자릿수-1 = height
	// --> 이것도 아님. 코드가 너무 복잡해지고 과도한 계산 요구됨
	//**핵심 아이디어: 트리의 높이 = 오른쪽 레벨과 왼쪽 레벨 중 더 높은 레벨에 1 더할 것!
	// 따라서 수식 => 총 높이 = max(오른쪽 레벨, 오른쪽 레벨)+1
	public int height(Node<Key> n) {
		if(n == null)	return 0;
		else			return Math.max(height(n.getLeft()), height(n.getRight()))+1;
	}

}
