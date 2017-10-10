package app;

import java.util.Scanner;

public class DecimalABases {
	static Scanner teclado;
	static int N;
	static int B;
	static String [] Nums = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	static int cont=0;
	static int res = 0;
	
	public static void main(String[] args) {
		teclado = new Scanner(System.in);
		System.out.println("Introduce el numero que vas a convertir");
		N = teclado.nextInt();
		System.out.println("Introduce la base a la que vas a convertir");
		B = teclado.nextInt();
		System.out.println("El numero en en base " + B + " es:");
		dao(N,B);
	}
		
	public static void dao(int n, int base) {
		if (n<1) {
			return ;
		} else {
			dao(n/base,base);
			System.out.print(Nums[n%base]);
		}
				   
	}

}
