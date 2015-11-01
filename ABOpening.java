/**
 * @author Sanjay
 * Alpha-Beta Algorithm for opening phase 
 * Player = White
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ABOpening {
	static String initial;
	static char[] board;
	static int evaluatedNodes;

	ABOpening(){
		initial = FileReadWrite.getInput();
		board = initial.toCharArray();
		evaluatedNodes = 0;
	}

	public static void main(String[] args) throws IOException {
		ABOpening game = new ABOpening();
		Scanner in = new Scanner(System.in);
		int depth = in.nextInt();
		in.close();
		char player = 'W';
		char opponent = 'B';
		String[] output = game.alphaBetaPruning(board,depth,player,opponent).split(" ");
		FileReadWrite.writeOutput(output[0]);
		System.out.println("Board Position : " + output[0]);
		System.out.println("Position evaluated by static estimation : " + output[1]);
		System.out.println("ALPHA-BETA Estimate : " + output[2]);
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

	public String alphaBetaPruning(char[] board, int depth,char player,char opponent){
		if(depth == 0)
			return new String(board);
		char[] result = new char[23];
		int resultValue = Integer.MIN_VALUE;
		ArrayList<char[]> moves = moveGenerator('o',player,opponent);
		for(char[] move : moves){
			for(int ch = 0; ch < move.length; ch++)
				board[ch] = move[ch];
			int value = minValue(resultValue,Integer.MAX_VALUE, depth-1,player,opponent);
			if(value > resultValue){				
				for(int ch = 0; ch < move.length; ch++)
					result[ch] = move[ch];
				resultValue = value;
			}
		}
		return new String(result)+" "+evaluatedNodes+" "+resultValue;
	}

	public int maxValue(int alpha, int beta, int depth, char player, char opponent){
		if(depth == 0){
			evaluatedNodes++;
			return estimate('o',board);
		}
		ArrayList<char[]> moves = moveGenerator('o',player,opponent);
		if(moves.isEmpty()){
			evaluatedNodes++;
			return estimate('o',board);
		}
		int value = Integer.MIN_VALUE;
		for(char[] move : moves){
			for(int ch = 0; ch < move.length; ch++)
				board[ch] = move[ch];
			value = Math.max(value, minValue(alpha,beta,depth-1,player,opponent));
			if(value >= beta)
				return value;
			alpha = Math.max(alpha, value);
		}
		return value;
	}

	public int minValue(int alpha, int beta, int depth, char player, char opponent){
		if(depth == 0){
			evaluatedNodes++;
			return estimate('o',board);
		}
		ArrayList<char[]> moves = moveGenerator('o',opponent,player);
		if(moves.isEmpty()){
			evaluatedNodes++;
			return estimate('o',board);
		}	
		int value = Integer.MAX_VALUE;
		for(char[] move : moves){
			for(int ch = 0; ch < move.length; ch++)
				board[ch] = move[ch];
			value = Math.min(value, maxValue(alpha,beta,depth-1,player,opponent));
			if(value <= alpha)
				return value;
			beta = Math.min(beta, value);
		}
		return value;
	}

	public int estimate(char phase, char[] b){
		int staticEstimate;
		int numBlackMoves = 0;
		int numOfWhite = 0;
		int numOfBlack = 0;

		for(char ch : b){
			if(ch=='W') numOfWhite++;
			if(ch=='B') numOfBlack++;
		}
		
		if(phase == 'o' || phase == 'O')
			staticEstimate = numOfWhite - numOfBlack;
		else{
			if(numOfBlack <= 2) staticEstimate = 10000;
			else if(numOfWhite <= 2) staticEstimate = -10000;
			else {
				numBlackMoves = findBlackMoveCount(b);
				if(numBlackMoves == 0)  staticEstimate = 10000;
				else staticEstimate = (1000*(numOfWhite - numOfBlack)-numBlackMoves);
			}
		}
		return staticEstimate;
	}
	
	public int findBlackMoveCount(char[] b){
		int count = 0;
		ArrayList<Integer> adjacent = new ArrayList<Integer>();
		for(int ch = 0; ch < b.length; ch++){
			if(b[ch] == 'B'){
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
