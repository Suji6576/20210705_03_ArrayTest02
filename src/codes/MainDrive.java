package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		
//		숫자 야구 게임을 만듭니다.
//		긴 풀이가 될 예정입니다. 단계별로 다시 복습해주세요.
		
// 		문제로 출제 된 숫자 3개를 저장할 배열
		int[] questionNumbers = new int[3];
		
//		3칸의 배열에 숫자를 저장할 for문.
		
		for (int i=0 ; i < questionNumbers.length ; i++) {
			
//			1. 1~9의 숫자만 사용. => 1~9 중 하나를 랜덤으로 생성. (안배운 부분 활용)
			
//			2. 774 등 중복된 숫자는 막아야 함. => 뽑힌 랜덤 숫자가 문제 숫자 안에 들어있는지(사용해도 되는지) 검사.
			
//			3. 검사를 통과 했다면 배열에 집어넣자. 아니면 다시 뽑게. => 올바른 숫자가 나올때까지 해당 자리를 다시 뽑자.
//			  => while 이용한 무한반복 사용.
			
			while (true) {
				
//				1 < 랜덤값 * 9+1 < 10    : 0 < 랜덤값 <10
				
				int randomNum = (int) (Math.random()*9+1);
				
//				중복검사 통과 여부 저장. => 일단 괜찮다고 했다가 > 중복값을 말하면, 안괜찮도록 변경.
				boolean isDuplOk = true;
				
				for ( int num : questionNumbers ) {
					if (randomNum == num) {
//						중복된 숫자 발견! 더이상 중복검사 통과 X.
						isDuplOk = false;
					}
				}
				
//				만약 중복검사 결과가 true로 유지되어있다면 => 사용해도 좋은 랜덤값.
				if (isDuplOk) {
//					해당 위치에 랜던값 대입.
					questionNumbers[i] = randomNum;
//					다음 숫자를 뽑으러 가야 함. => while반복을 깨야, 다음 for 차례로 이동.
					break;
				}
				
				
			}
			
		}
		
		
//		사용자에게 3자리 숫자를 무한히 입력받아보자.
//		몇 번 입력해야 3S가 될까? => 반복횟수가 불명확한 반복. => 무한 while문으로 활용.
		
		Scanner myScan = new Scanner(System.in);
		
//		정답입력을 몇 번 시도했는지 저장할 변수
		int tryCount = 0;
		
		while (true) {
			
			System.out.print("3자리 숫자 입력 : ");
			int inputNum = myScan.nextInt();
			
//			시도횟수 1회 증가.
			tryCount++;
			
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
			
//			만약 3S라면? => 정답맞춘 케이스. => 추가입력받을 필요없음 => while반복을 깨고 나가면 프로그램 종료.
			if (strikeCount == 3) {
				System.out.println("축하합니다!");
				System.out.println(tryCount + "회 만에 맞췄습니다!");
				break;
			}
		}
		
		
	}

}
