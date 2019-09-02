package com.techprogramming.gamelife;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
