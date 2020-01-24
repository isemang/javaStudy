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
		
		/** 다음과 같은 트리가 완성됨!
		 * 					A
		 * 				   / \
		 * 				  B   C
		 * 				 / \   \
		 * 				D   E   F
		 * 				\   /
		 * 				 G H
		 */
		
		BinaryTree<Character> bTree = new BinaryTree<Character>(n1);
		System.out.print("전위 순회: ");
		bTree.preorder(bTree.getRoot());
		System.out.println();
		
		System.out.print("중위 순회: ");
		bTree.inorder(bTree.getRoot());
		System.out.println();
		
		System.out.print("후위 순회: ");
		bTree.postorder(bTree.getRoot());
		System.out.println();
		
		System.out.print("레벨 순회: ");
		bTree.leveleorder(bTree.getRoot());
		System.out.println();
		
		System.out.println("트리의 크기: "+ bTree.size(bTree.getRoot()));
		
		//루트만 있는 트리 = Level 1
		//항상 level1부터 시작!
		System.out.println("트리의 높이: "+ bTree.height(bTree.getRoot()));

	}

}
