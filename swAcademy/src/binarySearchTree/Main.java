package binarySearchTree;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node<Integer, String> n2 = new Node<Integer, String>(30,"lemon");
		Node n3 = new Node(80,"mango");
		Node n4 = new Node(10,"cherry");
		Node n5 = new Node(40, "orange");
		Node n6 = new Node(90, "lime");
		
		BST<Integer, String> bst = new BST<Integer, String>(50,"apple");
		bst.root.setLeft(n2);
		bst.root.setRight(n3);
		n2.setLeft(n4);
		n2.setRight(n5);
		n3.setRight(n6);
		
		System.out.println("1) ������ȸ: (���� p.157 [�׸� 5-8])");
		bst.inorder(bst.root);
		System.out.println("\n\n2) Ž�� ���� �ǽ�: 40 ->");
		System.out.println("Ž�����: "+bst.get(40));
		
		System.out.println("\n3) ���� ���� �ǽ�: 35-pear");
		bst.put(35, "pear");
		bst.inorder(bst.root);
		
		System.out.println("\n\n�ּҰ� ����: (���� p.159 [�׸� 5-10])");
		bst.put(15, "tomato");
		bst.inorder(bst.root);
		
		System.out.println("\n\n 4) �ּҰ� ã�� �ǽ�= "+bst.min());
		
		System.out.println("\n5 �ּڰ� ���� ���� �ǽ�");
		bst.deleteMin();
		bst.inorder(bst.root);

	}

}

