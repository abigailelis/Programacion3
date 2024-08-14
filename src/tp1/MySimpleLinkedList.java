package ProgramacionIII.tp1;

public class MySimpleLinkedList<T> {
	
	private Node<T> first;
	
	public MySimpleLinkedList() {
		this.first = null;
		this._size = 0;
	}

	@Override
	/**
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
	}
	
	@Override
	/**
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public T extractFront() {		
		Node<T> tmp = this.first;
		this.first = tmp.getNext();
		this._size--;
		return tmp.getInfo();
	}

	@Override
	/**
	 * O(1) porque solo necesita acceder al primer elemento.
	 */
	public boolean isEmpty() {
		return this.first == null ;
	}
	
	public T get(int index) {
		// TODO
		return null;
	}
	
	public int size() {
		return this._size;
	}
	
	@Override
	public String toString() {
		// TODO
		return "";
	}
	
}
