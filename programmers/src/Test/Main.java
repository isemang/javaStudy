package Test;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());	//올라가야 하는 우물의 높이
		double U = Double.parseDouble(st.nextToken());	//하루에 올라갈 수 있는 거리
		int D = Integer.parseInt(st.nextToken());	//자는동안 미끄러져 내려오는 거리
		int F = Integer.parseInt(st.nextToken());	//달팽이의 피로도
		
		double dayDec = U*F/100;	//매일마다 올라가는 거리의 감소양
		double cntH = 0;					//달팽이가 올라가있는 거리
		String answer = "Failure";
		int day = 0;					//날짜 표시기
		
		while(U>=0){
			day++;
			//달팽이가 올라갑니다
			cntH = cntH+U;
			//만약에 이 때 올라간 높이(cntH)>=H일 경우 -> break 합니다
			if(cntH>=H)	{
				answer = "Success";
				break;
			}
			//달팽이가 미끄러집니다 (오늘 하루의 최종 올라간 높이입니다)
			cntH = cntH-D;
			//달팽이가 피로도가 쌓입니다(U=U-dayDec)
			U = U-dayDec;
			
		}
		
		System.out.println(answer+" "+day);
	}
}
