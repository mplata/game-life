package com.techprogramming.gamelife;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
* Proyecto "El juego de la Vida"
* Proyecto 1TP MCC 2019
* 
* @author  Marcos Plata
* @author  Misael Burruel
* @version 1.0
* @since   2019-09-02
*/
public class Main {
	
	/**
   * Metodo Main, inicia la ejecución del programa
   * Pregunta al usuario como quiere generar su tablero
   * Imprime las generaciones hasta que se cumpla alguna
   * de las condiciones de salida
	*/
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
				System.out.println("Ingrese un numero valido");
				scanner = new Scanner(System.in);
				choice = 0;
			}
		}
		
		int maxGenerations = 0;
		while(maxGenerations > 50 || maxGenerations < 1) {
			System.out.println("Numero de generaciones del juego (entre 1 y 50): ");
			
			try {
				maxGenerations = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Ingrese un numero valido");
				scanner = new Scanner(System.in);
				maxGenerations = 0;
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
		while(currentBoard.isAlive() && currentGen <= maxGenerations - 1) {
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
