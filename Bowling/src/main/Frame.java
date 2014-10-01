package main;

public class Frame {
	public int first;
	public int second;
	
	public boolean isStrike() {
		if (first == 10)
			return true;
		else
			return false;
	}
	
	public boolean isSpare() {
		if (first + second == 10 && first != 10) 
			return true;
		else
			return false;
	}
	
	public boolean isOpen() {
		if (first + second < 10)
			return true;
		else
			return false;
	}
}
