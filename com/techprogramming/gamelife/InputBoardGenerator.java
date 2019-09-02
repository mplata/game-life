package com.techprogramming.gamelife;

import java.util.Scanner;
/**
* Clase FileBoardGenerator
* 
* Crea un tablero basandose en las entradas por consola del usuario
* Preguntando los siguientes datos:
* 1.- El numero de filas del tablero
* 2.- El numero de columnas del tablero
* 3.- El numero de organismos iniciales.
* 4.- Para cada organismo, su coordenada X, y Y
* @author  Marcos Plata
* @author  Misael Burruel
* @version 1.0
* @since   2019-09-02
*/
public class InputBoardGenerator {
	
	public Board generateBoard() {
		int k = 0 , x = 0, y = 0, totalRows = 0, totalColumns = 0, organismosIniciales;
		Scanner scn = new Scanner(System.in);
		do {
			System.out.println("Ingrese numero de filas");
			totalRows = scn.nextInt();
			if (totalRows <= 1)
			{
				System.out.println("Introduzca un valor mayor a 1.");
				k = 0;
			}
			else {
				k = 1;
			}
		}while (k == 0);
		do {
			System.out.println("Ingrese numero de columnas");
			totalColumns = scn.nextInt();
			if (totalColumns <= 1) {
				System.out.println("Introduzca un valor mayor a 1.");
				k = 0;
			}
			else {
				k = 1;
			}
		}while (k == 0);
		do {
			System.out.println("Ingrese numero de organismos iniciales");
			organismosIniciales = scn.nextInt();
			if(organismosIniciales < 1 ) {
				System.out.println("Introduzca un valor mayor a 0.");
				k = 0;
			}
			else {
				k=1;
			}
		}while(k == 0);
		Board board = new Board(totalRows, totalColumns);

		for(int i=0;i<organismosIniciales; i++) {
			do
			{
				System.out.println("Ingrese X del organismo "+(i+1));
				x = scn.nextInt();
				if (x > totalRows || x < 0) {
					System.out.println("!Error¡ Introduzca un numero valido.");
					k = 0;
				}
				else {
					k=1;
					x=x-1;
				}
			}
			while (k == 0);
			do {
				System.out.println("Ingrese Y del organismo "+(i+1));
				y = scn.nextInt();
				if( y > totalColumns || y < 0 ) {
					System.out.println("!Error¡ Introduzca un numero valido.");
					k = 0;
				}
				else {
					k = 1;
					y = y-1;
				}
			}while (k == 0);
			board.addOrganism(x, y);
		}
		//scn.close();
		return board;
	}
}
