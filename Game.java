import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private static Scanner sc;
	static String userIcon;
	static String computerIcon;
	static String first;
	static String reset;
	static Integer userIn;
	static List<Integer> usedNumbers = new ArrayList<Integer>();
	static String[] board1;
	static String[] board2;
	static String[] board3;
	static Boolean gameOver = false;
	static Boolean exit = false;
	static Random ran = new Random();
	static Integer turnCounter = 0;

	public static void UserMove() {
		CheckMove();
		switch (userIn) {
		case 1:
			board1[0] = userIcon;
			break;

		case 2:
			board1[1] = userIcon;
			break;

		case 3:
			board1[2] = userIcon;
			break;

		case 4:
			board2[0] = userIcon;
			break;

		case 5:
			board2[1] = userIcon;
			break;

		case 6:
			board2[2] = userIcon;
			break;

		case 7:
			board3[0] = userIcon;
			break;

		case 8:
			board3[1] = userIcon;
			break;

		case 9:
			board3[2] = userIcon;
			break;

		default:
			System.out.println("Oops!");
			break;
		}
		turnCounter++;
		usedNumbers.add(userIn);
		PrintBoard();
		CheckWin();
		if (gameOver != true) {
			ComputerMove();
		} else {
			Reset();
		}
	}

	public static void ComputerMove() {
		// Block users winning move.

		if ((board1[0] == computerIcon) && (board2[1] == computerIcon) && (board3[2] == " ")) { // 1 + 5
			board3[2] = computerIcon;
			usedNumbers.add(9);
		} else if ((board1[0] == computerIcon) && (board1[1] == computerIcon) && (board1[2] == " ")) { // 1 + 2
			board1[2] = computerIcon;
			usedNumbers.add(3);
		} else if ((board1[0] == computerIcon) && (board2[0] == computerIcon) && (board3[0] == " ")) { // 1 + 4
			board3[0] = computerIcon;
			usedNumbers.add(7);
		} else if ((board1[1] == computerIcon) && (board2[1] == computerIcon) && (board3[1] == " ")) { // 2 + 5
			board3[1] = computerIcon;
			usedNumbers.add(8);
		} else if ((board1[1] == computerIcon) && (board1[2] == computerIcon) && (board1[0] == " ")) { // 2 + 3
			board1[0] = computerIcon;
			usedNumbers.add(1);
		} else if ((board1[2] == computerIcon) && (board2[2] == computerIcon) && (board3[2] == " ")) { // 3 + 6
			board3[2] = computerIcon;
			usedNumbers.add(9);
		} else if ((board1[2] == computerIcon) && (board2[1] == computerIcon) && (board3[0] == " ")) { // 3 + 5
			board3[0] = computerIcon;
			usedNumbers.add(7);
		} else if ((board2[0] == computerIcon) && (board2[1] == computerIcon) && (board2[2] == " ")) { // 4 + 5
			board2[2] = computerIcon;
			usedNumbers.add(6);
		} else if ((board2[0] == computerIcon) && (board3[0] == computerIcon) && (board1[0] == " ")) { // 4 + 7
			board1[0] = computerIcon;
			usedNumbers.add(1);
		} else if ((board2[1] == computerIcon) && (board2[2] == computerIcon) && (board2[0] == " ")) { // 5 + 6
			board2[0] = computerIcon;
			usedNumbers.add(4);
		} else if ((board2[1] == computerIcon) && (board3[1] == computerIcon) && (board1[1] == " ")) { // 5 + 8
			board1[1] = computerIcon;
			usedNumbers.add(2);
		} else if ((board2[2] == computerIcon) && (board3[2] == computerIcon) && (board1[2] == " ")) { // 6 + 9
			board1[2] = computerIcon;
			usedNumbers.add(3);
		} else if ((board3[0] == computerIcon) && (board3[1] == computerIcon) && (board3[2] == " ")) { // 7 + 8
			board3[2] = computerIcon;
			usedNumbers.add(9);
		} else if ((board3[0] == computerIcon) && (board2[1] == computerIcon) && (board1[2] == " ")) { // 7 + 5
			board1[2] = computerIcon;
			usedNumbers.add(3);
		} else if ((board3[1] == computerIcon) && (board3[2] == computerIcon) && (board3[0] == " ")) { // 8 + 9
			board3[0] = computerIcon;
			usedNumbers.add(7);
		} else if ((board3[2] == computerIcon) && (board2[1] == computerIcon) && (board1[0] == " ")) { // 9 + 5
			board1[0] = computerIcon;
			usedNumbers.add(1);
		} else if ((board1[0] == computerIcon) && (board3[2] == computerIcon) && (board2[1] == " ")) { // 1 + 9
			board2[1] = computerIcon;
			usedNumbers.add(5);
		} else if ((board1[0] == computerIcon) && (board1[2] == computerIcon) && (board1[1] == " ")) { // 1 + 3
			board1[1] = computerIcon;
			usedNumbers.add(2);
		} else if ((board1[0] == computerIcon) && (board3[0] == computerIcon) && (board2[0] == " ")) { // 1 + 7
			board2[0] = computerIcon;
			usedNumbers.add(4);
		} else if ((board3[0] == computerIcon) && (board3[2] == computerIcon) && (board3[1] == " ")) { // 7 + 9
			board3[1] = computerIcon;
			usedNumbers.add(8);
		} else if ((board3[2] == computerIcon) && (board1[2] == computerIcon) && (board2[2] == " ")) { // 9 + 3
			board2[2] = computerIcon;
			usedNumbers.add(6);
		} else if ((board3[2] == computerIcon) && (board1[0] == computerIcon) && (board2[1] == " ")) { // 9 + 1
			board2[1] = computerIcon;
			usedNumbers.add(5);
		} else if ((board3[0] == computerIcon) && (board1[2] == computerIcon) && (board2[1] == " ")) { // 7 + 3
			board2[1] = computerIcon;
			usedNumbers.add(5);
		} else if ((board1[1] == computerIcon) && (board3[1] == computerIcon) && (board2[1] == " ")) { // 2 + 8
			board2[1] = computerIcon;
			usedNumbers.add(5);
		} else if ((board2[0] == computerIcon) && (board2[2] == computerIcon) && (board2[1] == " ")) { // 4 + 6
			board2[1] = computerIcon;
			usedNumbers.add(5);
			/*
			 * End of computer win logic, start of blocking user logic.
			 */
		} else if ((board1[0] == userIcon) && (board2[1] == userIcon) && (board3[2] == " ")) { // 1 + 5
			board3[2] = computerIcon;
			usedNumbers.add(9);
		} else if ((board1[0] == userIcon) && (board1[1] == userIcon) && (board1[2] == " ")) { // 1 + 2
			board1[2] = computerIcon;
			usedNumbers.add(3);
		} else if ((board1[0] == userIcon) && (board2[0] == userIcon) && (board3[0] == " ")) { // 1 + 4
			board3[0] = computerIcon;
			usedNumbers.add(7);
		} else if ((board1[1] == userIcon) && (board2[1] == userIcon) && (board3[1] == " ")) { // 2 + 5
			board3[1] = computerIcon;
			usedNumbers.add(8);
		} else if ((board1[1] == userIcon) && (board1[2] == userIcon) && (board1[0] == " ")) { // 2 + 3
			board1[0] = computerIcon;
			usedNumbers.add(1);
		} else if ((board1[2] == userIcon) && (board2[2] == userIcon) && (board3[2] == " ")) { // 3 + 6
			board3[2] = computerIcon;
			usedNumbers.add(9);
		} else if ((board1[2] == userIcon) && (board2[1] == userIcon) && (board3[0] == " ")) { // 3 + 5
			board3[0] = computerIcon;
			usedNumbers.add(7);
		} else if ((board2[0] == userIcon) && (board2[1] == userIcon) && (board2[2] == " ")) { // 4 + 5
			board2[2] = computerIcon;
			usedNumbers.add(6);
		} else if ((board2[0] == userIcon) && (board3[0] == userIcon) && (board1[0] == " ")) { // 4 + 7
			board1[0] = computerIcon;
			usedNumbers.add(1);
		} else if ((board2[1] == userIcon) && (board2[2] == userIcon) && (board2[0] == " ")) { // 5 + 6
			board2[0] = computerIcon;
			usedNumbers.add(4);
		} else if ((board2[1] == userIcon) && (board3[1] == userIcon) && (board1[1] == " ")) { // 5 + 8
			board1[1] = computerIcon;
			usedNumbers.add(2);
		} else if ((board2[2] == userIcon) && (board3[2] == userIcon) && (board1[2] == " ")) { // 6 + 9
			board1[2] = computerIcon;
			usedNumbers.add(3);
		} else if ((board3[0] == userIcon) && (board3[1] == userIcon) && (board3[2] == " ")) { // 7 + 8
			board3[2] = computerIcon;
			usedNumbers.add(9);
		} else if ((board3[0] == userIcon) && (board2[1] == userIcon) && (board1[2] == " ")) { // 7 + 5
			board1[2] = computerIcon;
			usedNumbers.add(3);
		} else if ((board3[1] == userIcon) && (board3[2] == userIcon) && (board3[0] == " ")) { // 8 + 9
			board3[0] = computerIcon;
			usedNumbers.add(7);
		} else if ((board3[2] == userIcon) && (board2[1] == userIcon) && (board1[0] == " ")) { // 9 + 5
			board1[0] = computerIcon;
			usedNumbers.add(1);
		} else if ((board1[0] == userIcon) && (board3[2] == userIcon) && (board2[1] == " ")) { // 1 + 9
			board2[1] = computerIcon;
			usedNumbers.add(5);
		} else if ((board1[0] == userIcon) && (board1[2] == userIcon) && (board1[1] == " ")) { // 1 + 3
			board1[1] = computerIcon;
			usedNumbers.add(2);
		} else if ((board1[0] == userIcon) && (board3[0] == userIcon) && (board2[0] == " ")) { // 1 + 7
			board2[0] = computerIcon;
			usedNumbers.add(4);
		} else if ((board3[0] == userIcon) && (board3[2] == userIcon) && (board3[1] == " ")) { // 7 + 9
			board3[1] = computerIcon;
			usedNumbers.add(8);
		} else if ((board3[2] == userIcon) && (board1[2] == userIcon) && (board2[2] == " ")) { // 9 + 3
			board2[2] = computerIcon;
			usedNumbers.add(6);
		} else if ((board3[2] == userIcon) && (board1[0] == userIcon) && (board2[1] == " ")) { // 9 + 1
			board2[1] = computerIcon;
			usedNumbers.add(5);
		} else if ((board3[0] == userIcon) && (board1[2] == userIcon) && (board2[1] == " ")) { // 7 + 3
			board2[1] = computerIcon;
			usedNumbers.add(5);
		} else if ((board1[1] == userIcon) && (board3[1] == userIcon) && (board2[1] == " ")) { // 2 + 8
			board2[1] = computerIcon;
			usedNumbers.add(5);
		} else if ((board2[0] == userIcon) && (board2[2] == userIcon) && (board2[1] == " ")) { // 4 + 6
			board2[1] = computerIcon;
			usedNumbers.add(5);
		} else {

			// Checking Computer move for validity.
			int r = ran.nextInt(8) + 1;
			while (usedNumbers.contains(r)) {
				r = ran.nextInt(8) + 1;
			}
			switch (r) {
			case 1:
				board1[0] = computerIcon;
				break;

			case 2:
				board1[1] = computerIcon;
				break;

			case 3:
				board1[2] = computerIcon;
				break;

			case 4:
				board2[0] = computerIcon;
				break;

			case 5:
				board2[1] = computerIcon;
				break;

			case 6:
				board2[2] = computerIcon;
				break;

			case 7:
				board3[0] = computerIcon;
				break;

			case 8:
				board3[1] = computerIcon;
				break;

			case 9:
				board3[2] = computerIcon;
				break;

			default:
				System.out.println("Oops!");
				break;
			}
			usedNumbers.add(r);
		}

		turnCounter++;
		System.out.println("Computers Move:");
		PrintBoard();
		CheckWin();
		if (gameOver != true) {
			UserMove();
		} else {
			Reset();
		}
	}

	public static void PrintBoard() {
		System.out.println(java.util.Arrays.toString(board1));
		System.out.println(java.util.Arrays.toString(board2));
		System.out.println(java.util.Arrays.toString(board3));
	}

	public static void CheckWin() {
		// All TicTacToe win conditions
		if ((board1[0] == userIcon && board1[1] == userIcon && board1[2] == userIcon)
				|| (board1[0] == userIcon && board2[0] == userIcon && board3[0] == userIcon)
				|| (board1[0] == userIcon && board2[1] == userIcon && board3[2] == userIcon)
				|| (board3[0] == userIcon && board3[1] == userIcon && board3[2] == userIcon)
				|| (board1[2] == userIcon && board2[2] == userIcon && board3[2] == userIcon)
				|| (board1[2] == userIcon && board2[1] == userIcon && board3[0] == userIcon)
				|| (board1[1] == userIcon && board2[1] == userIcon && board3[1] == userIcon)
				|| (board2[0] == userIcon && board2[1] == userIcon && board2[2] == userIcon)) {

			System.out.println("---------");
			System.out.println("You Win!");
			PrintBoard();
			gameOver = true;

		} else if ((board1[0] == computerIcon && board1[1] == computerIcon && board1[2] == computerIcon)
				|| (board1[0] == computerIcon && board2[0] == computerIcon && board3[0] == computerIcon)
				|| (board1[0] == computerIcon && board2[1] == computerIcon && board3[2] == computerIcon)
				|| (board3[0] == computerIcon && board3[1] == computerIcon && board3[2] == computerIcon)
				|| (board1[2] == computerIcon && board2[2] == computerIcon && board3[2] == computerIcon)
				|| (board1[2] == computerIcon && board2[1] == computerIcon && board3[0] == computerIcon)
				|| (board1[1] == computerIcon && board2[1] == computerIcon && board3[1] == computerIcon)
				|| (board2[0] == computerIcon && board2[1] == computerIcon && board2[2] == computerIcon)) {

			System.out.println("---------");
			System.out.println("The Computer Wins!");
			PrintBoard();
			gameOver = true;
		} else if (turnCounter == 9) {
			System.out.println("It's a draw!");
			PrintBoard();
			gameOver = true;
		}
	}

	public static void CreateBoard() {
		board1 = new String[3];
		Arrays.fill(board1, " ");
		board2 = new String[3];
		Arrays.fill(board2, " ");
		board3 = new String[3];
		Arrays.fill(board3, " ");
	}

	public static void IconSelect() {
		System.out.println("Select User Character");
		sc = new Scanner(System.in);
		userIcon = sc.nextLine();
		// Check only one character long
		while (userIcon.length() != 1) {
			System.out.println("Please enter a single character.");
			userIcon = sc.nextLine();
		}
		System.out.println("Select Computer Character");
		computerIcon = sc.nextLine();
		// Check only one character long
		while (computerIcon.length() != 1) {
			System.out.println("Please enter a single character.");
			computerIcon = sc.nextLine();
		}
	}

	public static void WhoFirst() {
		System.out.println("Would you like to go first? Y/N");
		sc = new Scanner(System.in);
		first = sc.nextLine();
		if (first.equalsIgnoreCase("Y")) {
			System.out.println("Your first move.");
		} else if (first.equalsIgnoreCase("N")) {
			System.out.println("Computers first move.");
		} else {
			System.out.println("Invalid Answer");
		}
	}

	public static void Reset() {
		System.out.println("Would you like to restart? Y/N");
		sc = new Scanner(System.in);
		reset = sc.nextLine();
		while (!reset.equalsIgnoreCase("Y") && (!reset.equalsIgnoreCase("N"))) {
			System.out.println("Invalid answer.");
			System.out.println("Would you like to restart? Y/N");
			reset = sc.nextLine();
		}
		if (reset.equalsIgnoreCase("Y")) {
			first = " ";
			usedNumbers.clear();
			reset = " ";
			userIn = null;
			turnCounter = 0;
			board1 = new String[3];
			Arrays.fill(board1, " ");
			board2 = new String[3];
			Arrays.fill(board2, " ");
			board3 = new String[3];
			Arrays.fill(board3, " ");
			gameOver = false;
		} else if (reset.equalsIgnoreCase("N")) {
			exit = true;
		}
	}

	public static void CheckMove() {
		Boolean valid = false;
		while (valid != true) {
			System.out.println("Where would you like to go?");
			sc = new Scanner(System.in);
			// Check that input is Integer.
			while (!sc.hasNextInt()) {
				System.out.println("Please enter an Integer.");
				sc.next();
			}
			userIn = sc.nextInt();
			while (usedNumbers.contains(userIn) || (userIn > 9)) {
				System.out.println("You cannot go there. Select another position");
				while (!sc.hasNextInt()) {
					System.out.println("Please enter an Integer.");
					sc.next();
				}
				userIn = sc.nextInt();
			}
			if (!usedNumbers.contains(userIn)) {
				valid = true;
			}
		}
	}

	public static void main(String[] args) {
		// Game Loop
		while (exit == false) {
			CreateBoard();
			IconSelect();
			while (gameOver == false) {
				WhoFirst();
				if (first.equalsIgnoreCase("Y")) {
					PrintBoard();
					UserMove();
				} else if (first.equalsIgnoreCase("N")) {
					ComputerMove();
				}
			}
		}

	}

}