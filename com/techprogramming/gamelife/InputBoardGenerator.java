package com.techprogramming.gamelife;

import java.util.Scanner;

public class InputBoardGenerator {
	
	public Board generateBoard() {
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Ingrese numero de filas");
		int totalRows = scn.nextInt();
		System.out.println("Ingrese numero de columnas");
		int totalColumns = scn.nextInt();
		
		System.out.println("Ingrese numero de organismos iniciales");
		int organismosIniciales = scn.nextInt();
		Board board = new Board(totalRows, totalColumns);
		
		for(int i=0;i<organismosIniciales; i++) {
			System.out.println("Ingrese X del organismo "+(i+1));
			int x = scn.nextInt();
			System.out.println("Ingrese Y del organismo "+(i+1));
			int y = scn.nextInt();
			board.addOrganism(x, y);
		}
		//scn.close();
		return board;
	}
}
