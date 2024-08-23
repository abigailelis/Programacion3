package tp1.SimpleLinkedList;
import java.util.Iterator;

public class IterableMSLL<T> implements Iterator<T> {
    private Node<T> elemActual;

    public IterableMSLL(Node<T> first){
		this.elemActual = first;
	}
    
	
	public boolean hasNext(){
		return (this.elemActual != null);
	}

	public T next(){
		T elemSiguiente = elemActual.getInfo();
		elemActual = elemActual.getNext();
		return elemSiguiente;
	}
	
}
