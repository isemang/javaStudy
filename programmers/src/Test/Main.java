package Test;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());	//�ö󰡾� �ϴ� �칰�� ����
		double U = Double.parseDouble(st.nextToken());	//�Ϸ翡 �ö� �� �ִ� �Ÿ�
		int D = Integer.parseInt(st.nextToken());	//�ڴµ��� �̲����� �������� �Ÿ�
		int F = Integer.parseInt(st.nextToken());	//�������� �Ƿε�
		
		double dayDec = U*F/100;	//���ϸ��� �ö󰡴� �Ÿ��� ���Ҿ�
		double cntH = 0;					//�����̰� �ö��ִ� �Ÿ�
		String answer = "Failure";
		int day = 0;					//��¥ ǥ�ñ�
		
		while(U>=0){
			day++;
			//�����̰� �ö󰩴ϴ�
			cntH = cntH+U;
			//���࿡ �� �� �ö� ����(cntH)>=H�� ��� -> break �մϴ�
			if(cntH>=H)	{
				answer = "Success";
				break;
			}
			//�����̰� �̲������ϴ� (���� �Ϸ��� ���� �ö� �����Դϴ�)
			cntH = cntH-D;
			//�����̰� �Ƿε��� ���Դϴ�(U=U-dayDec)
			U = U-dayDec;
			
		}
		
		System.out.println(answer+" "+day);
	}
}
