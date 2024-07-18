package com.edu.capsul;

//오늘 날짜 정보를 저장하는 클래스
public class MyDate {
	
//	public int month;
//	public int day;
	
	private int month;
	private int day;
	
	public int getMonth() {return month;}
	
	public int getDay() { return day;}
	
	//에러 메시지를 출력하는 기능 추가
	//단, 해당 클래스에서만 작성함으로 private
	private void errorMsg( String value) {
		System.out.println( value + "을 잘못 입력하셨습니다.");
		System.exit(0);
	}
	
	//방법1.
	public void setMonth(int month) {
		if( month >0 && month <=31 ) {
			this.month = month;
		}
		else {errorMsg("월");}
		
	}
	
	public void setDay(int day) {
		// 가장 많은 케이스를 default로 하기
		
		switch (day) {
		case 2:
			if( day >0 && day <=28 ) {
				this.day = day;
			}
			else { errorMsg("일");}
			break;
		
		case 4 :
		case 6 :
		case 9 :
		case 11 :
			if( day >0 && day <=30 ) {
				this.day = day;
			}
			else { errorMsg("일");}
			break;
			
		default:
			if( day >0 && day <=31 ) {
				this.day = day;
			}
			else { errorMsg("일");}
			
		}
	}
	
	//방법2.
	public void setMonthDay(int month, int day) {
		
		switch (month) {
		
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 :
			if( day >0 && day <=31 ) {
				this.month = month;
				this.day = day;
			}
			else { errorMsg("일");}
			break;
		
		case 2 :
			if( day >0 && day <=28 ) {
				this.month = month;
				this.day = day;
			}
			else { errorMsg("일");}
			break;
		
		case 4 :
		case 6 :
		case 9 :
		case 11 :
			if( day >0 && day <=30 ) {
				this.month = month;
				this.day = day;
			}
			else { errorMsg("일");}
			break;
			
		default:
			errorMsg("월");
		}
	}
	

}
