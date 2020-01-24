package bHeap;

public class BHeap<Key extends Comparable<Key>, Value> {
	//BST�� �ٸ��� BHeap���� �迭�� ����ϴ� ���� !!
	//createHeap, downHeap ���� �� ����Ʈ���� ������ �̿��ϱ� ����!
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
		if (k > 0) 	return true;	//--> hArray[i] > hArray[j] ��� ��
		else		return false;	//--> hArray[i] <= hArray[j] ��� ��
	}
	
	private void swap(int i, int j) {
		Entry temp = hArray[i];
		hArray[i] = hArray[j];
		hArray[j] = temp;		
	}
	
	// createHeap, put, deleteMin, downHeap, upHeap �޼ҵ� ����
	
}