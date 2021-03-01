import java.util.Scanner;

public class Assign23 {
	public static int[][] board = new int[8][8];

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean[] eliminated = new boolean[3];
		int turns = 0;

		for (int player = 1; player <= 3; player = 1+player%3) {
			if (eliminated[player-1]) continue;

			printBoard();
			if (win(player)) {
				if (player == 3) {
					System.out.println("Computer wins.");
				} else {
					System.out.printf("Player %d wins.\n", player);
				}
				System.exit(0);
			}
			
			if (turns == 64) {
				System.out.println("Board is full. Game ends in a tie.");
				System.exit(0);
			}

			if (player == 3) {
				int choice = (int)(Math.random()*8);
				while (board[0][choice] != 0) {
					choice = (int)(Math.random()*8);
				}
				System.out.printf("> Computer: %c\n", choice+65);
				fill(choice, 3);
			} else {
				System.out.printf("> Player %d: ", player);
				int choice = input.next().toUpperCase().charAt(0)-65;
				while (choice != 23 && choice != 24 && board[0][choice%8] != 0) {
					System.out.printf("Column full. Choose again.\n> Player %d: ", player);
					choice = input.next().toUpperCase().charAt(0)-65;
				}

				if (choice == 23) {
					tryClockwise();
					System.out.printf("No wins found. Player %d eliminated.\n", player);
					eliminated[player-1] = true;
				} else if (choice == 24) {
					tryCounter();
					System.out.printf("No wins found. Player %d eliminated.\n", player);
					eliminated[player-1] = true;
				} else {
					fill(choice, player);
				}
			}
			System.out.println();
			turns++;
		}
	}

	public static void tryClockwise() {
		String winners = "";

		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 6; col++) {
				for (int player = 1; player <= 3; player++) {
					if (board[row][col] == player && board[row][col+1] == player && board[row][col+2] == player && board[row+1][col] == player) {
						winners += player;
					}
				}
			}
		}

		for (int row = 1; row < 8; row++) {
			for (int col = 0; col < 6; col++) {
				for (int player = 1; player <= 3; player++) {
					if (board[row][col] == player && board[row][col+1] == player && board[row][col+2] == player && board[row-1][col] == player) {
						winners += player;
					}
				}
			}
		}

		if (winners.length() > 0) {
			if (winners.length() == 1) {
				System.out.printf("Player %s wins.\n", winners);
			} else {
				System.out.print("Game ends in a tie. There is no winner.\n");
			}
			System.exit(0);
		}
	}

	public static void tryCounter() {
		String winners = "";

		for (int row = 0; row < 7; row++) {
			for (int col = 0; col < 6; col++) {
				for (int player = 1; player <= 3; player++) {
					if (board[row][col] == player && board[row][col+1] == player && board[row][col+2] == player && board[row+1][col+2] == player) {
						winners += player;
					}
				}
			}
		}

		for (int row = 1; row < 8; row++) {
			for (int col = 0; col < 6; col++) {
				for (int player = 1; player <= 3; player++) {
					if (board[row][col] == player && board[row][col+1] == player && board[row][col+2] == player && board[row-1][col+2] == player) {
						winners += player;
					}
				}
			}
		}

		if (winners.length() > 0) {
			if (winners.length() == 1) {
				System.out.printf("Player %s wins.\n", winners);
			} else {
				System.out.print("Game ends in a tie. There is no winner.\n");
			}
			System.exit(0);
		}
	}

	public static boolean win(int player) {
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				if (board[row][col] == player && board[row+1][col] == player && board[row+2][col] == player && board[row][col+1] == player) {
					return true;
				}
			}

			for (int col = 1; col < 8; col++) {
				if (board[row][col] == player && board[row+1][col] == player && board[row+2][col] == player && board[row][col-1] == player) {
					return true;
				}
			}
		}
		return false;
	}

	public static void fill(int col, int num) {
		for (int row = 7; row >= 0; row--) {
			if (board[row][col] == 0) {
				board[row][col] = num;
				break;
			}
		}
	}

	public static void printBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("A B C D E F G H");
	}
}