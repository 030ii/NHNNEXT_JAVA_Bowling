package main;

public class Player {
	public Frame [] frame = new Frame[11];
	public int [] accumScore = new int[10];
	public Calculator calculator = new Calculator();
	
	public Player() {
		for (int i = 0; i < 11; i++)
			frame[i] = new Frame();
	}
	
	
}
