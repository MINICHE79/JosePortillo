package app;

import java.util.ArrayList;
import java.util.Arrays;
	
public class Sales<E> {
		
	private ArrayList<Double[]> Mes = new ArrayList<>();
	int m;
	Double[] Ordenado;
	double venta;
	
	public Sales(int m, double venta){
		this.m = m;
		
		Mes.add(new Double[]{54d,87.21,23.6,65.9,21.8,76.4,98.4,46.65,26d,84.48,54.50,3.9,2.01,98.32,74.15,5d,10d,28d,6d,13d,20d,86.98,12.3,84d,6.2,54.8d,65d,21d,68d,45d,8.02}); //enero
		Mes.add(new Double[]{2d,8.8,2d,6.8,2.3,8.2,4.5,56d,1d,4.5,33.9,22.01,2.83,6.42,98.42,43.55,68d,7d,23d,14d,57.71,83.6,95.9,14d,22.22,34.62d,75d,81d});//febrero
		Mes.add(new Double[]{2.12,18.8,4d,84d,56d,72.2,254d,4.53,56d,2.1,3.9,42.41,5.13,12.54,1.8,2.3,8.2,7d,23d,34.62d,12d,27.11,76.5,45.3,29d,75d,2.5,6.42,98.42,43.55,68d});//marzo
		Mes.add(new Double[]{1.8,2.3,8.2,7d,13.8,26.5,38.67d,72.54,3.9,42.41,5.13,12.54,8.81,56d,22.1,33.9,42.51,56.13,43d,54d,76d,82.2,54d,41.53,17d,21.11,56.5,95.3,59d,42.12});//abril
		Mes.add(new Double[]{56d,22.1,33.9,42.51,56.13,72.54,13.8,26.5,62.52,48.82,93.15,18d,26.3,88.2,77d,26d,38.67d,17d,21.11,56.5,95.3,59d,25d,42.12,8.81,43d,54d,76d,82.2,54d,41.53});//mayo
		Mes.add(new Double[]{3.9,42.41,12.54,2.17d,23d,34.62,54d,76d,82.2,54d,41.53,17d,2.3,8.2,1.8,2.3,3.9,22.1,33.9,42.51,56.13,43d,2.12,18.8,38.67d,72.54,7d});//junio
		Mes.add(new Double[]{30.00,79.03,68.48,46.54,82.30,70.54,50.93,21.65,66.39,4.22,60.78,60.36,95.70,51.74,98.44,90.71,30.68,69.08,98.55,68.33,32.71,93.95,52.70,71.49,30.27,96.73,97.99,37.35,15.04,65.91,26.56});//julio
		Mes.add(new Double[]{73.71,9.90,12.65,98.97,94.33,51.95,42.80,38.13,6.42,10.19,79.77,75.28,6.23,4.35,29.13,74.22,7.84,89.83,94.71,85.66,99.84,69.35,38.58,27.14,10.81,83.61,94.54,27.87,2.09,29.22,18.32});//agosto
		Mes.add(new Double[]{55.88,35.54,63.66,83.16,68.56,10.64,43.84,80.31,12.87,96.02,90.70,84.21,48.35,0.04,34.10,50.06,60.55,83.13,42.21,2.11,35.88,43.33,71.48,90.23,55.20,50.06,90.88,81.51,57.93,12.25});//septiembre
		Mes.add(new Double[]{8.21,20.21,11.75,31.94,67.82,55.95,96.33,55.67,68.8,28.97,85.81,79.51,70.06,72.29,1.37,28.67,11.5,59d,90.31,98.86,18.26,74.8,20.44,84.36,62.12,55.84,92.58,74.71,85.12,62.42,28.32});//octubre
		Mes.add(new Double[]{60.77,40.44,40.08,17.15,8.59,79.41,42.53,92.14,4.63,55.12,6.02,65.2,1.12,54.36,94.12,91.86,96.41,36.04,2.04,64.02,32.74,52.86,8.45,31.24,54.7,54.14,81.18,9.67,32.55,67.75});//noviembre
		Mes.add(new Double[]{38.53,61.83,17.44,57.62,38.94,11.89,88.45,92.88,37.09,27.9,69.2,82.89,86.92,54.44,94.97,74.02,53.53,10.04,99.12,72.38,6.15,82.83,19.68,9.61,69.64,91.46,85.62,56.87,66.4,10.7,44.38}//diciembre
);

		//LLenarVentas(); //este llena los dias con un random
		
		printer(); //Imprime las ventas del mes
		
		System.out.println(busqueda(seleccion(), venta)); //ordena y hace la busqueda binaria
		
		pronter(Ordenado); // imprime las ventas del mes ordenadas
	}
		
	public void LLenarVentas(){
		for (int i = 0; i < Mes.size(); i++){
			for (int j = 0; j < Mes.get(i).length; j++) {
				Mes.get(i)[j] = (Double) ((Math.random() * 100));
			}
		}
	}	
	
	public Double[] seleccion() {//metodo de ordenamiento
		
		Ordenado = (Double[]) Arrays.copyOf(Mes.get(m), Mes.get(m).length);
		int i, j, pos;
		Double menor , tmp;
      
        for (i = 0; i < Ordenado.length - 1; i++) {
              menor = Ordenado[i];
              pos = i;
              for (j = i + 1; j < Ordenado.length; j++){
                    if (Ordenado[j].compareTo(menor) < 0) {
                        menor = Ordenado[j];
                        pos = j;
                    }
              }
              if (pos != i){
                  tmp = Ordenado[i];
                  Ordenado[i] = Ordenado[pos];
                  Ordenado[pos] = tmp;
              }
        }
        return Ordenado;
	}
	
	
	private static String busqueda(Double[] arreglo, Double dato) {//busqueda binaria
		return Recursiva(arreglo, 0, arreglo.length - 1, dato);
	}

	private static String Recursiva(Double[] arreglo, int inicio, int fin, Double dato) {//busqueda binaria
		int pos = (fin + inicio) / 2;
		if (inicio > fin){
			return "Venta no encontrada";
		}
		else if(arreglo[pos].equals(dato)) 
			return "La venta : $" + dato + " es la '" + (pos+1) + "' venta de menor a mayor";
		else if (arreglo[pos] < dato)
			return Recursiva(arreglo, pos+1, fin, dato);
		else
			return Recursiva(arreglo, inicio, pos-1, dato);
	}
	
	public void printer(){
		System.out.println("Ventas del mes");
		for (int i = 0; i < Mes.get(m).length; i++) {
			System.out.println("En el dia " + (i+1) + " del mes se vendió: $" + Mes.get(m)[i] );
		}
	}
	public void pronter(Double[] Ordenado){
		System.out.println("Ventas del mes Ordenadas");
		for (int i = 0; i < Ordenado.length; i++) {
			System.out.println((i+1) + "°- $" + Ordenado[i]);
		}
	}
}
	


