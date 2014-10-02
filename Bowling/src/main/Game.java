package main;

import java.util.Scanner;

public class Game {
	public Player [] player;
	
	public void play() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("************ Welcome to < B O W L I N G _ G A M E > ************");
		System.out.print("Input Player Number : ");
		int playerCount = scanner.nextInt();
		
		createPlayer(playerCount);
		
		for ( int frameNum = 0; frameNum < 10; frameNum++) {
			System.out.println("Now is frame " + (frameNum + 1) + ".");
			for ( int playerNum = 0; playerNum < playerCount; playerNum++) {
				System.out.println("-----------------------");
				System.out.println("Player " + (playerNum + 1) + " turn.");
				inputScore(scanner, playerNum, frameNum);
				System.out.println("-----------------------");
				
				player[playerNum].calcScore(frameNum);
				
				Print print = new Print();
				print.basicBoard();
				print.scoreBoard(player, playerNum, frameNum);
			}
			
		}
		
		
		scanner.close();
	}

	private void inputScore(Scanner scanner, int playerNum, int frameNum) {
		Frame frame = player[playerNum].frame[frameNum];

		do {
			System.out.print("first score : ");
			int first = scanner.nextInt();
			frame.first = first;
		} while (frame.first > 10);	
			
		if (frame.first != 10) {
			do {
				System.out.print("second score : ");
				int second = scanner.nextInt();
				frame.second = second;
			} while (frame.second > 10);
		}
			
		if (frameNum == 9){
			if (frame.isSpare()) {
				System.out.print("third score : ");
				int third = scanner.nextInt();
				player[playerNum].frame[10].first = third;
			}
			else if (frame.isStrike()) {
				System.out.print("second score : ");
				int second = scanner.nextInt();
				player[playerNum].frame[10].first = second;
				
				System.out.print("third score : ");
				int third = scanner.nextInt();
				player[playerNum].frame[10].second = third;
			}
		}
			
		
	}

	private void createPlayer(int playerCount) {
		player = new Player [playerCount];
		for ( int i = 0; i < playerCount; i++ ) {
			player[i] = new Player();
		}
	}
	
	
	
}
