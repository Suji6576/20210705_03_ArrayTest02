package codes;

import java.util.Scanner;

public class MainDrive {
	
	public static void main(String[] args) {
		


		int[] questionNumbers = new int[3];

		
		for (int i=0 ; i < questionNumbers.length ; i++) {
			

			while (true) {
				
		
				int randomNum = (int) (Math.random()*9+1);
				

				boolean isDuplOk = true;
				
				for ( int num : questionNumbers ) {
					if (randomNum == num) {
						isDuplOk = false;
					}
				}
				
				if (isDuplOk) {
					questionNumbers[i] = randomNum;
					break;
				}
				
				
			}
			
		}
		
	
		Scanner myScan = new Scanner(System.in);
		
		int tryCount = 0;
		
		while (true) {
			
			System.out.print("3자리 숫자 입력 : ");
			int inputNum = myScan.nextInt();
			
			tryCount++;
			
			int[] inputNumbers = new int[3];
			
			inputNumbers[0] = inputNum / 100;
			inputNumbers[1] = inputNum / 10 % 10;
			inputNumbers[2] = inputNum % 10;
			
			int strikeCount = 0;
			int ballCount = 0;
			
			for (int i=0 ; i < inputNumbers.length ; i++) {
				
				for (int j = 0 ; j < questionNumbers.length ; j++) {
					
					
					if (inputNumbers[i] == questionNumbers[j]) {
						if ( i==j ) {
							strikeCount++;
						}
						
						else {
							ballCount++;
						}
						
					}				
					
					
					
				}
				
			}
			System.out.println(strikeCount+"S " + ballCount+"B 입니다.");
			
			if (strikeCount == 3) {
				System.out.println("축하합니다!");
				System.out.println(tryCount + "회 만에 맞췄습니다!");
				break;
			}
		}
		
		
	}

}
