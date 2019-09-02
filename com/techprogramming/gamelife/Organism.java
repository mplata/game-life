package com.techprogramming.gamelife;

public class Organism {

	private boolean isAlive = false;
	
	public boolean isAlive() {
		return this.isAlive;
	}
	
	public void setAlive(boolean alive) {
		this.isAlive = alive;
	}
	
	
	public boolean aliveNextGen(Organism[] neighbors) {
		
		boolean alive = false;
		int totalAlives = 0;
		for (int i = 0; i < neighbors.length; i++) {
			if(neighbors[i] != null) {
				if(neighbors[i].isAlive()) totalAlives++;
			}
		}
		
		if(this.isAlive) {
			alive = totalAlives == 2 || totalAlives ==3;
		}else {
			alive = totalAlives == 3;
		}
		return alive;
	}
	
}
