package bHeap;

public class BHeap<Key extends Comparable<Key>, Value> {
	//BST랑 다르게 BHeap에서 배열을 사용하는 이유 !!
	//createHeap, downHeap 구현 시 이진트리의 성질을 이용하기 때문!
	private Entry[] hArray;
	private int N; //size

	public BHeap(Entry[] hArray, int N) {
		this.hArray = hArray;
		this.N = N;
	}
	
	public int size() {
		return N;
	}
	
	private boolean isGreater(int i, int j) {
		int k = hArray[i].getKey().compareTo(hArray[j].getKey());
		if (k > 0) 	return true;	//--> hArray[i] > hArray[j] 라는 뜻
		else		return false;	//--> hArray[i] <= hArray[j] 라는 뜻
	}
	
	private void swap(int i, int j) {
		Entry temp = hArray[i];
		hArray[i] = hArray[j];
		hArray[j] = temp;		
	}
	
	// createHeap, put, deleteMin, downHeap, upHeap 메소드 선언
	
}