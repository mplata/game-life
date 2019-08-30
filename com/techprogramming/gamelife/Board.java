package com.techprogramming.gamelife;

public class Board {
	
	public static final String ANSI_RESET = "\u001B[0m";
	private Organism organisms[][];
	
	Board(int rows, int columns){
		System.out.println("Tablero creado de "+rows+" filas y "+columns+" columnas");
		this.organisms = new Organism[rows][columns];
		Organism organism;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				organism = new Organism();
				this.organisms[i][j] = organism;
			}
		}
	}
	
	public void addOrganism(int x, int y) {
		this.organisms[x][y].setAlive();
		this.print();
	}
	
	public void print() {
		System.out.print("\t");
		for(int i=0; i<10; i++) {
			System.out.print(i+"\t");
		}
		System.out.println("");
		System.out.println("");
		for (int i = 0; i < this.organisms.length; i++) {
			System.out.print(i+"\t");
			for (int j = 0; j < this.organisms[i].length; j++) {
		        Organism o = this.organisms[i][j];
		        if(o.isAlive()){
		        	System.out.print("\u001B[32m"+"O"+ANSI_RESET+"\t");
		        }else {
		        	System.out.print("\u001B[31m"+"X"+"\u001B[31m"+ANSI_RESET+"\t");
		        }
		    }
		    System.out.println("");
		    System.out.println("");
		}
	}
	
	public void setAlive(int x,int y) {
		this.organisms[x][y].setAlive();
	}
}
