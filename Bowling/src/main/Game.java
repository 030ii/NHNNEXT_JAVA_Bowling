package main;

import java.util.Scanner;

public class Game {
	public Player [] player;
	
	public void play() {
		Scanner scanner = new Scanner(System.in);
		int playerCount = scanner.nextInt();
		
		createPlayer(playerCount);
		
		for ( int frameNum = 0; frameNum < 10; frameNum++) {
			for ( int playerNum = 0; playerNum < playerCount; playerNum++) {
				inputScore(scanner, player[playerNum].frame[frameNum]);
				
				
				// 출력하는 과정
			}
			
		}
		
		
		scanner.close();
	}

	private void inputScore(Scanner scanner, Frame frame) {
		int first = scanner.nextInt();
		frame.first = first;
		
		if (first != 10) {
			int second = scanner.nextInt();
			frame.second = second;
		}
		
	}

	private void createPlayer(int playerCount) {
		player = new Player [playerCount];
		for ( int i = 0; i < playerCount; i++ ) {
			player[i] = new Player();
		}
	}
	
	
	
}
