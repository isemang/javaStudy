public class newIdRecommend {
    public static void main(String[] args) {
        System.out.println(solution("(0-9a-z-_.) ()"));
       // System.out.println(solution(""));
    }

    public static String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        char[] idArr = new_id.toCharArray();
        for(int i=0; i<idArr.length; i++) {
            int num = (int) idArr[i];
            if (num >= 65 && num <= 90) {
                idArr[i] = (char) ((int) idArr[i] + 32);
                continue;
            }
        }
        for(int i=0; i<idArr.length; i++) {
            int num = (int) idArr[i];
            if (num < 97 || num > 122) {    //소문자도 아니고
                if (num < 48 || num > 57) {         //숫자도 아니고
                    if (num != 45 && num != 95 && num != 46) {//. - _ 도 아니면
                        idArr[i] = '@';
                        continue;
                    }
                }
            }
        }
        for(int i=0; i<idArr.length; i++) {
            int num = (int) idArr[i];
            if (num == 46 && i < idArr.length - 1) {
                if ((int) idArr[i + 1] == 46) {
                    idArr[i] = '@';
                    continue;
                }
            }
        }

        for(int i=0; i<idArr.length; i++){
            if(idArr[i] == '.' && sb.length() == 0) {
                idArr[i] = '@';
                continue;
            }
            if(sb.length() !=0){
                if(idArr[i] =='.' && sb.lastIndexOf(".") == sb.length()-1){
                    idArr[i] = '@';
                    continue;
                }
            }
            if(idArr[i] != '@'){
                sb.append(idArr[i]);
            }
        }

        if(sb.length() != 0) {
            if (sb.lastIndexOf(".") == sb.length() - 1)
                sb.deleteCharAt(sb.length() - 1);
        }

        if(sb.length() <3) {
            int len = sb.length();
            if (len == 0) {
                for (int i = 0; i < 3 - len; i++) {
                    sb.append("a");
                }
            }
            else {
                for (int i = 0; i < 3 - len; i++) {
                    sb.append(sb.charAt(sb.length() - 1));
                }
            }
        }

        if(sb.length() > 15) {
            int len = sb.length();
            for(int i=0; i<len-15; i++){
                sb.deleteCharAt(len-i-1);
            }
            if(sb.length() == 15 && sb.indexOf(".") == 14) sb.deleteCharAt(14);
        }
        return sb.toString();
    }
}

