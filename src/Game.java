import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	static ArrayList<Integer> playerOnePositions = new ArrayList<Integer>();
	static ArrayList<Integer> playerTwoPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();

	public static void main(String[] args) {

		String[][] gameBoard = { { "     ", "|", "     ", "|", "     " }, { "-----", "+", "-----", "+", "-----" },
				{ "     ", "|", "     ", "|", "     " }, { "-----", "+", "-----", "+", "-----" },
				{ "     ", "|", "     ", "|", "     " } };

		System.out.println("Välj spelarläge(1-2): \n\n1. Spela mot dator \n2. Spela mot varandra");
		Scanner scan = new Scanner(System.in);
		int menuChoice = scan.nextInt();
		boolean gameOn = true;
		switch (menuChoice) {
		case 1: // Singleplayer
			printGameBoard(gameBoard);

			while (true) {
				Scanner sc = new Scanner(System.in);
				String result = checkWinner();
				System.out.print("Placera spelbricka (1-9): ");
				int playerPos = sc.nextInt();// Spelare 1 val
				while (playerOnePositions.contains(playerPos) || playerTwoPositions.contains(playerPos)) {
					System.out.print("Du kan inte lägga på en annan spelares position. \nFörsök igen (1-9): ");
					playerPos = sc.nextInt();
				}

				makeMove(gameBoard, playerPos, "Player1");
				printGameBoard(gameBoard);
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}

				Random rnd = new Random();
				int cpuPos = rnd.nextInt(9) + 1;// Random val
				while (playerOnePositions.contains(cpuPos) || computerPositions.contains(cpuPos)) {
					cpuPos = rnd.nextInt(9) + 1;
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				makeMove(gameBoard, cpuPos, "Computer");
				printGameBoard(gameBoard);
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}

			}
			break;

		case 2: // Multiplayer
			printGameBoard(gameBoard);

			while (true) {
				String result = checkWinner();
				Scanner sc = new Scanner(System.in);
				System.out.print("Spelare 1, placera spelbricka (1-9): ");
				int playerPos = sc.nextInt();// Spelare 1 val
				while (playerOnePositions.contains(playerPos) || playerTwoPositions.contains(playerPos)) {
					System.out.print("Du kan inte lägga på en annan spelares position. \nFörsök igen (1-9): ");
					playerPos = sc.nextInt();
				}
				makeMove(gameBoard, playerPos, "Player1");
				printGameBoard(gameBoard);
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}
				System.out.print("Spelare 2, placera spelbricka (1-9): ");
				int playerTwoPos = sc.nextInt();// spelare 2 val
				while (playerOnePositions.contains(playerTwoPos) || playerTwoPositions.contains(playerTwoPos)) {
					System.out.print("Du kan inte lägga på en annan spelares position. \nFörsök igen (1-9): ");
					playerTwoPos = sc.nextInt();
				}
				makeMove(gameBoard, playerTwoPos, "Player2");
				printGameBoard(gameBoard);
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}

			}
		}

	}

	public static void printGameBoard(String[][] gameBoard) {
		System.out.println();
		for (String[] row : gameBoard) {
			for (String column : row) {
				System.out.print(column);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void makeMove(String[][] gameBoard, int move, String player) {

		String symbol = "";
		if (player.equals("Player1")) {
			symbol = "  X  ";
			playerOnePositions.add(move);
		} else if (player.equals("Player2")) {
			symbol = "  O  ";
			playerTwoPositions.add(move);
		} else if (player.equals("Computer")) {
			symbol = "  O  ";
			computerPositions.add(move);
		}

		switch (move) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			System.out.print("Ogiltigt drag ");
			System.out.println();

		}

	}

	public static String checkWinner() {

		List topRow = Arrays.asList(1, 2, 3);
		List middleRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List leftColumn = Arrays.asList(1, 4, 7);
		List middleColumn = Arrays.asList(2, 5, 8);
		List rightColumn = Arrays.asList(3, 6, 9);
		List diagonal1 = Arrays.asList(1, 5, 9);
		List diagonal2 = Arrays.asList(7, 5, 3);

		List<List> winningConditions = new ArrayList<List>();
		winningConditions.add(topRow);
		winningConditions.add(middleRow);
		winningConditions.add(bottomRow);
		winningConditions.add(leftColumn);
		winningConditions.add(middleColumn);
		winningConditions.add(rightColumn);
		winningConditions.add(diagonal1);
		winningConditions.add(diagonal2);

		for (List list : winningConditions) {
			if (playerOnePositions.containsAll(list)) {
				return "Spelare 1 har vunnit. Grattis!";
			} else if (playerTwoPositions.containsAll(list)) {
				return "Spelare 2 har vunnit. Grattis!";
			} else if (computerPositions.containsAll(list)) {
				return "Datorn har vunnit. Lycka till nästa gång!";
			} else if (playerOnePositions.size() + playerTwoPositions.size() == 9
					|| playerOnePositions.size() + computerPositions.size() == 9) {
				return "Oavgjort! Försök igen: ";
			}
		}
		return "";
	}
}
