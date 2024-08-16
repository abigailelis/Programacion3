package tp1;

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
	
	/**
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public T extractFront() {
		if(this.first == null)
			return null;
		Node<T> tmp = this.first;
		this.first = tmp.getNext();
		this._size--;
		if(this.first == null)
			this.ultimo = null;
		return tmp.getInfo();
	}

	public void insertLast(T info){
		if (this._size == 0)
			insertFront(info);
		else{
			ultimo.setNext(new Node<T>(info, null));
			this._size++;
			ultimo = ultimo.getNext();
			/**
			*Node<T> tmp = this.first;
			*while (tmp.getNext() != null)
			*	tmp = tmp.getNext();
			*tmp.setNext(new Node<T>(info, null));
			*this._size++;*
			*/
		}
	}

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
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public boolean isEmpty() {
		return this.first == null ;
	}
	
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
	public int size() {
		return this._size;
	}
	
	@Override
	public String toString() {
		String result = "";
        Node<T> aux = this.first;
        while (aux != null){
            result += aux.getInfo();
            if (aux.getNext() != null){
                result += " | ";
            }
            aux = aux.getNext();
        }
        return result;
	}
	
}
