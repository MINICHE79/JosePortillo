package app;

import java.io.Console;
import java.util.Scanner;

public class Main {
	
	static int mes;
	static double venta;
	static Scanner teclado;
		
	public static void main(String[] args) {
		teclado = new Scanner(System.in);
		System.out.println("Selecciona un mes");
		System.out.println("1-Enero");
		System.out.println("2-Febrero");
		System.out.println("3-Marzo");
		System.out.println("4-Abril");
		System.out.println("5-Mayo");
		System.out.println("6-Junio");
		System.out.println("7-Julio");
		System.out.println("8-Agosto");
		System.out.println("9-Septiembre");
		System.out.println("10-Octubre");
		System.out.println("11-Noviembre");
		System.out.println("12-Diciembre");
		
		mes = teclado.nextInt() -1;
		if(mes > 11){
			System.out.println("mes no existe");
			return;
		}
		
		System.out.println("");
		System.out.println("Que venta deseas buscar");
		venta = teclado.nextDouble();
		
		System.out.println(venta);
		Sales s = new Sales(mes,venta);
	}
}
