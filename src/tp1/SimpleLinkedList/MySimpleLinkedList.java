package tp1.SimpleLinkedList;
import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{
	
	private Node<T> first;
	private Node<T> ultimo;
	private int _size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.ultimo = null;
		this._size = 0;
	}
	
	/**
	 * O(1) CONSTANTE: Porque solo necesita acceder al primer elemento.
	 */
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		
		if (this._size == 0)
			this.ultimo = this.first;
		
		this._size++;
	}

	/**
	 * O(1) CONSTANTE : Porque solo necesita acceder al último elemento.
	 */

	public void insertLast(T info){
		if (this._size == 0)
			insertFront(info); //O(1)
		else{
			ultimo.setNext(new Node<T>(info, null));
			this._size++;
			ultimo = ultimo.getNext();
		}
	}
	
	/**
	 * O(1) CONSTANTE: Porque solo necesita acceder al primer elemento.
	 */
	public T extractFront() {
		if(this.first == null)  //Si está vacio retorna null y no realiza cambios
			return null;
		
		Node<T> tmp = this.first;  //Si tiene elementos crea una copia del 1ro, first ahora se vuelve el sig y decrementa el size
		
		this.first = tmp.getNext();
		this._size--;
		
		if(this.first == null)  //Si tenia un solo elemento y lo borro reinicio el ultimo a null
			this.ultimo = null;

		return tmp.getInfo();
	}

	/**
	 * O(n) LINEAL: Donde "n" es la cantidad de elementos de la lista.
	 * Porque en el peor de los casos debe acceder a todos los elementos para econtrar el último.
	 */

	public int indexOf(T info){
		int pos = -1;
		Node<T> cursor = this.first;

		while (cursor!= null && !cursor.getInfo().equals(info)){ //O(n)
			cursor = cursor.getNext();
			pos++;
		}

		if (cursor == null)
			return -1;

		return pos;
	}

	/**
	 * O(n) LINEAL: Donde "n" es la cantidad de elementos de la lista.
	 * Porque en el peor de los casos debe acceder a todos los elementos para encontrar el último.
	 */

	public T get(int index) {
		if(index < 0 || index > this._size )
			return null;

		Node<T> aux = this.first;

		for(int i = 0; i < index; i++)  //O(n)
			aux = aux.getNext();

		return aux.getInfo(); //Devuelve info del elemento número "index": ejemplo el 5to elemento.
	}

	
	/**
	 * O(1) CONSTANTE: Porque no accede a ningun elemento, 
	 * solo al atributo _size de la clase.
	 */

	public int size() {
		return this._size;
	}
	
	/**
	 * O(1)CONSTANTE: Porque no accede a ningun elemento,
	 * solo al atributo first de la clase.
	 */

	public boolean isEmpty() {
		return this.first == null ;
	}

	/** Retorna un Iterador del tipo IterableMSLL */

	public Iterator<T> iterator(){
		return new IterableMSLL<T>(first);
	}

	/**
	 * O(n) LINEAL: Donde "n" es la cantidad de elementos de la lista.
	 * Porque debe acceder a todos los elementos.
	 */

	@Override
	public String toString() {
		String result = "";
        Node<T> aux = this.first;
        
		while (aux != null){
            result += aux.getInfo();
			if (aux.getNext() != null)
                result += " | ";
            aux = aux.getNext();
        }
        return result;
	}
	
}
