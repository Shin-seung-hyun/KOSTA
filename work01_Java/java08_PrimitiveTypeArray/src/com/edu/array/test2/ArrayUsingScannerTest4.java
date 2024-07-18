package com.edu.array.test2;

import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
 	최고, 최저 성적을 구하라
 	위 기능을 Scanner를 통해서 값을 받아들이는 로직과 연결
*/
public class ArrayUsingScannerTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean run = true;		
		
		int studentNum = 0;
		int[] scores = null;
	
		
		while(run) {
			System.out.println("--------------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------------------------");
			System.out.print("메뉴 선택> ");
		
			
			int selectNo = sc.nextInt();
			
			if(selectNo == 1) {
				System.out.println("학생수 입력 >>");
				studentNum = sc.nextInt();
				
				scores = new int[studentNum];
			}
			else if(selectNo == 2) {
				System.out.println("학생수 score >>");
				
				for(int i=0; i<studentNum; i++) {
					System.out.println( " scores[" + i + "]");
					scores[i] = sc.nextInt();
				}
				
			}
			else if(selectNo ==3) {
				System.out.println("점수 리스트 출력 >>");
				
				for(int score : scores) {
					System.out.print(score + " ");
					
				}
				System.out.println();
				
			}
			else if(selectNo ==4) {
				
				int max = 0;
				int sum =0;
				double avg = 0;
				
				//for(int score : scores) {
					//if(max < score) max = score;
				
				for(int i=0; i<studentNum; i++) {
					
					max = (max < scores[i]) ? scores[i] : max;
					sum+= scores[i];
				}
				
				avg = sum / studentNum;
				
				System.out.println("최고 점수 :" + max);
				System.out.println("평균 점수 :" + avg);
				
			}
			else if(selectNo == 5) {
			
				run = false;
			}
			
		}
		System.out.println("프로그램 종료");
		
	}

}
