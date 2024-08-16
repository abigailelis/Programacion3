package tp1;


public class main {
    public static void main (String [] args){
		MySimpleLinkedList lista = new MySimpleLinkedList<>();
        lista.insertFront(5);
        lista.insertFront(10);

        System.out.println(lista);

        /**
         * O(n*2) porque el metodo get(i) es O(n) * el for que tambien es O(n)
         */
        for (int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
	}
}
