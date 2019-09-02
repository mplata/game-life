package com.techprogramming.gamelife;

import java.util.Random;

public class RandomBoardGenerator {

	public Board generateBoard() {
		
		Random r = new Random();
		int length = r.nextInt(7-4)+4;
		Board board = new Board(length, length);
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				board.setAlive(i, j, Math.random() < 0.5);
			}
		}
		
		return board;
	}
}
