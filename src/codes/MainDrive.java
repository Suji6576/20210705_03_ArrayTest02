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
			
			
		}
		
		
	}

}
