package app;

import listas.LinkedList;

public class App {

	public static void main(String[] args){
		LinkedList<String> names     = new LinkedList<String>();
		LinkedList<String> lastnames = new LinkedList<String>();
		LinkedList<Integer>ages      = new LinkedList<Integer>();
		
		//Agregar
		names.Add("Pepe");
		names.AddFirst("Gardea");
		names.AddLast("Ricardos");
		names.AddLastRec("Chardo");
		names.addbefore("Ricardos","karla");
		names.addAfter("karla", "loli");
		
		//Imprimir Valores varios
		System.out.println("Imprimir");
		names.pronter();
		System.out.println("Is Empty: " + names.IsEmpty());
		names.size();
		System.out.println("");
		System.out.println("Index Of / Get first / Get Last");
		names.indexof("loli");
		names.getfirst();
		names.getlast();
		
		//Remove y Replace
		System.out.println("");
		names.remove("karla");
		names.removefirst();
		names.removelast();
		names.RemoveAfter("loli");
		names.RemoveBefore("loli");
		names.Replace("loli", "Eduardo");
//		names.clear();
		
		
		//Volver a imprimir
		System.out.println("Volver a imprimir despues de modificar");
		names.printer();
		
		
	}
}
