package app;

import java.util.Scanner;

public class DecimalABinario {
	
	static Scanner teclado;
	static int N;
	
	public static void main(String[] args) {
		teclado = new Scanner(System.in);
		System.out.println("Introduce el numero que vas a convertir");
		N = teclado.nextInt();
		System.out.println("El numero en Binario es:");
		dab(N);
	}
	
	public static void dab(int n) {
		if (n<1) {
			System.out.print(n);
			return;
		} else {
			dab(n/2);
			System.out.print(n%2);
		}
	}

}
