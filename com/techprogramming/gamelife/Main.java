package com.techprogramming.gamelife;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int rows = 8;
		int columns = 10;
		Board board = new Board(rows,columns);
		Scanner scn = new Scanner(System.in);

		System.out.println("Ingrese numero de organismos iniciales");
		
		int organismosIniciales = scn.nextInt();
		System.out.println("Organismos iniciales "+organismosIniciales);
		
		for(int i=0;i<organismosIniciales; i++) {
			System.out.println("Ingrese X del organismo "+(i+1));
			int x = scn.nextInt();
			System.out.println("Ingrese Y del organismo "+(i+1));
			int y = scn.nextInt();
			board.addOrganism(x, y);
		}
		scn.close();
	}
}
