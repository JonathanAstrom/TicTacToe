package com.ya.jonte;

public class Jonte {

	public static void main(String[] args) {
		
		char[][] gameBoard = { { '_', '|', '_', '|', '_' }, { '_', '|', '_', '|', '_' }, { ' ', '|', ' ', '|', ' ' }, };//spelplanens uppbyggnad
		
		printGameboard(gameBoard);//kallar spelbrädet
	}
	
	public static void printGameboard(char[][] gameBoard) { // printar ut spelbrädet
		for (char[] row : gameBoard) {
			for (char i : row) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
