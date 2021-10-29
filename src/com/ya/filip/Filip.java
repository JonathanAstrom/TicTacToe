package com.ya.filip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Filip {

	static ArrayList<Integer> playerOnePositions = new ArrayList<Integer>();
	static ArrayList<Integer> playerTwoPositions = new ArrayList<Integer>();
	static ArrayList<Integer> computerPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
//		char[][] gameBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
//				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		String[][] gameBoard = { { "     ", "|", "     ", "|", "     " }, { "-----", "+", "-----", "+", "-----" },
				{ "     ", "|", "     ", "|", "     " }, { "-----", "+", "-----", "+", "-----" },
				{ "     ", "|", "     ", "|", "     " } };
		printGameBoard(gameBoard);

		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.print("Player 1, enter your move (1-9): ");
			int playerOneMove = input.nextInt();
			while (playerOnePositions.contains(playerOneMove) || playerTwoPositions.contains(playerOneMove)) {
				System.out.print("You can't make a move on another players piece. \nTry again (1-9): ");
				playerOneMove = input.nextInt();
			}
			makeMove(gameBoard, playerOneMove, "Player1");

			printGameBoard(gameBoard);

			String result = checkWinner();
			System.out.println(result);

			System.out.print("Player 2, enter your move (1-9): ");
			int playerTwoMove = input.nextInt();
			while (playerOnePositions.contains(playerTwoMove) || playerTwoPositions.contains(playerTwoMove)) {
				System.out.print("You can't make a move on another players piece. \nTry again (1-9): ");
				playerOneMove = input.nextInt();
			}
			makeMove(gameBoard, playerTwoMove, "Player2");

//			 Kod för datorspelare
//			Random rand = new Random();
//			int computerMove = rand.nextInt(9) + 1;
//			while (playerOnePositions.contains(computerMove) || computerPositions.contains(computerMove)) {
//				System.out.print("You can't make a move on another players piece. \nTry again (1-9): ");
//				playerOneMove = input.nextInt();
//			}
//			makeMove(gameBoard, computerMove, "Computer");

			printGameBoard(gameBoard);

			result = checkWinner();
			System.out.println(result);
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
				return "Player 1 has won. Congratulations!";
			} else if (playerTwoPositions.containsAll(list)) {
				return "Player 2 has won. Congratulations!";
			} else if (computerPositions.containsAll(list)) {
				return "Computer has won. Good luck next time!";
			} else if (playerOnePositions.size() + playerTwoPositions.size() == 9
					|| playerOnePositions.size() + computerPositions.size() == 9) {
				return "No winner. Try again!";
			}
		}
		return "";
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
			System.out.print("That is not a valid move. ");
			System.out.println();

		}
	}
}
