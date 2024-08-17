package tp1.DoubleLinkedList;

public class MyDoubleLinkedList<T> {
    private NodeDouble<T> first;
	private NodeDouble<T> ultimo;
	private int _size;
	
	public MyDoubleLinkedList() {
		this.first = null;
		this.ultimo = null;
		this._size = 0;
	}

	/**
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public void insertFront(T info) {
		NodeDouble<T> tmp = new NodeDouble<T>(info,null, null);
		tmp.setNext(this.first);
		this.first = tmp;
		if (this._size == 0)
			this.ultimo = this.first;
		this._size++;
	}

	public void insertInPos(T info, int index) {
		NodeDouble<T> tmp = new NodeDouble<T>(info, null, null);
        if(index == 0)
            insertFront(info);
        else if(index == size()-1)
            insertLast(info);
        else{
		    tmp.setNext(this.getNode(index+1));
            tmp.setPrev(this.getNode(index-1));
            this.getNode(index-1).setNext(tmp);
            this.getNode(index+1).setPrev(tmp);
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
			ultimo.setNext(new NodeDouble<T>(info, ultimo, null));
			this._size++;
			ultimo = ultimo.getNext();
		}
	}
	
	/**
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public T extractFront() {
		if(this.first == null)  //Si está vacio retorna null
			return null;

		NodeDouble<T> tmp = this.first;  //Si tiene elementos crea una copia del 1ro, first ahora se vuelve el sig y decrementa el size
		this.first = tmp.getNext();
        this.first.setPrev(null);
		this._size--;
		
		if(this.first == null)  //Si tenia un solo elemento y lo borro reinicio el ultimo a null
			this.ultimo = null;

		return tmp.getInfo();
	}

	/**
	 * O(n) donde n es la cantidad de elementos de la lista.
	 */
	public int indexOf(T info){
		int pos = -1;
		NodeDouble<T> cursor = this.first;
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
			NodeDouble<T> aux = this.first;
			for(int i = 0; i<index; i++)
				aux = aux.getNext();
			return aux.getInfo();
		}
	}

	private NodeDouble<T> getNode(int index) {
		if(index < 0 || index > this._size )
		    return null;
		else{
			NodeDouble<T> aux = this.first;
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
        NodeDouble<T> aux = this.first;
        while (aux != null){
            result += aux.getInfo();
            if (aux.getNext() != null)
                result += " | ";
            aux = aux.getNext();
        }
        return result;
	}
}
