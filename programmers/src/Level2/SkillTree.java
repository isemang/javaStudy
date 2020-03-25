package level2;

public class SkillTree {
//스킬트리
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] s = {"BACDEP", "CBADFP", "AECBP", "BDPA","CDBP","ACBD"};
		String [] s2 = {"REA", "POA", "POT"};
//		System.out.println(solution("ACBDP", s));
		System.out.println(solution("REA",s2));
		//BACDP/ CBADP/ ACBP/ BDAP/ CDBP
	}
	
	static int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        String[] sk = skill.split("");
        String[] res = new String[skill_trees.length];
        for (int t=0; t<skill_trees.length; t++){
            String[] tree = skill_trees[t].split("");
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<tree.length; i++){
                for(int j=0; j<sk.length; j++){
                    if(tree[i].equals(sk[j])){
                        sb.append(tree[i]);
                        break;
                    }
                }
            }
            res[t] = sb.toString();
        }
    
        for (int i=0; i<res.length; i++) {
        	String[] n = res[i].split("");
        	for(int j=0; j<n.length; j++) {
        		if(n[j].equals(sk[j]) || n[j].equals("")) continue;
            	else {

            		answer--;
            		break;
            	}
        	}
        }
        return answer;
    }
}
