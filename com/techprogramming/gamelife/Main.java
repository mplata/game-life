package com.techprogramming.gamelife;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Ingresa tu nombre");
		
		Scanner scn = new Scanner(System.in);
		String line = scn.nextLine();
		System.out.println("Wep "+line);
		scn.close();
	}
}
