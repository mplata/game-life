package com.techprogramming.gamelife;

import java.util.Random;
/**
* Clase FileBoardGenerator
* 
* Crea un tablero de manera aleatoria, con una
* cantidad de filas y columnas entre 4 y 7,
* y con una posibilidad de 50% de estar vivo o muerto.
* @author  Marcos Plata
* @author  Misael Burruel
* @version 1.0
* @since   2019-09-02
*/
public class RandomBoardGenerator implements BoardGenerator{

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
