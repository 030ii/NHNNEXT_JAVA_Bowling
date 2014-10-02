package main;

public class Calculator {
	public int thisIndex = 0;
	public int sum = 0;
	
	public void calcScore(Frame [] frame, int [] accumScore, int frameNum) {
		while (thisIndex <= frameNum) {
			if (frame[thisIndex].isStrike()) {
				int bonus = strikeBonus(frame, thisIndex, frameNum);
				
				if (bonus == -1)
					return;
				
				sum += 10 + bonus;
				accumScore[thisIndex] = sum;
			}
			else if (frame[thisIndex].isSpare()) {
				int bonus = spareBonus(frame, thisIndex, frameNum);
				
				if (bonus == -1)
					return;
				
				sum += 10 + bonus;
				accumScore[thisIndex] = sum;
			}
			else if (frame[thisIndex].isOpen()) {
				sum += addFirstSecond(frame[thisIndex]);
				accumScore[thisIndex] = sum;
			}
			thisIndex++;
		}
	}
	
	private int spareBonus(Frame [] frame, int thisIndex, int frameNum) {
		if (thisIndex < 9 && thisIndex + 1 > frameNum)
			return -1;
		
		return frame[thisIndex + 1].first;
	}
	
	private int strikeBonus(Frame [] frame, int thisIndex, int frameNum) {
		if (thisIndex < 9 && thisIndex + 1 > frameNum)
			return -1;
		
		if (!frame[thisIndex + 1].isStrike())
			return addFirstSecond(frame[thisIndex + 1]);
		
		if (thisIndex == 9)
			return 10 + frame[thisIndex + 1].second;
		
		if (thisIndex < 8 && thisIndex + 2 > frameNum)
			return -1;

		return 10 + frame[thisIndex + 2].first;
	}
	
	private int addFirstSecond(Frame frame) {
		return frame.first + frame.second;
	}
}
