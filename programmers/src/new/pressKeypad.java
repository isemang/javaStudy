import java.util.ArrayList;

public class pressKeypad {
    public static void main(String[] args) {
        int[] n = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        System.out.println(solution(n, "right")); //"LRLLLRLLRRL" 답
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;  //첫 시작은 *이지만 편의상 10으로 설정 / 왼쪽 엄지의 위치
        int right = 11; //첫 시작은 #이지만 편의상 11으로 설정 / 오른쪽 엄지의 위치
        int [][] phoneArr = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};

        for(int i=0; i<numbers.length; i++){
            int n = numbers[i];
            if(n ==1 || n ==4 || n ==7){
                left = n; //왼쪽 엄지의 위치를 변경
                sb.append('L');
                continue;
            } else if(n ==3 || n ==6 || n ==9){
                right = n; //오른쪽 엄지의 위치를 변경
                sb.append('R');
                continue;
            } else {
                int lres = Math.abs(phoneArr[n][0]-phoneArr[left][0])+Math.abs(phoneArr[n][1]-phoneArr[left][1]);
                int rres = Math.abs(phoneArr[n][0]-phoneArr[right][0])+Math.abs(phoneArr[n][1]-phoneArr[right][1]);
                if(lres>rres) {
                    right = n; //오른쪽 엄지의 위치를 변경
                    sb.append('R');
                    continue;
                } else if(lres<rres) {
                    left = n; //왼쪽 엄지의 위치를 변경
                    sb.append('L');
                    continue;
                } else {
                    if(hand.equals("left")) {
                        left = n; //왼쪽 엄지의 위치를 변경
                        sb.append('L');
                        continue;
                    } else {
                        right = n; //오른쪽 엄지의 위치를 변경
                        sb.append('R');
                        continue;
                    }
                }
            }
        }
        return sb.toString();
    }
}
