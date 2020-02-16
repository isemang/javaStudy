package swKit;

//«¡∏∞≈Õ
import java.util.*;

public class StackQueue4 {

	public static void main(String[] args) {

		int[] priorities = { 2, 1, 3, 2 };
		int[] priorities2 = { 1, 1, 9, 1, 1, 1 };
		int[] p = {1,2,2,3,4,5};
		
		int location = 2;
		int location2 = 0;
		
//		solution(p,location);
//		solution(priorities, location);
		solution(priorities2, location2);
	}

	static void solution(int[] priorities, int location) {
		int answer = 0;
		ArrayList<Print> impList = new ArrayList<>();
		Queue<Print> pQueue = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			impList.add(new Print(i, priorities[i]));
		}

		Collections.sort(impList,Collections.reverseOrder());

		for (int i=0; i<impList.size(); i++) {
			System.out.println(impList.get(i).toString());
		}
		System.out.println();
//		return answer;
	}
}

class Print implements Comparable<Print> {
	int idx;
	int imp;

	Print(int idx, int imp) {
		this.idx = idx;
		this.imp = imp;
	}

	public int getIdx() { return idx;	}
	public int getImp() { return imp;	}
	
	@Override
	public String toString() {
		return "Index\t" + idx + "\tImportant\t" + imp;
	}
	int i=0;
	
	@Override
	public int compareTo(Print p) {
		System.out.println("This\t" + toString() + "\tCompare\t" + p.toString());
		if(this.imp > p.imp) {
			return 1;
		} else {
			return -1;
		}
		
//		if(this.imp > p.imp) {
//			return 1;
//		}
//		else if(this.imp < p.imp) {
//			return -1;
//		}
//		else {
//			return 0;
//		}
	}

}
