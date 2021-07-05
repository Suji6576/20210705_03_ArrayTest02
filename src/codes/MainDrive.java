package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
//		숫자 야구 게임을 만듭니다.
//		긴 풀이가 될 예정입니다. 단계별로 다시 복습해주세요.
		
//		임시 : 3자리 숫자를  => 3칸짜리 배열에 나눠서 저장. ex.741
		
		int[] questionNumbers = new int[3];
		
//		임시 : 직접 741 숫자를 저장.
//		향후 : 컴퓨터가 랜덤숫자 3개 뽑아서 저장
		
		questionNumbers[0] = 7;
		questionNumbers[1] = 4;
		questionNumbers[2] = 1;
		
		
//		사용자에게 3자리 숫자를 무한히 입력받아보자.
//		몇 번 입력해야 3S가 될까? => 반복횟수가 불명확한 반복. => 무한 while문으로 활용.
		
		Scanner myScan = new Scanner(System.in);
		
		while (true) {
			System.out.print("3자리 숫자 입력 :");
			int inputNum = myScan.nextInt();
			
//			입력받은 숫자도 => 세 자리 배열에 나눠서 저장.
//			1,2,3 => [1,2,3]
			
			int[] inputNumbers = new int[3];
			
//			0번 칸 : 123 => 1이 들어가야. 어떻게? => 123 / 100 => 입력값을 100으로 나눈 값.
			inputNumbers[0] = inputNum / 100;
//			1번 칸 : 123 => 2이 들어가야. 어떻게? 123=> 12 => 1의 자리
			inputNumbers[1] = inputNum / 10 % 10;
//			2번 칸 : 123 => 3이 들어가야. 어떻게? 입력값을 10으로 나눈 나머지
			inputNumbers[2] = inputNum % 10;
			
//			검사를 하기 전에, S/B 갯수를 기록할 변수를 만들자.
			int strikeCount = 0;
			int ballCount = 0;
			
//			내 숫자 반복 : i
//			문제 숫자 반복 : j => for 중첩
			
			for (int i=0 ; i < inputNumbers.length ; i++) {
				
				for (int j = 0 ; j < questionNumbers.length ; j++) {
					
//					먼저 검사 : 내 숫자 / 문제 숫자가 같은가? => 배열 안에 적힌 숫자끼리 같은가?
//					같은 걸 찾았다면? 추가검사 : 둘의 위치도 같은가?
//					if문 중첩 활용.
					
					
					if (inputNumbers[i] == questionNumbers[j]) {
						
//						추가질문 : S / B => 둘의 위치가 같은가? 다른가? => i와 j가 같은가? 다른가?
						if ( i==j ) {
//							숫자도 같은데 위치가지 같다 => S 하나 발견
							strikeCount++;
						}
						
						else {
//							숫자는 같지만, 위치만 다르다 => B 하나 발견.
							ballCount++;
						}
						
					}				
					
					
					
				}
				
			}
//			?S ?B이 되었는지 출력.
			System.out.println(strikeCount+"S " + ballCount+"B 입니다.");
			
			
		}
		
		
	}

}
