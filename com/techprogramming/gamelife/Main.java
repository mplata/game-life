package com.techprogramming.gamelife;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		int currentGen = 1;
		Scanner scanner = new Scanner(System.in);
		
		int choice = 0;
		while(choice <1 || choice >3) {
			System.out.println("¿Como desea generar su tablero inicial?");
			System.out.println("1.- Seleccionar coordenadas");
			System.out.println("2.- Obtener de archivo (data.txt)");
			System.out.println("3.- Aleatoriamente");
			try {
				choice = scanner.nextInt();
			} catch (InputMismatchException e) {
				scanner = new Scanner(System.in);
				choice = 0;
			}
		}
		
		Board currentBoard = null;
		if(choice == 1) {
			InputBoardGenerator generator = new InputBoardGenerator();
			currentBoard = generator.generateBoard();
		}
		if(choice == 2) {
			FileBoardGenerator generator = new FileBoardGenerator();
			currentBoard = generator.generateBoard();
		}
		if(choice == 3) {
			RandomBoardGenerator generator = new RandomBoardGenerator();
			currentBoard = generator.generateBoard();
		}
		System.out.println("Generación "+currentGen);
		currentBoard.print();
		scanner.nextLine();
		while(currentBoard.isAlive()) {
			if(currentGen > 1) {
				System.out.println("Generación "+currentGen);
				currentBoard.print();
			} 
			currentBoard = currentBoard.nextGen();
			System.out.println("Presione enter para continuar....");
			scanner.nextLine();
		    currentGen++;
		}
		System.out.println("Generación Final ("+currentGen+")");
		currentBoard.print();
		scanner.close();
	}
}
