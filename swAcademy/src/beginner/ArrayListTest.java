package beginner;
import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Double> aList = new ArrayList<>();
		aList.add(9.5);
		aList.add(8.4);
		aList.add(1, 9.2);
		aList.add(9.5);
		
		System.out.println(aList.toString());
		
		double minScore = 100;
		double maxScore = 0;
		double score = 0;
		
		for (int i=0; i<aList.size(); i++) {
			score = aList.get(i);
			if (minScore >= score) {
				minScore = score;
			}
			if (maxScore <= score) {
				maxScore = score;
			}
		}
		System.out.println(minScore+" , "+maxScore);
		
	}

}
