import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

	public static int[][] board = new int[3][3];
	public static boolean playerOne;
	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<String> players = new ArrayList<String>();
	public static ArrayList<Integer> wins = new ArrayList<Integer>();
	public static String p1, p2;
	public static void main(String[] args) {
		getNames();
		startGame();
		while(true) {
			System.out.println("Play again?(Y/N): ");
			String in = scanner.nextLine();
			if(in.equals("Y") || (in.equals("y"))) {
				startGame();
			} else if(in.equals("N") || (in.equals("n"))){
				System.out.println("New Players?(Y/N): ");
				in = scanner.nextLine();
				if(in.equals("Y") || (in.equals("y"))) {
					getNames();
					startGame();
				} else if(in.equals("N") || (in.equals("n"))){
					printWins();
					System.out.println("Have a nice day.");
					break;
				}
			}
		}
		scanner.close();
	}
	
	public static void getNames() {
		System.out.println("Enter player 1 name: ");
		p1 = scanner.nextLine();
		System.out.println("Enter player 2 name: ");
		p2 = scanner.nextLine();
		boolean found = false;
		for(String p: players) {
			if(p.equals(p1)) {
				found = true;
			}
		}
		if(!found) {
			players.add(p1);
			wins.add(0);
		}
		found = false;
		for(String p: players) {
			if(p.equals(p2)) {
				found = true;
			}
		}
		if(!found) {
			players.add(p2);
			wins.add(0);
		}
	}

	public static void startGame() {
		playerOne = true;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = 0;
			}
		}
		printBoard();
		while(true) {
			int move = -1;
			while(move < 0 || board[move / 3][move % 3] != 0 || move > 8) {
				move = -1;
				try {
					if(playerOne) {
						System.out.println(p1 + "(X) move(1-9): ");
					} else {
						System.out.println(p2 + "(O) move(1-9): ");
					}
					move = Integer.parseInt(scanner.nextLine()) - 1;
				} catch (NumberFormatException e) {
					System.out.println("Please enter 1-9");
				}
				if(board[move / 3][move % 3] != 0) {
					System.out.println("That spot is taken!");
				}
			}
			if(playerOne) {
				board[move / 3][move % 3] = 1;
			} else {
				board[move / 3][move % 3] = 2;
			}
			printBoard();
			if(checkWin()) {
				if(playerOne) {
					System.out.println("Player 1 Wins!");
					for(int i = 0; i < players.size(); i++) {
						if(players.get(i).equals(p1)) {
							wins.set(i, wins.get(i) + 1);
						}
					}
				} else {
					System.out.println("Player 2 Wins!");
					for(int i = 0; i < players.size(); i++) {
						if(players.get(i).equals(p2)) {
							wins.set(i, wins.get(i) + 1);
						}
					}
				}
				break;
			}
			if(checkDraw()) {
				System.out.println("Draw!");
				break;
			}
			playerOne = !playerOne;
		}
	}

	public static boolean checkWin() {
		for(int i = 0; i < 3; i++) {
			if(board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		for(int i = 0; i < 3; i++) {
			if(board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		if(board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}
		if(board[2][0] != 0 && board[2][0] == board[1][1] && board[1][1] == board[0][2]) {
			return true;
		}
		return false;
	}
	
	public static boolean checkDraw() {
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public static void printBoard() {
		System.out.println();
		System.out.println(" " + printPiece(0,0) + " | " + printPiece(0,1) + " | " + printPiece(0,2));
		System.out.println("---+---+---");
		System.out.println(" " + printPiece(1,0) + " | " + printPiece(1,1) + " | " + printPiece(1,2));
		System.out.println("---+---+---");
		System.out.println(" " + printPiece(2,0) + " | " + printPiece(2,1) + " | " + printPiece(2,2));
		System.out.println();
	}

	public static String printPiece(int i, int j) {
		if(board[i][j] == 1) return "X";
		if(board[i][j] == 2) return "O";
		return " ";
	}
	
	public static void printWins(){
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i) + " : " + wins.get(i) + " wins!");
		}
	}
}
