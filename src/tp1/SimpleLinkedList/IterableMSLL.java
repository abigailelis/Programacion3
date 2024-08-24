package tp1.SimpleLinkedList;
import java.util.Iterator;

public class IterableMSLL<T> implements Iterator<T> {
    
	private Node<T> elemActual;

    public IterableMSLL(Node<T> first){
		this.elemActual = first;
	}
    
	/* Retorna true/false dependiendo de si el elemento actual es null */
	
	public boolean hasNext(){
		return this.elemActual != null;
	}

	/* Retorna el valor del elem. Actual pero setea elemActual con getNext()*/

	public T next(){
		T elemSiguiente = elemActual.getInfo();
		elemActual = elemActual.getNext();
		return elemSiguiente;
	}

	/* Retorna el valor del elemento Actual */

	public T valor(){
		return elemActual.getInfo();
	}
	
}
