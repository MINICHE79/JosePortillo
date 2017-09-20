package app;

import java.util.Scanner;

public class Arreglos {
	
	private Scanner teclado = new Scanner(System.in);
	private int opc;
	int[][] ar;
	int[] v;
	
	
	
	public Arreglos(){
		
		
		System.out.println("Elije el ejercicio:");
		System.out.println("Ejercicio 1");
		System.out.println("Ejercicio 2");
		System.out.println("Ejercicio 3");
		System.out.println("Ejercicio 4");
		System.out.println("Ejercicio 5 - Metodo de ordenamiento: Selección");
		opc=teclado.nextInt();
		
		switch(opc){
			
		case 1:
			Ejercicio1();
			break;
		case 2:
			Ejercicio2();
			break;
		case 3:
			Ejercicio3();
			break;
		case 4:
			Ejercicio4();
			break;
		case 5:
			MetodoSeleccion();
			break;
		}
	}
	
	public void Ejercicio1(){
		int fil,col;
		System.out.print("Introduce las filas de la matriz: ");
		fil=teclado.nextInt();
		System.out.print("Introduce las columnas de la matriz: ");
		col=teclado.nextInt();
		ar = new int[fil][col];
		for (int f = 0; f < ar.length; f++) {
			for (int c = 0; c < ar[f].length; c++) {
				if(f==c){
					ar[f][c]=1;
				}else{
					ar[f][c]=0;
				}	
			}	
		}
		
		for (int f = 0; f < ar.length; f++) {
			for (int c = 0; c < ar[f].length; c++) {
				System.out.print(ar[f][c] + " ");
			}
			System.out.println();
		}
		
	}
	
	public void Ejercicio2(){
		int fil,col,cont;
		cont=0;
		System.out.print("Introduce las filas de la matriz: ");
		fil=teclado.nextInt();
		System.out.print("Introduce las columnas de la matriz: ");
		col=teclado.nextInt();
		ar = new int[fil][col];
		
		for (int f = (fil-1); f >= 0; f--) {
			for (int c = 0; c < col; c++) {
				if(cont==c){
					ar[f][c]=0;
				}else{
					ar[f][c]=1;
				}
			}	
			cont++;
		}
		
		for (int f = 0; f < ar.length; f++) {
			for (int c = 0; c < ar[f].length; c++) {
				System.out.print(ar[f][c] + " ");
			}
			System.out.println();
		}
		
	}

	public void Ejercicio3(){
		int fil,col;
		System.out.print("Introduce las filas de la matriz: ");
		fil=teclado.nextInt();
		System.out.print("Introduce las columnas de la matriz: ");
		col=teclado.nextInt();
		ar = new int[fil][col];
		v = new int [fil];
		
		for (int f = 0; f < ar.length; f++) {
			for (int c = 0; c < ar[f].length; c++) {
				System.out.println("Introduce el numero en la posicion (" + f + "," + c + ")");
				ar[f][c] = teclado.nextInt();
				if(ar[f][c] % 2 == 0){
					v[f] = v[f] + ar[f][c];
				}
				
			}	
		}
		
		for (int f = 0; f < ar.length; f++) {
			for (int c = 0; c < ar[f].length; c++) {
				System.out.print(ar[f][c] + " ");
			}
			System.out.println();
		}
		System.out.println("");
		System.out.println("Suma de los numeros pares de las filas");
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
	}

	public void Ejercicio4(){
		int fil,col,Mayor,Menor;
		String posMay, posMen;
		System.out.print("Introduce las filas de la matriz: ");
		fil=teclado.nextInt();
		System.out.print("Introduce las columnas de la matriz: ");
		col=teclado.nextInt();
		ar = new int[fil][col];
		v = new int [fil];
		for (int f = 0; f < ar.length; f++) {
			for (int c = 0; c < ar[f].length; c++) {
				System.out.println("Introduce el numero en la posicion (" + f + "," + c + ")");
				ar[f][c] = teclado.nextInt();
			}	
		}
		Mayor = ar[0][0];
		Menor = ar[0][0];
		posMay = "(0,0)";
		posMen = "(0,0)";
		for (int f = 0; f < ar.length; f++) {
			for (int c = 0; c < ar[f].length; c++) {
				if(ar[f][c] > Mayor){
					Mayor = ar[f][c];
					posMay = "(" + f + "," + c + ")";
				}
				if(ar[f][c] < Menor){
					Menor = ar[f][c];
					posMen = "(" + f + "," + c + ")";
				}	
			}	
		}
		
		for (int f = 0; f < ar.length; f++) {
			for (int c = 0; c < ar[f].length; c++) {
				System.out.print(ar[f][c] + " ");
			}
			System.out.println();
		}
		System.out.println("El numero "+ Mayor +" en la posicion " + posMay + " es el Mayor");
		System.out.println("El numero "+ Menor +" en la posicion " + posMen + " es el Menor");
	}
	
	public void MetodoSeleccion(){
		int fil,col,menor, pos, tmp;
		System.out.print("Introduce el tamaño del arreglo: ");
		fil=teclado.nextInt();
		v = new int[fil];
		
		for (int f = 0; f < v.length; f++) {
			System.out.println("Introduce el numero en la posicion ("+ f +")");
			v[f] = teclado.nextInt();				
				
		}
		System.out.println("Arreglo sin ordenar");
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
		System.out.println("");
        for (int i = 0; i < v.length - 1; i++) { // tomamos como menor el primero
        	menor = v[i]; // de los elementos que quedan por ordenar
            pos = i; // y guardamos su posición
            for (int j = i + 1; j < v.length; j++){ // buscamos en el resto
                  if (v[j] < menor) { // del array algún elemento
                      menor = v[j]; // menor que el actual
                      pos = j;
                  }
            }
            if (pos != i){ // si hay alguno menor se intercambia
                tmp = v[i];
                v[i] = v[pos];
                v[pos] = tmp;
            }
        }
        
        System.out.println("Arreglo Ordenado");
        for (int i = 0; i < v.length; i++) {
        	System.out.print(v[i] + " ");
		}
	}
}
