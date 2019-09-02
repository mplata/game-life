package com.techprogramming.gamelife;

public class Board {
	
	
	private Organism organisms[][];
	private int rows;
	private int columns;
	
	Board(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
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
		this.organisms[x][y].setAlive(true);
	}
	
	public void print() {
		System.out.print("\t");
		int columns = this.organisms[0].length;
		for(int i=0; i<columns; i++) {
			System.out.print(i+"\t");
		}
		System.out.println("");
		for (int i = 0; i < this.organisms.length; i++) {
			System.out.print(i+"\t");
			for (int j = 0; j < this.organisms[i].length; j++) {
		        Organism o = this.organisms[i][j];
		        if(o.isAlive()){
		        	System.out.print("O"+"\t");
		        }else {
		        	System.out.print("X"+"\t");
		        }
		    }
		    System.out.println("");
		    System.out.println("");
		}
	}
	
	public void setAlive(int x,int y, boolean alive) {
		this.organisms[x][y].setAlive(alive);
	}
	
	private Organism getOrganismAt(int x,int y) {
		if(x < 0 || y < 0 || x == this.rows || y == this.columns) {
			return null;
		}else {
			return this.organisms[x][y];
		}
	}
	
	private Organism[] getNeighbors(int x,int y) {
		
		Organism organisms[] = new Organism[8];
		
		organisms[0] = this.getOrganismAt(x -1, y -1);
		organisms[1] = this.getOrganismAt(x , y - 1);
		organisms[2] = this.getOrganismAt(x +1, y -1);
		organisms[3] = this.getOrganismAt(x -1, y );
		organisms[4] = this.getOrganismAt(x + 1, y );
		organisms[5] = this.getOrganismAt(x -1, y +1);
		organisms[6] = this.getOrganismAt(x, y +1);
		organisms[7] = this.getOrganismAt(x +1, y +1);
		
		return organisms;
	}
	
	public boolean isAlive() {
		boolean alive = false;
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				alive = this.organisms[i][j].isAlive();
				if(alive) return true;
			}
		}
		return alive;
	}
	
	public Board nextGen() {
		Board board = new Board(this.rows, this.columns);
		Organism org = null;
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				org = this.organisms[i][j];
				Organism[] neighbors = this.getNeighbors(i, j);
				boolean alive = org.aliveNextGen(neighbors);
				board.setAlive(i, j, alive);
			}
		}
		return board;
	}
}
