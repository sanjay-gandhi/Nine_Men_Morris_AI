/**
 * @author Sanjay
 * Min-Max Algorithm for opening phase with improved static estimation 
 * Player = White
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MiniMaxOpeningImproved {
	static String initial;
	static char[] board;
	static int evaluatedNodes;

	MiniMaxOpeningImproved(){
		initial = FileReadWrite.getInput();
		board = initial.toCharArray();
		evaluatedNodes = 0;
	}

	public static void main(String[] args) throws IOException {
		MiniMaxOpeningImproved game = new MiniMaxOpeningImproved();
		Scanner in = new Scanner(System.in);
		int depth = in.nextInt();
		in.close();
		char player = 'W';
		char opponent = 'B';
		String[] output = game.miniMaxAlg(board,depth,player,opponent).split(" ");
		FileReadWrite.writeOutput(output[0]);
		System.out.println("Board Position : " + output[0]);
		System.out.println("Position evaluated by static estimation : " + output[1]);
		System.out.println("MINIMAX Estimate : " + output[2]);

	}

	public ArrayList<Integer> findNeighbors(int position){
		ArrayList<Integer> neighbor = new ArrayList<Integer>();
		switch(position){
		case 0 : neighbor.add(1); neighbor.add(3); neighbor.add(8); break;
		case 1 : neighbor.add(0); neighbor.add(4); neighbor.add(2); break;
		case 2 : neighbor.add(1); neighbor.add(5); neighbor.add(13); break;
		case 3 : neighbor.add(4); neighbor.add(9); neighbor.add(0); neighbor.add(6); break;
		case 4 : neighbor.add(1); neighbor.add(3); neighbor.add(5); break;
		case 5 : neighbor.add(4); neighbor.add(12); neighbor.add(2); neighbor.add(7); break;
		case 6 : neighbor.add(10); neighbor.add(7); neighbor.add(3); break;
		case 7 : neighbor.add(6); neighbor.add(11); neighbor.add(5); break;
		case 8 : neighbor.add(0); neighbor.add(9); neighbor.add(20); break;
		case 9 : neighbor.add(8); neighbor.add(10); neighbor.add(3); neighbor.add(17); break;
		case 10 :neighbor.add(9); neighbor.add(6); neighbor.add(14); break;
		case 11 :neighbor.add(7); neighbor.add(16); neighbor.add(12); break;
		case 12 :neighbor.add(11); neighbor.add(5); neighbor.add(19); neighbor.add(13); break;
		case 13 :neighbor.add(12); neighbor.add(2); neighbor.add(22); break;
		case 14 :neighbor.add(10); neighbor.add(15); neighbor.add(17); break;
		case 15 :neighbor.add(14); neighbor.add(16); neighbor.add(18); break;
		case 16 :neighbor.add(11); neighbor.add(15); neighbor.add(19); break;
		case 17 :neighbor.add(9); neighbor.add(18); neighbor.add(14); neighbor.add(20); break;
		case 18 :neighbor.add(17); neighbor.add(19); neighbor.add(15); neighbor.add(21); break;
		case 19 :neighbor.add(18); neighbor.add(12); neighbor.add(16); neighbor.add(22); break;
		case 20 :neighbor.add(8); neighbor.add(21); neighbor.add(17); break;
		case 21 :neighbor.add(18); neighbor.add(20); neighbor.add(22); break;
		case 22 :neighbor.add(21); neighbor.add(13); neighbor.add(19); break;
		default : break;
		}		
		return neighbor;		
	}

	public boolean closeMill(int position,  char[] tempBoard){
		boolean isMill = false;
		char color = tempBoard[position];
		switch(position){
		case 0 : if((tempBoard[1]==color && tempBoard[2]==color) || (tempBoard[8]==color && tempBoard[20]==color) || (tempBoard[3]==color) && (tempBoard[6]==color)) isMill = true; break;
		case 1 : if((tempBoard[0]==color && tempBoard[2]==color)) isMill = true; break;
		case 2 : if((tempBoard[0]==color && tempBoard[1]==color) || (tempBoard[13]==color && tempBoard[22]==color) || (tempBoard[5]==color) && (tempBoard[7]==color)) isMill = true; break;
		case 3 : if((tempBoard[4]==color && tempBoard[5]==color) || (tempBoard[9]==color && tempBoard[17]==color) || (tempBoard[0]==color) && (tempBoard[6]==color)) isMill = true; break;
		case 4 : if((tempBoard[3]==color && tempBoard[5]==color)) isMill = true; break;
		case 5 : if((tempBoard[4]==color && tempBoard[3]==color) || (tempBoard[12]==color && tempBoard[19]==color) || (tempBoard[2]==color) && (tempBoard[7]==color)) isMill = true; break;
		case 6 : if((tempBoard[10]==color && tempBoard[14]==color) || (tempBoard[0]==color) && (tempBoard[3]==color)) isMill = true; break;
		case 7 : if((tempBoard[11]==color && tempBoard[16]==color) || (tempBoard[2]==color) && (tempBoard[5]==color)) isMill = true; break;
		case 8 : if((tempBoard[0]==color && tempBoard[20]==color) || (tempBoard[9]==color && tempBoard[10]==color)) isMill = true; break;
		case 9 : if((tempBoard[8]==color && tempBoard[10]==color) || (tempBoard[3]==color && tempBoard[17]==color)) isMill = true; break;
		case 10: if((tempBoard[8]==color && tempBoard[9]==color) || (tempBoard[6]==color && tempBoard[14]==color)) isMill = true; break;
		case 11: if((tempBoard[7]==color && tempBoard[16]==color) || (tempBoard[12]==color && tempBoard[13]==color)) isMill = true; break;
		case 12: if((tempBoard[11]==color && tempBoard[13]==color) || (tempBoard[5]==color && tempBoard[19]==color)) isMill = true; break;
		case 13: if((tempBoard[11]==color && tempBoard[12]==color) || (tempBoard[2]==color && tempBoard[22]==color)) isMill = true; break;
		case 14: if((tempBoard[6]==color && tempBoard[10]==color) || (tempBoard[15]==color && tempBoard[16]==color) || (tempBoard[17]==color) && (tempBoard[20]==color)) isMill = true; break;
		case 15: if((tempBoard[14]==color && tempBoard[16]==color) || (tempBoard[18]==color && tempBoard[21]==color)) isMill = true; break;
		case 16: if((tempBoard[7]==color && tempBoard[11]==color) || (tempBoard[14]==color && tempBoard[15]==color) || (tempBoard[19]==color) && (tempBoard[22]==color)) isMill = true; break;
		case 17: if((tempBoard[3]==color && tempBoard[9]==color) || (tempBoard[18]==color && tempBoard[19]==color) || (tempBoard[14]==color) && (tempBoard[20]==color)) isMill = true; break;
		case 18: if((tempBoard[15]==color && tempBoard[21]==color) || (tempBoard[17]==color && tempBoard[19]==color)) isMill = true; break;
		case 19: if((tempBoard[5]==color && tempBoard[12]==color) || (tempBoard[18]==color && tempBoard[17]==color) || (tempBoard[16]==color) && (tempBoard[22]==color)) isMill = true; break;
		case 20: if((tempBoard[0]==color && tempBoard[8]==color) || (tempBoard[21]==color && tempBoard[22]==color) || (tempBoard[14]==color) && (tempBoard[17]==color)) isMill = true; break;
		case 21: if((tempBoard[15]==color && tempBoard[18]==color) || (tempBoard[20]==color && tempBoard[22]==color)) isMill = true; break;
		case 22: if((tempBoard[2]==color && tempBoard[13]==color) || (tempBoard[20]==color && tempBoard[21]==color) || (tempBoard[16]==color) && (tempBoard[19]==color)) isMill = true; break;
		default : break;
		}
		return isMill;
	}

	public String miniMaxAlg(char[] board, int depth,char player,char opponent){
		if(depth == 0)
			return new String(board);
		char[] result = new char[23];
		int resultValue = Integer.MIN_VALUE;
		ArrayList<char[]> moves = moveGenerator('o',player,opponent);
		for(char[] move : moves){
			for(int ch = 0; ch < move.length; ch++)
				board[ch] = move[ch];
			int value = minMax(depth-1,player,opponent);
			if(value > resultValue){				
				for(int ch = 0; ch < move.length; ch++)
					result[ch] = move[ch];
				resultValue = value;
			}
		}
		return new String(result)+" "+evaluatedNodes+" "+resultValue;
	}

	public int maxMin(int depth, char player, char opponent){
		if(depth == 0){
			evaluatedNodes++;
			return improvedEstimate('o',board);
		}
		ArrayList<char[]> moves = moveGenerator('o',player,opponent);
		if(moves.isEmpty()){
			evaluatedNodes++;
			return improvedEstimate('o',board);
		}
		int value = Integer.MIN_VALUE;
		for(char[] move : moves){
			for(int ch = 0; ch < move.length; ch++)
				board[ch] = move[ch];
			value = Math.max(value, minMax(depth-1,player,opponent));
		}
		return value;
	}

	public int minMax(int depth, char player, char opponent){
		if(depth == 0){
			evaluatedNodes++;
			return improvedEstimate('o',board);
		}
		ArrayList<char[]> moves = moveGenerator('o',opponent,player);
		if(moves.isEmpty()){
			evaluatedNodes++;
			return improvedEstimate('o',board);
		}	
		int value = Integer.MAX_VALUE;
		for(char[] move : moves){
			for(int ch = 0; ch < move.length; ch++)
				board[ch] = move[ch];
			value = Math.min(value, maxMin(depth-1,player,opponent));
		}
		return value;
	}

	public int improvedEstimate(char phase, char[] b){
		int impEstimate = 0;
		int numOfWhite = 0;
		int numOfBlack = 0;
		for(char ch : b){
			if(ch=='W') numOfWhite++;
			if(ch=='B') numOfBlack++;
		}

		if(phase == 'o' || phase == 'O'){
			int diffOfMills = numOfMills(b, 'W') - numOfMills(b, 'B');
			int diffOfBlocked = numOfBlocked(b, 'B') - numOfBlocked(b, 'W');
			int diffPieces = numOfWhite - numOfBlack;
			int diffTwoConfig = numOfTwoConfig(b, 'W') - numOfTwoConfig(b, 'B');
			int diffThreeConfig = numOfThreeConfig(b, 'W') - numOfThreeConfig(b, 'B');
			impEstimate = 26*diffOfMills + diffOfBlocked + 9*diffPieces + 10*diffTwoConfig + 7*diffThreeConfig;
		}
		else {
			if(numOfWhite == 3){
				int diffTwoConfig = numOfTwoConfig(b, 'W') - numOfTwoConfig(b, 'B');
				int diffThreeConfig = numOfThreeConfig(b, 'W') - numOfThreeConfig(b, 'B');
				int winningState = findWinState(b);
				impEstimate = 10*diffTwoConfig + diffThreeConfig + 1190*winningState;
			} else {
				int diffOfMills = numOfMills(b, 'W') - numOfMills(b, 'B');
				int diffOfBlocked = numOfBlocked(b, 'B') - numOfBlocked(b, 'W');
				int diffPieces = numOfWhite - numOfBlack;
				int diffDoubleMorris = numOfDoubleMorris(b,'W') - numOfDoubleMorris(b,'B');
				int winningState = findWinState(b);
				impEstimate = 43*diffOfMills + 10*diffOfBlocked + 11*diffPieces + 8*diffDoubleMorris + 1086*winningState;
			}
		}
		return impEstimate;
	}

	public int numOfMills(char[] b, char ch){
		int count = 0;
		//Horizontal Mills
		if(b[0]==ch && b[1]==ch && b[2]==ch) count++;
		if(b[3]==ch && b[4]==ch && b[5]==ch) count++;
		if(b[8]==ch && b[9]==ch && b[10]==ch) count++;
		if(b[11]==ch && b[12]==ch && b[13]==ch) count++;
		if(b[14]==ch && b[15]==ch && b[16]==ch) count++;
		if(b[17]==ch && b[18]==ch && b[19]==ch) count++;
		if(b[20]==ch && b[21]==ch && b[22]==ch) count++;

		//Vertical Mills
		if(b[0]==ch && b[8]==ch && b[20]==ch) count++;
		if(b[3]==ch && b[9]==ch && b[17]==ch) count++;
		if(b[6]==ch && b[10]==ch && b[14]==ch) count++;
		if(b[15]==ch && b[18]==ch && b[21]==ch) count++;
		if(b[7]==ch && b[11]==ch && b[16]==ch) count++;
		if(b[5]==ch && b[12]==ch && b[19]==ch) count++;
		if(b[2]==ch && b[13]==ch && b[22]==ch) count++;

		//Diagonal Mills
		if(b[0]==ch && b[3]==ch && b[6]==ch) count++;
		if(b[2]==ch && b[5]==ch && b[7]==ch) count++;
		if(b[14]==ch && b[17]==ch && b[20]==ch) count++;
		if(b[16]==ch && b[19]==ch && b[22]==ch) count++;
		return count;
	}

	public int numOfBlocked(char[] b, char ch){
		int count = 0;
		for(int i=0; i<23; i++){
			if(b[i] == ch){
				boolean flag = false;
				ArrayList<Integer> nn = findNeighbors(ch);
				for(Integer n : nn){
					if(b[n] == 'x'){
						flag = true;
						break;
					}
				}
				if(flag == false)
					count++;
			}
		}
		return count;
	}

	public int numOfTwoConfig(char[] b, char ch){
		int count = 0;
		//Horizontal Mills
		if(b[0]=='x' && b[1]==ch && b[2]==ch) count++;
		if(b[0]==ch && b[1]=='x' && b[2]==ch) count++;
		if(b[0]==ch && b[1]==ch && b[2]=='x') count++;

		if(b[3]=='x' && b[4]==ch && b[5]==ch) count++;
		if(b[3]==ch && b[4]=='x' && b[5]==ch) count++;
		if(b[3]==ch && b[4]==ch && b[5]=='x') count++;

		if(b[8]=='x' && b[9]==ch && b[10]==ch) count++;
		if(b[8]==ch && b[9]=='x' && b[10]==ch) count++;
		if(b[8]==ch && b[9]==ch && b[10]=='x') count++;

		if(b[11]=='x' && b[12]==ch && b[13]==ch) count++;
		if(b[11]==ch && b[12]=='x' && b[13]==ch) count++;
		if(b[11]==ch && b[12]==ch && b[13]=='x') count++;

		if(b[14]=='x' && b[15]==ch && b[16]==ch) count++;
		if(b[14]==ch && b[15]=='x' && b[16]==ch) count++;
		if(b[14]==ch && b[15]==ch && b[16]=='x') count++;

		if(b[17]=='x' && b[18]==ch && b[19]==ch) count++;
		if(b[17]==ch && b[18]=='x' && b[19]==ch) count++;
		if(b[17]==ch && b[18]==ch && b[19]=='x') count++;

		if(b[20]=='x' && b[21]==ch && b[22]==ch) count++;
		if(b[20]==ch && b[21]=='x' && b[22]==ch) count++;
		if(b[20]==ch && b[21]==ch && b[22]=='x') count++;

		//Vertical Mills
		if(b[0]=='x' && b[8]==ch && b[20]==ch) count++;
		if(b[0]==ch && b[8]=='x' && b[20]==ch) count++;
		if(b[0]==ch && b[8]==ch && b[20]=='x') count++;

		if(b[3]=='x' && b[9]==ch && b[17]==ch) count++;
		if(b[3]==ch && b[9]=='x' && b[17]==ch) count++;
		if(b[3]==ch && b[9]==ch && b[17]=='x') count++;

		if(b[6]=='x' && b[10]==ch && b[14]==ch) count++;
		if(b[6]==ch && b[10]=='x' && b[14]==ch) count++;
		if(b[6]==ch && b[10]==ch && b[14]=='x') count++;

		if(b[15]=='x' && b[18]==ch && b[21]==ch) count++;
		if(b[15]==ch && b[18]=='x' && b[21]==ch) count++;
		if(b[15]==ch && b[18]==ch && b[21]=='x') count++;

		if(b[7]=='x' && b[11]==ch && b[16]==ch) count++;
		if(b[7]==ch && b[11]=='x' && b[16]==ch) count++;
		if(b[7]==ch && b[11]==ch && b[16]=='x') count++;

		if(b[5]=='x' && b[12]==ch && b[19]==ch) count++;
		if(b[5]==ch && b[12]=='x' && b[19]==ch) count++;
		if(b[5]==ch && b[12]==ch && b[19]=='x') count++;

		if(b[2]=='x' && b[13]==ch && b[22]==ch) count++;
		if(b[2]==ch && b[13]=='x' && b[22]==ch) count++;
		if(b[2]==ch && b[13]==ch && b[22]=='x') count++;

		//Diagonal Mills
		if(b[0]=='x' && b[3]==ch && b[6]==ch) count++;
		if(b[0]==ch && b[3]=='x' && b[6]==ch) count++;
		if(b[0]==ch && b[3]==ch && b[6]=='x') count++;

		if(b[2]=='x' && b[5]==ch && b[7]==ch) count++;
		if(b[2]==ch && b[5]=='x' && b[7]==ch) count++;
		if(b[2]==ch && b[5]==ch && b[7]=='x') count++;

		if(b[14]=='x' && b[17]==ch && b[20]==ch) count++;
		if(b[14]==ch && b[17]=='x' && b[20]==ch) count++;
		if(b[14]==ch && b[17]==ch && b[20]=='x') count++;

		if(b[16]=='x' && b[19]==ch && b[22]==ch) count++;
		if(b[16]==ch && b[19]=='x' && b[22]==ch) count++;
		if(b[16]==ch && b[19]==ch && b[22]=='x') count++;

		return count;
	}

	public int numOfThreeConfig(char[] b, char ch){
		int count = 0;
		if(b[0]==ch){
			if(b[8]=='x' && b[20]==ch && b[1]=='x' && b[2]==ch) count++;
			else if(b[8]=='x' && b[20]==ch && b[1]==ch && b[2]=='x') count++;
			else if(b[8]==ch && b[20]=='x' && b[1]=='x' && b[2]==ch) count++;
			else if(b[8]==ch && b[20]=='x' && b[1]==ch && b[2]=='x') count++;
		}
		if(b[2]==ch){
			if(b[0]=='x' && b[1]==ch && b[13]=='x' && b[22]==ch ) count++;
			else if(b[0]=='x' && b[1]==ch && b[13]==ch && b[22]=='x' ) count++;
			else if(b[0]==ch && b[1]=='x' && b[13]=='x' && b[22]==ch ) count++;
			else if(b[0]==ch && b[1]=='x' && b[13]==ch && b[22]=='x' ) count++;
		}
		if(b[3]==ch){
			if(b[17]=='x' && b[9]==ch && b[4]=='x' && b[5]==ch ) count++;
			else if(b[17]=='x' && b[9]==ch && b[4]==ch && b[5]=='x' ) count++;
			else if(b[17]==ch && b[9]=='x' && b[4]=='x' && b[5]==ch ) count++;
			else if(b[17]==ch && b[9]=='x' && b[4]==ch && b[5]=='x' ) count++;
		}
		if(b[5]==ch){
			if(b[3]=='x' && b[4]==ch && b[12]=='x' && b[19]==ch ) count++;
			else if(b[3]=='x' && b[4]==ch && b[12]==ch && b[19]=='x' ) count++;
			else if(b[3]==ch && b[4]=='x' && b[12]=='x' && b[19]==ch ) count++;
			else if(b[3]==ch && b[4]=='x' && b[12]==ch && b[19]=='x' ) count++;
		}
		if(b[8]==ch){
			if(b[0]=='x' && b[20]==ch && b[9]=='x' && b[10]==ch ) count++;
			else if(b[0]=='x' && b[20]==ch && b[9]==ch && b[10]=='x' ) count++;
			else if(b[0]==ch && b[20]=='x' && b[9]=='x' && b[10]==ch ) count++;
			else if(b[0]==ch && b[20]=='x' && b[9]==ch && b[10]=='x' ) count++;
		}
		if(b[9]==ch){
			if(b[3]=='x' && b[17]==ch && b[8]=='x' && b[10]==ch ) count++;
			else if(b[3]=='x' && b[17]==ch && b[8]==ch && b[10]=='x' ) count++;
			else if(b[3]==ch && b[17]=='x' && b[8]=='x' && b[10]==ch ) count++;
			else if(b[3]==ch && b[17]=='x' && b[8]==ch && b[10]=='x' ) count++;
		}
		if(b[10]==ch){
			if(b[8]=='x' && b[9]==ch && b[6]=='x' && b[14]==ch ) count++;
			else if(b[8]=='x' && b[9]==ch && b[6]==ch && b[14]=='x' ) count++;
			else if(b[8]==ch && b[9]=='x' && b[6]=='x' && b[14]==ch ) count++;
			else if(b[8]==ch && b[9]=='x' && b[6]==ch && b[14]=='x' ) count++;
		}
		if(b[11]==ch){
			if(b[7]=='x' && b[16]==ch && b[12]=='x' && b[13]==ch ) count++;
			else if(b[7]=='x' && b[16]==ch && b[12]==ch && b[13]=='x' ) count++;
			else if(b[7]==ch && b[16]=='x' && b[12]=='x' && b[13]==ch ) count++;
			else if(b[7]==ch && b[16]=='x' && b[12]==ch && b[13]=='x' ) count++;
		}
		if(b[12]==ch){
			if(b[5]=='x' && b[19]==ch && b[11]=='x' && b[13]==ch ) count++;
			else if(b[5]=='x' && b[19]==ch && b[11]==ch && b[13]=='x' ) count++;
			else if(b[5]==ch && b[19]=='x' && b[11]=='x' && b[13]==ch ) count++;
			else if(b[5]==ch && b[19]=='x' && b[11]==ch && b[13]=='x' ) count++;
		}
		if(b[13]==ch){
			if(b[2]=='x' && b[22]==ch && b[11]=='x' && b[12]==ch ) count++;
			else if(b[2]=='x' && b[22]==ch && b[11]==ch && b[12]=='x' ) count++;
			else if(b[2]==ch && b[22]=='x' && b[11]=='x' && b[12]==ch ) count++;
			else if(b[2]==ch && b[22]=='x' && b[11]==ch && b[12]=='x' ) count++;
		}
		if(b[14]==ch){
			if(b[6]=='x' && b[10]==ch && b[15]=='x' && b[16]==ch ) count++;
			else if(b[6]=='x' && b[10]==ch && b[15]==ch && b[16]=='x' ) count++;
			else if(b[6]==ch && b[10]=='x' && b[15]=='x' && b[16]==ch ) count++;
			else if(b[6]==ch && b[10]=='x' && b[15]==ch && b[16]=='x' ) count++;
		}
		if(b[15]==ch){
			if(b[18]=='x' && b[21]==ch && b[14]=='x' && b[16]==ch ) count++;
			else if(b[18]=='x' && b[21]==ch && b[14]==ch && b[16]=='x' ) count++;
			else if(b[18]==ch && b[21]=='x' && b[14]=='x' && b[16]==ch ) count++;
			else if(b[18]==ch && b[21]=='x' && b[14]==ch && b[16]=='x' ) count++;
		}
		if(b[16]==ch){
			if(b[7]=='x' && b[11]==ch && b[14]=='x' && b[15]==ch ) count++;
			else if(b[7]=='x' && b[11]==ch && b[14]==ch && b[15]=='x' ) count++;
			else if(b[7]==ch && b[11]=='x' && b[14]=='x' && b[15]==ch ) count++;
			else if(b[7]==ch && b[11]=='x' && b[14]==ch && b[15]=='x' ) count++;
		}
		if(b[17]==ch){
			if(b[3]=='x' && b[9]==ch && b[18]=='x' && b[19]==ch ) count++;
			else if(b[3]=='x' && b[9]==ch && b[18]==ch && b[19]=='x' ) count++;
			else if(b[3]==ch && b[9]=='x' && b[18]=='x' && b[19]==ch ) count++;
			else if(b[3]==ch && b[9]=='x' && b[18]==ch && b[19]=='x' ) count++;
		}
		if(b[18]==ch){
			if(b[15]=='x' && b[21]==ch && b[17]=='x' && b[19]==ch ) count++;
			else if(b[15]=='x' && b[21]==ch && b[17]==ch && b[19]=='x' ) count++;
			else if(b[15]==ch && b[21]=='x' && b[17]=='x' && b[19]==ch ) count++;
			else if(b[15]==ch && b[21]=='x' && b[17]==ch && b[19]=='x' ) count++;
		}
		if(b[19]==ch){
			if(b[5]=='x' && b[12]==ch && b[17]=='x' && b[18]==ch ) count++;
			else if(b[5]=='x' && b[12]==ch && b[17]==ch && b[18]=='x' ) count++;
			else if(b[5]==ch && b[12]=='x' && b[17]=='x' && b[18]==ch ) count++;
			else if(b[5]==ch && b[12]=='x' && b[17]==ch && b[18]=='x' ) count++;
		}
		if(b[20]==ch){
			if(b[0]=='x' && b[8]==ch && b[21]=='x' && b[22]==ch ) count++;
			else if(b[0]=='x' && b[8]==ch && b[21]==ch && b[22]=='x' ) count++;
			else if(b[0]==ch && b[8]=='x' && b[21]=='x' && b[22]==ch ) count++;
			else if(b[0]==ch && b[8]=='x' && b[21]==ch && b[22]=='x' ) count++;
		}
		if(b[21]==ch){
			if(b[15]=='x' && b[18]==ch && b[20]=='x' && b[22]==ch ) count++;
			else if(b[15]=='x' && b[18]==ch && b[20]==ch && b[22]=='x' ) count++;
			else if(b[15]==ch && b[18]=='x' && b[20]=='x' && b[22]==ch ) count++;
			else if(b[15]==ch && b[18]=='x' && b[20]==ch && b[22]=='x' ) count++;
		}
		if(b[22]==ch){
			if(b[2]=='x' && b[13]==ch && b[20]=='x' && b[21]==ch ) count++;
			else if(b[2]=='x' && b[13]==ch && b[20]==ch && b[21]=='x' ) count++;
			else if(b[2]==ch && b[13]=='x' && b[20]=='x' && b[21]==ch ) count++;
			else if(b[2]==ch && b[13]=='x' && b[20]==ch && b[21]=='x' ) count++;
		}
		if(b[0]==ch){
			if(b[1]=='x' && b[2]==ch && b[3]=='x' && b[6]==ch ) count++;
			else if(b[1]=='x' && b[2]==ch && b[3]==ch && b[6]=='x' ) count++;
			else if(b[1]==ch && b[2]=='x' && b[3]=='x' && b[6]==ch ) count++;
			else if(b[1]==ch && b[2]=='x' && b[3]==ch && b[6]=='x' ) count++;
		}
		if(b[2]==ch){
			if(b[0]=='x' && b[1]==ch && b[5]=='x' && b[7]==ch ) count++;
			else if(b[0]=='x' && b[1]==ch && b[5]==ch && b[7]=='x' ) count++;
			else if(b[0]==ch && b[1]=='x' && b[5]=='x' && b[7]==ch ) count++;
			else if(b[0]==ch && b[1]=='x' && b[5]==ch && b[7]=='x' ) count++;
		}
		if(b[3]==ch){
			if(b[4]=='x' && b[5]==ch && b[0]=='x' && b[6]==ch ) count++;
			else if(b[4]=='x' && b[5]==ch && b[0]==ch && b[6]=='x' ) count++;
			else if(b[4]==ch && b[5]=='x' && b[0]=='x' && b[6]==ch ) count++;
			else if(b[4]==ch && b[5]=='x' && b[0]==ch && b[6]=='x' ) count++;
		}
		if(b[5]==ch){
			if(b[3]=='x' && b[4]==ch && b[2]=='x' && b[7]==ch ) count++;
			else if(b[3]=='x' && b[4]==ch && b[2]==ch && b[7]=='x' ) count++;
			else if(b[3]==ch && b[4]=='x' && b[2]=='x' && b[7]==ch ) count++;
			else if(b[3]==ch && b[4]=='x' && b[2]==ch && b[7]=='x' ) count++;
		}
		if(b[14]==ch){
			if(b[20]=='x' && b[17]==ch && b[15]=='x' && b[16]==ch ) count++;
			else if(b[20]=='x' && b[17]==ch && b[15]==ch && b[16]=='x' ) count++;
			else if(b[20]==ch && b[17]=='x' && b[15]=='x' && b[16]==ch ) count++;
			else if(b[20]==ch && b[17]=='x' && b[15]==ch && b[16]=='x' ) count++;
		}
		if(b[16]==ch){
			if(b[19]=='x' && b[22]==ch && b[14]=='x' && b[15]==ch ) count++;
			else if(b[19]=='x' && b[22]==ch && b[14]==ch && b[15]=='x' ) count++;
			else if(b[19]==ch && b[22]=='x' && b[14]=='x' && b[15]==ch ) count++;
			else if(b[19]==ch && b[22]=='x' && b[14]==ch && b[15]=='x' ) count++;
		}
		if(b[17]==ch){
			if(b[14]=='x' && b[20]==ch && b[18]=='x' && b[19]==ch ) count++;
			else if(b[14]=='x' && b[20]==ch && b[18]==ch && b[19]=='x' ) count++;
			else if(b[14]==ch && b[20]=='x' && b[18]=='x' && b[19]==ch ) count++;
			else if(b[14]==ch && b[20]=='x' && b[18]==ch && b[19]=='x' ) count++;
		}
		if(b[19]==ch){
			if(b[16]=='x' && b[22]==ch && b[17]=='x' && b[18]==ch ) count++;
			else if(b[16]=='x' && b[22]==ch && b[17]==ch && b[18]=='x' ) count++;
			else if(b[16]==ch && b[22]=='x' && b[17]=='x' && b[18]==ch ) count++;
			else if(b[16]==ch && b[22]=='x' && b[17]==ch && b[18]=='x' ) count++;
		}
		if(b[20]==ch){
			if(b[14]=='x' && b[17]==ch && b[21]=='x' && b[22]==ch ) count++;
			else if(b[14]=='x' && b[17]==ch && b[21]==ch && b[22]=='x' ) count++;
			else if(b[14]==ch && b[17]=='x' && b[21]=='x' && b[22]==ch ) count++;
			else if(b[14]==ch && b[17]=='x' && b[21]==ch && b[22]=='x' ) count++;
		}
		if(b[22]==ch){
			if(b[16]=='x' && b[19]==ch && b[20]=='x' && b[22]==ch ) count++;
			else if(b[16]=='x' && b[19]==ch && b[20]==ch && b[22]=='x' ) count++;
			else if(b[16]==ch && b[19]=='x' && b[20]=='x' && b[22]==ch ) count++;
			else if(b[16]==ch && b[19]=='x' && b[20]==ch && b[22]=='x' ) count++;
		}

		if(b[0]==ch){
			if(b[8]=='x' && b[20]==ch && b[3]=='x' && b[6]==ch ) count++;
			else if(b[8]=='x' && b[20]==ch && b[3]==ch && b[6]=='x' ) count++;
			else if(b[8]==ch && b[20]=='x' && b[3]=='x' && b[6]==ch ) count++;
			else if(b[8]==ch && b[20]=='x' && b[3]==ch && b[6]=='x' ) count++;
		}
		if(b[20]==ch){
			if(b[0]=='x' && b[8]==ch && b[14]=='x' && b[17]==ch ) count++;
			else if(b[0]=='x' && b[8]==ch && b[14]==ch && b[17]=='x' ) count++;
			else if(b[0]==ch && b[8]=='x' && b[14]=='x' && b[17]==ch ) count++;
			else if(b[0]==ch && b[8]=='x' && b[14]==ch && b[17]=='x' ) count++;
		}
		if(b[3]==ch){
			if(b[9]=='x' && b[17]==ch && b[0]=='x' && b[6]==ch ) count++;
			else if(b[9]=='x' && b[17]==ch && b[0]==ch && b[6]=='x' ) count++;
			else if(b[9]==ch && b[17]=='x' && b[0]=='x' && b[6]==ch ) count++;
			else if(b[9]==ch && b[17]=='x' && b[0]==ch && b[6]=='x' ) count++;
		}
		if(b[17]==ch){
			if(b[3]=='x' && b[9]==ch && b[14]=='x' && b[20]==ch ) count++;
			else if(b[3]=='x' && b[9]==ch && b[14]==ch && b[20]=='x' ) count++;
			else if(b[3]==ch && b[9]=='x' && b[14]=='x' && b[20]==ch ) count++;
			else if(b[3]==ch && b[9]=='x' && b[14]==ch && b[20]=='x' ) count++;
		}
		if(b[6]==ch){
			if(b[10]=='x' && b[14]==ch && b[0]=='x' && b[3]==ch ) count++;
			else if(b[10]=='x' && b[14]==ch && b[0]==ch && b[3]=='x' ) count++;
			else if(b[10]==ch && b[14]=='x' && b[0]=='x' && b[3]==ch ) count++;
			else if(b[10]==ch && b[14]=='x' && b[0]==ch && b[3]=='x' ) count++;
		}
		if(b[14]==ch){
			if(b[6]=='x' && b[10]==ch && b[17]=='x' && b[20]==ch ) count++;
			else if(b[6]=='x' && b[10]==ch && b[17]==ch && b[20]=='x' ) count++;
			else if(b[6]==ch && b[10]=='x' && b[17]=='x' && b[20]==ch ) count++;
			else if(b[6]==ch && b[10]=='x' && b[17]==ch && b[20]=='x' ) count++;
		}
		if(b[7]==ch){
			if(b[11]=='x' && b[16]==ch && b[2]=='x' && b[5]==ch ) count++;
			else if(b[11]=='x' && b[16]==ch && b[2]==ch && b[5]=='x' ) count++;
			else if(b[11]==ch && b[16]=='x' && b[2]=='x' && b[5]==ch ) count++;
			else if(b[11]==ch && b[16]=='x' && b[2]==ch && b[5]=='x' ) count++;
		}
		if(b[16]==ch){
			if(b[7]=='x' && b[11]==ch && b[19]=='x' && b[22]==ch ) count++;
			else if(b[7]=='x' && b[11]==ch && b[19]==ch && b[22]=='x' ) count++;
			else if(b[7]==ch && b[11]=='x' && b[19]=='x' && b[22]==ch ) count++;
			else if(b[7]==ch && b[11]=='x' && b[19]==ch && b[22]=='x' ) count++;
		}
		if(b[5]==ch){
			if(b[12]=='x' && b[19]==ch && b[2]=='x' && b[7]==ch ) count++;
			else if(b[12]=='x' && b[19]==ch && b[2]==ch && b[7]=='x' ) count++;
			else if(b[12]==ch && b[19]=='x' && b[2]=='x' && b[7]==ch ) count++;
			else if(b[12]==ch && b[19]=='x' && b[2]==ch && b[7]=='x' ) count++;
		}
		if(b[19]==ch){
			if(b[5]=='x' && b[12]==ch && b[16]=='x' && b[22]==ch ) count++;
			else if(b[5]=='x' && b[12]==ch && b[16]==ch && b[22]=='x' ) count++;
			else if(b[5]==ch && b[12]=='x' && b[16]=='x' && b[22]==ch ) count++;
			else if(b[5]==ch && b[12]=='x' && b[16]==ch && b[22]=='x' ) count++;
		}
		if(b[2]==ch){
			if(b[13]=='x' && b[22]==ch && b[5]=='x' && b[7]==ch ) count++;
			else if(b[13]=='x' && b[22]==ch && b[5]==ch && b[7]=='x' ) count++;
			else if(b[13]==ch && b[22]=='x' && b[5]=='x' && b[7]==ch ) count++;
			else if(b[13]==ch && b[22]=='x' && b[5]==ch && b[7]=='x' ) count++;
		}
		if(b[22]==ch){
			if(b[2]=='x' && b[13]==ch && b[16]=='x' && b[19]==ch ) count++;
			else if(b[2]=='x' && b[13]==ch && b[16]==ch && b[19]=='x' ) count++;
			else if(b[2]==ch && b[13]=='x' && b[16]=='x' && b[19]==ch ) count++;
			else if(b[2]==ch && b[13]=='x' && b[16]==ch && b[19]=='x' ) count++;
		}

		return count;
	}

	public int numOfDoubleMorris(char[] b, char ch){
		int count = 0;
		//Horizontal Mills
		boolean h1=false, h2=false, h3=false, h4=false, h5=false, h6=false, h7=false;
		if(b[0]==ch && b[1]==ch && b[2]==ch) h1=true;
		if(b[3]==ch && b[4]==ch && b[5]==ch) h2=true;
		if(b[8]==ch && b[9]==ch && b[10]==ch) h3=true;
		if(b[11]==ch && b[12]==ch && b[13]==ch) h4=true;
		if(b[14]==ch && b[15]==ch && b[16]==ch) h5=true;
		if(b[17]==ch && b[18]==ch && b[19]==ch) h6=true;
		if(b[20]==ch && b[21]==ch && b[22]==ch) h7=true;

		//Vertical Mills
		boolean v1=false, v2=false, v3=false, v4=false, v5=false, v6=false, v7=false;
		if(b[0]==ch && b[8]==ch && b[20]==ch) v1=true;
		if(b[3]==ch && b[9]==ch && b[17]==ch) v2=true;
		if(b[6]==ch && b[10]==ch && b[14]==ch) v3=true;
		if(b[15]==ch && b[18]==ch && b[21]==ch) v4=true;
		if(b[7]==ch && b[11]==ch && b[16]==ch) v5=true;
		if(b[5]==ch && b[12]==ch && b[19]==ch) v6=true;
		if(b[2]==ch && b[13]==ch && b[22]==ch) v7=true;

		//Diagonal Mills
		boolean d1=false, d2=false, d3=false, d4=false;
		if(b[0]==ch && b[3]==ch && b[6]==ch) d1=true;
		if(b[2]==ch && b[5]==ch && b[7]==ch) d2=true;
		if(b[14]==ch && b[17]==ch && b[20]==ch) d3=true;
		if(b[16]==ch && b[19]==ch && b[22]==ch) d4=true;

		//horizontal and Vertical Mills
		if(h1 && v1) count++;
		if(h1 && v7) count++;
		if(h2 && v2) count++;
		if(h2 && v6) count++;
		if(h3 && v1) count++;
		if(h3 && v2) count++;
		if(h3 && v3) count++;
		if(h4 && v5) count++;
		if(h4 && v6) count++;
		if(h4 && v7) count++;
		if(h5 && v3) count++;
		if(h5 && v4) count++;
		if(h5 && v5) count++;
		if(h6 && v2) count++;
		if(h6 && v4) count++;
		if(h6 && v6) count++;
		if(h7 && v1) count++;
		if(h7 && v4) count++;
		if(h7 && v7) count++;

		//Horizontal and Diagonal Mills
		if(h1 && d1) count++;
		if(h1 && d2) count++;
		if(h2 && d1) count++;
		if(h2 && d2) count++;
		if(h5 && d3) count++;
		if(h5 && d4) count++;
		if(h6 && d3) count++;
		if(h6 && d4) count++;
		if(h7 && d3) count++;
		if(h7 && d4) count++;

		//Vertical and Diagonal Mills
		if(v1 && d1) count++;
		if(v1 && d3) count++;
		if(v2 && d1) count++;
		if(v2 && d3) count++;
		if(v3 && d1) count++;
		if(v3 && d3) count++;
		if(v5 && d1) count++;
		if(v5 && d3) count++;
		if(v6 && d1) count++;
		if(v6 && d3) count++;
		if(v7 && d1) count++;
		if(v7 && d3) count++;

		return count;
	}

	public int findWinState(char[] b){
		int whiteMoveCount = findMoveCount(b, 'W');
		if(whiteMoveCount <= 2) 
			return -1;
		int blackMoveCount = findMoveCount(b, 'B');
		if(blackMoveCount <= 2 )
			return 1;
		else
			return 0;

	}

	public int findMoveCount(char[] b, char player){
		int count = 0;
		ArrayList<Integer> adjacent = new ArrayList<Integer>();
		for(int ch = 0; ch < b.length; ch++){
			if(b[ch] == player){
				adjacent = findNeighbors(ch);
				for(Integer i : adjacent){
					if(b[i] != 'x')
						count++;
				}
			}
		}
		return count;
	}

	public ArrayList<char[]> moveGenerator(char phase, char player, char opponent){
		if(phase == 'o' || phase == 'O')
			return generateMovesOpening(board,player,opponent);
		return generateMovesMidgameEndgame(board,player,opponent); 
	}

	public ArrayList<char[]> generateMovesOpening(char[] board, char player, char opponent){
		ArrayList<char[]> L = generateAdd(board,player,opponent);
		return L;
	}

	public ArrayList<char[]> generateAdd(char[] board, char player, char opponent){
		ArrayList<char[]> L = new ArrayList<char[]>();
		for(int ch1 = 0; ch1 < board.length; ch1++){
			if(board[ch1]=='x'){
				char[] b = new char[23];
				for(int ch2 = 0; ch2 < board.length; ch2++)
					b[ch2] = board[ch2];
				b[ch1] = player;
				if(closeMill(ch1, b))
					L = generateRemove(b,L,player,opponent);
				else
					L.add(b);
			}
		}
		return L;
	}

	public ArrayList<char[]> generateMovesMidgameEndgame(char[] board, char player, char opponent){
		ArrayList<char[]> L = new ArrayList<char[]>();
		int numOfWhite = 0;
		for(char ch : board)
			if(ch == player) numOfWhite++;
		if(numOfWhite == 3) L = generateHopping(board,player,opponent);
		else L = generateMove(board,player,opponent);
		return L;
	}

	public ArrayList<char[]> generateHopping(char[] board, char player, char opponent){
		ArrayList<char[]> L = new ArrayList<char[]>();
		for(int ch1 = 0; ch1 < board.length; ch1++){
			if(board[ch1]==player){
				for(int ch2 = 0; ch2 < board.length; ch2++){
					if(board[ch2] == 'x'){
						char[] b = new char[23];
						for(int ch3 = 0; ch3 < board.length; ch3++)
							b[ch3] = board[ch3];
						b[ch1] = 'x';
						b[ch2] = player;
						if(closeMill(ch2, b))
							L = generateRemove(b, L,player,opponent);
						else
							L.add(b);
					}
				}
			}
		}
		return L;
	}

	public ArrayList<char[]> generateMove(char[] board, char player, char opponent){
		ArrayList<char[]> L = new ArrayList<char[]>();
		for(int ch1 = 0; ch1 < board.length; ch1++){
			if(board[ch1]==player){
				ArrayList<Integer> neighbor = findNeighbors(ch1);
				for(Integer i : neighbor){
					if(board[i]=='x'){
						char[] b = new char[23];
						for(int ch2 = 0; ch2 < board.length; ch2++)
							b[ch2] = board[ch2];
						b[ch1] = 'x';
						b[i] = player;
						if(closeMill(i, b))
							L = generateRemove(b, L,player,opponent);
						else
							L.add(b);
					}
				}
			}
		}
		return L;
	}

	public ArrayList<char[]> generateRemove(char[] b, ArrayList<char[]> L, char player, char opponent){
		boolean flag = false;
		for(int ch1 = 0; ch1 < b.length; ch1++){
			if(board[ch1] == opponent){
				if(!closeMill(ch1, b)){
					char[] copy = new char[23];
					for(int ch2 = 0; ch2 < b.length; ch2++)
						copy[ch2] = b[ch2];
					copy[ch1] = 'x';
					L.add(copy);
					flag = true; 
					break;
				}
			}
		}
		if(flag == false)
			L.add(b);
		return L;
	}

}
