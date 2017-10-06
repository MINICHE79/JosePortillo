package app;

public class Main {

	public static void main(String[] args) {
		Bolsa<Integer> bolsa = new Bolsa<Integer>(Integer.class,1000);
		
		Integer i, vec[] = new Integer[1000];
		System.out.println("1000 NUMEROS");
		for (i = 0; i < vec.length; i++) {
			bolsa.add((int) (Math.random() * 1000 + 1));
		}
     
		bolsa.seleccion();
		
		bolsa.CountingSort();
        
        bolsa.gnomeSort();
		
        bolsa.insertionSort ();
		
        bolsa.heapSort();
		
        bolsa.CocktailSort();
		
        bolsa.Qsort();
        
        bolsa.shell();
	}

}
