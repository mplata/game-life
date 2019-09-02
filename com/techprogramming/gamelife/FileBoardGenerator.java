package com.techprogramming.gamelife;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
* Clase FileBoardGenerator
* 
* Crea un tablero basandose en el archivo local "data.txt",
* generandolo a partir de la regla:
*  - Si el caracter es '0', es un organismo vivo, caso contrario,
*  es un organismo muerto.
*  
* @author  Marcos Plata
* @author  Misael Burruel
* @version 1.0
* @since   2019-09-02
*/
public class FileBoardGenerator {
	
	private Scanner sc;

	public Board generateBoard() {
		sc = null;
		Board board = null;
		try {
			sc = new Scanner(new File("./data.txt"));
			String line;
			List<String> lines = new ArrayList<String>();
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				lines.add(line);
			}
			sc.close();
			board = new Board(lines.size(), lines.get(0).length());
			for (int i = 0; i < lines.size(); i++) {
				String l = lines.get(i);
				for (int j = 0; j < l.length(); j++) {
					char c=l.charAt(j);
					if(c == '0') {
						board.setAlive(i, j, true);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sc.close();
		}
		return board;
	}
}
