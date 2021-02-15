public class secretMap {
    public static void main(String [] args){
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        solution(5,arr1,arr2);        //출력	["#####","# # #", "### #", "# ##", "#####"]
    }
    public static void solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<arr1.length; i++){
            int oneRes = 0;
            int twoRes = 0;
            int idx = n;
            while(idx > 0) {
                oneRes = arr1[i]%2;
                arr1[i] = arr1[i]/2;

                twoRes = arr2[i]%2;
                arr2[i] = arr2[i]/2;

                if(oneRes == 1 || twoRes == 1) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
                idx--;
                if(idx == 0){
                    sb.reverse();
                    answer[i] = sb.toString();
                    sb.delete(0,sb.length());
                }
            }
        }
//
//        for(int i=0; i<answer.length; i++){
//            System.out.println(answer[i]+"aa");
//        }
//        return answer;
    }
}
