package listas;

import java.lang.management.GarbageCollectorMXBean;

import node.node;

//Constructores

public class LinkedList<T> {
	private node<T> sentinel=null;

	public LinkedList(){
		sentinel = new node<T>();
		sentinel.setIndex(-1);
	}
	
	public LinkedList(T value) {
		this();
		node<T> tmp = new node<T>(value);
		tmp.setIndex(0);
		sentinel.setNext(tmp);
	}
	
	//Metodos Agragar
	
	public void Add(T value){
		node <T> nuevo = new node<T>(value);
		nuevo.setNext(sentinel.getNext());
		sentinel.setNext(nuevo);
		Reindex();
	}
	
	public void AddFirst(T value) {
		node<T> tmp = sentinel.getNext();
		node<T> nuevo = new node<T>(value);
		nuevo.setNext(tmp);
		sentinel.setNext(nuevo);
		Reindex();
	}
	
	public void AddLast(T value){
		node<T> tmp = sentinel;	
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
		}
		tmp.setNext(new node<T>(value));
		Reindex();
	}
	
	public void AddLastRec(T value){
		node<T> tmp = sentinel.getNext();
		AddLastRec(tmp,value);
	}
	
	private void AddLastRec(node<T> tmp,T value){
		if(tmp.getNext() == null){
			tmp.setNext(new node<T>(value));
			Reindex();
			return;
		}
		else{
			AddLastRec(tmp.getNext(), value);
		}
		
	}
	
	public boolean addbefore(T value, T newvalue){
		node<T> tmp = sentinel;

		while(tmp.getNext()!= null && !tmp.getNext().getValue().equals(value)){
			tmp = tmp.getNext();
		}
		return (tmp.getNext()!=null)?addAfter(new node<T>(newvalue),tmp):false;
	}
	
	public boolean addAfter(T value, T newvalue){
		node<T> finder = search(value);
		if(finder != null){
			return addAfter(new node<T>(newvalue),finder);
		}
		else{
			return false;
		}
	}
	
	public boolean addAfter(T value, node<T> nodo){
		node<T> finder = search(value);
		if (finder != null){
			return addAfter(nodo, finder);
		}
		else{
			return false;
		}
	}
	
	private boolean addAfter (node<T> nodo, node<T> finder){
		nodo.setNext(finder.getNext());
		finder.setNext(nodo);
		Reindex();
		return true;
	}
	
	//Metodos Get
	
	public void getfirst(){
		node<T> tmp = sentinel.getNext();
		if(tmp != null)
			System.out.println(tmp.getValue());
		else
			System.out.println("lista vacia");
	}
	
	public void getlast(){
		node<T> tmp = sentinel;	
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
		}
		System.out.println(tmp.getValue());
	}
	
	//Metodos de Busqueda
	
	public node<T> search (T value){
		return search (value, sentinel);
	}
	private node<T> search (T value, node<T> lista){
		if (lista.getNext() == null){
			return null;
		}
		if(lista.getNext().getValue().equals(value)){
			return lista.getNext();
		}
		return search(value, lista.getNext());
	}
	
	public void indexof(T value){
		node<T> finder = search(value);
		if(finder != null)
			System.out.println(finder.getIndex());
		else
			System.out.println("Valor no encontrado");
	}
	
	//Metodos Eliminar o remplazar
	
	public void clear(){
		while(sentinel.getNext() != null){
			node<T> tmp = sentinel;
			while (tmp.getNext().getNext()!=null) {
				tmp = tmp.getNext();
			}
			tmp.setNext(null);
		}
		System.gc();
	}
	
	public boolean Replace(T value, T newvalue){
		node<T> finder = search(value);
		if(finder != null){
			finder.setValue(newvalue);
			return true;
		}
		else
			return false;
	}
	
	public node<T> remmove (T value){
		node<T> tmp = sentinel;
		node<T> borrado = null;
		while(tmp.getNext() != null){
			if (tmp.getNext().getValue().equals(value)){
				borrado = tmp.getNext();
				tmp.setNext(tmp.getNext().getNext());
				
				Reindex();
				System.gc();
				return borrado;
				
			}
			else{
				tmp = tmp.getNext();
			}
		}
		return null;
		
	}
	
	public boolean remove (T value){
		node<T> tmp = sentinel;
		while(tmp.getNext() != null){
			if (tmp.getNext().getValue().equals(value)){
				tmp.setNext(tmp.getNext().getNext());
				Reindex();
				System.gc();
				return true;
			}
			else{
				tmp = tmp.getNext();
			}
		}
		return false;
	}
	
	public boolean removefirst (){
		node<T> tmp = sentinel;
		if(tmp.getNext() == null){
			return false;
		}
		else if(tmp.getNext().getNext() == null){
			tmp.setNext(null);
			System.gc();
			return true;
		}
		else{
			tmp.setNext(tmp.getNext().getNext());
			Reindex();
			System.gc();
			return true;
		}
	}
	
	public boolean removelast(){
		node<T> tmp = sentinel;
		while(tmp.getNext() != null){
			tmp = tmp.getNext();
			if(tmp.getNext().getNext() == null){
				tmp.setNext(null);
				System.gc();
				return true;
			}
		}
		return false;
	}
	
	public boolean RemoveBefore(T value){
		node<T> tmp = sentinel;
		if(search(value) != null){
			while (!tmp.getNext().getNext().getValue().equals(value)) {
				tmp = tmp.getNext();
			}
			tmp.setNext(tmp.getNext().getNext());
			Reindex();
			System.gc();
			return true;
		}
		return false;
	}
	
	public boolean RemoveAfter(T value){
		node<T> tmp = sentinel.getNext();
		if(search(value) != null){
			while (!tmp.getValue().equals(value)) {
				tmp = tmp.getNext();
			}
			tmp.setNext(tmp.getNext().getNext());
			Reindex();
			System.gc();
			return true;
		}
		return false;
	}
	
	//Reindex
	
	public void Reindex(){
		node<T> tmp = sentinel;
		int i = 0;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			tmp.setIndex(i);
			i++;
		}
	}
	
	//Metodos de Imprimir
	
	public void size(){
		node<T> tmp = sentinel;
		int i = 0;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			i++;
		}
		System.out.println("Tamaño de la lista : " + i);
	}
	
	public boolean IsEmpty(){
		node<T> tmp = sentinel;
		if(tmp.getNext() == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void printer() {
		printer(sentinel);
	}
	
	private void printer(node<T> tmp) {
		if (tmp.getNext()== null) {
			return;
		}
		else
			System.out.println(tmp.getNext().getValue() + "   " + tmp.getNext().getIndex());
		printer(tmp.getNext());
	}
	
	public void pronter() {
		node<T> tmp = sentinel;
		while (tmp.getNext()!=null) {
			tmp = tmp.getNext();
			System.out.println(tmp.getValue() + "   " + tmp.getIndex());
		}
	}
	
}
