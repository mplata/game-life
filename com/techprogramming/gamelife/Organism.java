package com.techprogramming.gamelife;
/**
* Clase Organism
* 
* Clase para representar un organismo dentro del tablero del
* juego, encapsula si esta vivo o no, asi como la logica para 
* saber si vive para la siguiente generación en base a las reglas,
* conociendo sus 8 posiciones vecinas.
*  
* @author  Marcos Plata
* @author  Misael Burruel
* @version 1.0
* @since   2019-09-02
*/
public class Organism {

	private boolean isAlive = false;
	
	public boolean isAlive() {
		return this.isAlive;
	}
	
	public void setAlive(boolean alive) {
		this.isAlive = alive;
	}
	
	/*
	 * Decide si el organismo vive o muere para la siguiente generación
	 * Basandose en las siguientes reglas:
	 * Si el organismo esta vivo actualmente:
	 * 		-Vive si tiene de 2 a 3 vecinos vivos
	 * 		-Muere si tiene menos de 2 vecinos (aislamiento)
	 * 		-Muere si tiene mas de 3 vecinos (hacinamiento)
	 * Si el organismo esta muerto actualmente:
	 * 		-Vive si tiene exactamente 3 vecinos vivos.
	 * 		-Muere si tiene menos de 3 o mas de 3 vecinos vivos
	 * */
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
