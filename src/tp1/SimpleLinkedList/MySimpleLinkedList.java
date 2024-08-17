package tp1.SimpleLinkedList;

public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	private Node<T> ultimo;
	private int _size;
	
	public MySimpleLinkedList() {
		this.first = null;
		this.ultimo = null;
		this._size = 0;
	}
	
	/**
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		if (this._size == 0)
			this.ultimo = this.first;
		this._size++;
	}

	//reveer
	public void insertInPos(T info, int index) {
		Node<T> tmp = new Node<T>(info, null);
        if(index == 0)
            insertFront(info);
        else{
		    tmp.setNext(this.getNode(index+1));
            this.getNode(index-1).setNext(tmp);
            this._size++;
        }
	}

	/**
	 * O(1) porque solo necesita acceder al ultimo elemento.
	 */
	public void insertLast(T info){
		if (this._size == 0)
			insertFront(info);
		else{
			ultimo.setNext(new Node<T>(info, null));
			this._size++;
			ultimo = ultimo.getNext();
		}
	}
	
	/**
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public T extractFront() {
		//Si está vacio retorna null
		if(this.first == null)
			return null;
		//Si tiene elementos crea una copia del 1ro, first ahora se vuelve el sig y decrementa el size
		Node<T> tmp = this.first;
		this.first = tmp.getNext();
		this._size--;
		//Si tenia un solo elemento y lo borro reinicio el ultimo a null
		if(this.first == null)
			this.ultimo = null;
		return tmp.getInfo();
	}

	/**
	 * O(n) donde n es la cantidad de elementos de la lista.
	 */
	public int indexOf(T info){
		int pos = -1;
		Node<T> cursor = this.first;
		while (cursor!= null && !cursor.getInfo().equals(info)){
			cursor = cursor.getNext();
			pos++;
		}
		if (cursor == null)
			return -1;
		else 
			return pos;
	}

	/**
	 *O(n) devuelve el elemento numero index ejemplo el 5to elemento.
	 */
	public T get(int index) {
		if(index < 0 || index > this._size )
			return null;
		else{
			Node<T> aux = this.first;
			for(int i = 0; i<index; i++)
				aux = aux.getNext();
			return aux.getInfo();
		}
	}

	private Node<T> getNode(int index) {
		if(index < 0 || index > this._size )
			return null;
		else{
			Node<T> aux = this.first;
			for(int i = 0; i<index; i++)
				aux = aux.getNext();
			return aux;
		}
	}

	public int size() {
		return this._size;
	}
	
	/**
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public boolean isEmpty() {
		return this.first == null ;
	}
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
