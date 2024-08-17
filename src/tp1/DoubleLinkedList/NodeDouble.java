package tp1.DoubleLinkedList;

public class NodeDouble<T> {
    private T info;
	private NodeDouble<T> prev;
    private NodeDouble<T> next;
    

	public NodeDouble() {
		this.info = null;
		this.next = null;
        this.prev = null;
	}
	
	public NodeDouble(T info, NodeDouble<T> prev,NodeDouble<T> next) {
		this.setInfo(info);
        this.setPrev(prev);
		this.setNext(next);
	}
	
    public NodeDouble<T> getPrev() {
		return prev;
	}

	public void setPrev(NodeDouble<T> prev) {
		this.prev = prev;
	}
    
	public NodeDouble<T> getNext() {
		return next;
	}

	public void setNext(NodeDouble<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public String toString() {
		return this.info.toString();
	}
}
