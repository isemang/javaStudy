package binaryTree;

import java.util.*;

public class BinaryTreeTest {

	public static void main(String[] args) {
		
		Node<Character> n8 = new Node<Character>('H', null, null);
		Node<Character> n7 = new Node<Character>('G', null, null);
		Node<Character> n6 = new Node<Character>('F', null, null);
		Node<Character> n5 = new Node<Character>('E', n8, null);
		Node<Character> n4 = new Node<Character>('D', null, n7);
		Node<Character> n3 = new Node<Character>('C', null, n6);
		Node<Character> n2 = new Node<Character>('B', n4, n5);
		Node<Character> n1 = new Node<Character>('A', n2, n3);
		
		/** ������ ���� Ʈ���� �ϼ���!
		 * 					A
		 * 				   / \
		 * 				  B   C
		 * 				 / \   \
		 * 				D   E   F
		 * 				\   /
		 * 				 G H
		 */
		
		BinaryTree<Character> bTree = new BinaryTree<Character>(n1);
		System.out.print("���� ��ȸ: ");
		bTree.preorder(bTree.getRoot());
		System.out.println();
		
		System.out.print("���� ��ȸ: ");
		bTree.inorder(bTree.getRoot());
		System.out.println();
		
		System.out.print("���� ��ȸ: ");
		bTree.postorder(bTree.getRoot());
		System.out.println();
		
		System.out.print("���� ��ȸ: ");
		bTree.leveleorder(bTree.getRoot());
		System.out.println();
		
		System.out.println("Ʈ���� ũ��: "+ bTree.size(bTree.getRoot()));
		
		//��Ʈ�� �ִ� Ʈ�� = Level 1
		//�׻� level1���� ����!
		System.out.println("Ʈ���� ����: "+ bTree.height(bTree.getRoot()));

	}

}
