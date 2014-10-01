package main;

public class Player {
	public Frame [] frame = new Frame[10];
	public int [] accumScore = new int[10];
	
	public Player() {
		for (int i = 0; i < 10; i++)
			frame[i] = new Frame();
	}
	
}
