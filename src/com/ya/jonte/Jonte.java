package com.ya.jonte;

import java.util.Random;
import java.util.Scanner;

public class Jonte {

	
	public static void main(String[] args) {

		
		System.out.println("Välj 1-2\n1. Singleplayer\n2. Multiplayer");
		Scanner scan = new Scanner(System.in);
		int mode = scan.nextInt();
		
		char[][] gameBoard = { { '_', '|', '_', '|', '_' }, { '_', '|', '_', '|', '_' }, { ' ', '|', ' ', '|', ' ' }, };// Spelplanens uppbyggnad
		switch(mode) {		
		case 1: //Singleplayer
			printGameboard(gameBoard);

			while(true) {	
			Scanner sc = new Scanner(System.in);
			System.out.println("Placera spelbricka (1-9)");
			int playerPos = sc.nextInt();//Spelare 1 val
					
			placeToken(gameBoard, playerPos, "player");
		
			Random rnd = new Random();
			int cpuPos = rnd.nextInt(9) + 1;//Random val
			
			placeToken(gameBoard, cpuPos, "comp");//
			printGameboard(gameBoard);//Skriver ut spelplan
			
			}
			
			
		case 2: //Multiplayer
			printGameboard(gameBoard);
			
			while(true) {	
			Scanner sc = new Scanner(System.in);
			System.out.println("Placera spelbricka (1-9)");
			int playerPos = sc.nextInt();//Spelare 1 val
					
			placeToken(gameBoard, playerPos, "player");
			printGameboard(gameBoard);//Skriver ut spelplan
			System.out.println("Placera spelbricka (1-9)");
			int playerTwoPos = sc.nextInt();//spelare 2 val
			
			placeToken(gameBoard, playerTwoPos, "playerTwo");//
			printGameboard(gameBoard);//Skriver ut spelplan
			
			}
		
		
		}
		

	}
	public static void printGameboard(char[][] gameBoard) { //Metod för spelplan
		for (char[] row : gameBoard) {
			for (char i : row) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public static void placeToken(char[][] gameBoard, int input, String user) { //Metod för att placera x eller o

		char token = ' ';

		if (user.equals("player")) {
			token = 'x';			
		} else if (user.equals("playerTwo")) {
			token = 'o';			
		} else if (user.equals("comp")) {
			token = 'o';
		}

		switch (input) {
		case 1:
			gameBoard[0][0] = token;
			break;
		case 2:
			gameBoard[0][2] = token;
			break;
		case 3:
			gameBoard[0][4] = token;
			break;
		case 4:
			gameBoard[1][0] = token;
			break;
		case 5:
			gameBoard[1][2] = token;
			break;
		case 6:
			gameBoard[1][4] = token;
			break;
		case 7:
			gameBoard[2][0] = token;
			break;
		case 8:
			gameBoard[2][2] = token;
			break;
		case 9:
			gameBoard[2][4] = token;
			break;
		default:
			break;

		}

	}

}

/* saker att fixa:
 * 
 * göra så man inte kan skriva över andra spelarens markör,
 * göra så man inte kan lägga markören på redan lagt ställe
 * kolla vinnare eller om det blir lika*/

