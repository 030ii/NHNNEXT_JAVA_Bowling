package main;

public class Print {
	public void basicBoard() {
		System.out.println("=====================================================================");
		System.out.println("|     |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |   10  |");	
	}
	public void scoreBoard(Player [] player, int playerNum, int frameNum) {
		for (int i = 0; i < player.length; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("|");
			sb.append("  " + (i + 1) + "  ");
			sb.append("|");
			
			for ( int j = 0; j < 9; j++) {
				int first = player[i].frame[j].first;
				int second = player[i].frame[j].second;
				
				if (j < frameNum || (j == frameNum && i <= playerNum) ) {
					sb.append(" ");
					sb.append(frameScore(first));
					sb.append(" ");
					if (first != 10) {
						sb.append(frameScore(second));
						sb.append(" |");
					}
					else 
						sb.append("  |");
				}
				else {
					sb.append("     |");
				}
			}
			
			if (frameNum == 9 && i <= playerNum) {
				if (player[i].frame[9].isOpen()) {
					int first = player[i].frame[9].first;
					int second = player[i].frame[9].second;
					
					sb.append(" ");
					sb.append(frameScore(first));
					sb.append(" ");
					sb.append(frameScore(second));
					sb.append("   |");
				}
	
				if (player[i].frame[9].isSpare()) {
					int first = player[i].frame[9].first;
					int second = player[i].frame[9].second;
					int third = player[i].frame[10].first;
					
					sb.append(" ");
					sb.append(frameScore(first));
					sb.append(" ");
					sb.append(frameScore(second));
					sb.append(" ");
					sb.append(frameScore(third));
					sb.append(" |");
				}
						
				if (player[i].frame[9].isStrike()) {
					int first = player[i].frame[9].first;
					int second = player[i].frame[10].first;
					int third = player[i].frame[10].second;
					
					sb.append(" ");
					sb.append(frameScore(first));
					sb.append(" ");
					sb.append(frameScore(second));
					sb.append(" ");
					sb.append(frameScore(third));
					sb.append(" |");
				}
			}
			else 
				sb.append("       |");
			
			System.out.println("---------------------------------------------------------------------");
			System.out.println(sb.toString());
			
			System.out.print("|     |");
			for ( int f = 0; f < 9; f++ ) {
				if ( player[i].accumScore[f] == -1 )
					System.out.print("     |");
				else
					System.out.printf(" %3d |", player[i].accumScore[f]);
			}
			if ( player[i].accumScore[9] == -1 )
				System.out.print("       |");
			else
				System.out.printf("  %3d  |", player[i].accumScore[9]);
		
			System.out.println();
		}
		System.out.println("=====================================================================");
	}

	public String frameScore(int num) {
		if (num == 0)
			return "-";
		else if (num == 10)
			return "X";
		else
			return Integer.toString(num);
	}
}
