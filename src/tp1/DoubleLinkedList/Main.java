package tp1.DoubleLinkedList;

public class Main{

    public static void main (String[] args){
		MyDoubleLinkedList<Object> lista = new MyDoubleLinkedList<Object>();
        lista.insertFront(5);
        lista.insertFront(10);
        lista.insertFront(3);
        lista.insertFront(8);

        MyDoubleLinkedList<Object> lista_d = new MyDoubleLinkedList<Object>();
        lista_d.insertFront(3);
        lista_d.insertFront(0);
        lista_d.insertFront(5);
        lista_d.insertFront(1);

        //System.out.println(lista);

        /** O(n*2) porque el metodo get(i) es O(n) * el for que tambien es O(n)
        *   for (int i = 0; i < lista.size(); i++)
        *       System.out.println(lista.get(i));
        */
        System.out.println("Ejercicio 5");
        System.out.println(compararListasDesordenadas(lista, lista_d));

        System.out.println("Ejercicio 6");
        System.out.println(diferenceBetweenLists(lista, lista_d));
	}

    //Ejercicio 5
    public static MyDoubleLinkedList<Object> compararListasDesordenadas(MyDoubleLinkedList<Object> lista1, MyDoubleLinkedList<Object> lista2){
        MyDoubleLinkedList<Object> auxlist = new MyDoubleLinkedList<Object>();
        
        for(int i=0; i<lista1.size(); i++){
            for(int j=0; j<lista2.size(); j++){
                if(lista1.get(i).equals(lista2.get(j))){
                    auxlist.insertLast(lista1.get(i));
                    j = lista2.size();
                }
            }
        }
        return auxlist;
    }

    //Ejercicio 6
    public static MyDoubleLinkedList<Object> diferenceBetweenLists(MyDoubleLinkedList<Object> lista1, MyDoubleLinkedList<Object> lista2){
        MyDoubleLinkedList<Object> auxlist = new MyDoubleLinkedList<Object>();
        for(int i=0; i<lista1.size(); i++){
            boolean exists = false;
            for(int j=0; j<lista2.size(); j++){
                if(lista1.get(i).equals(lista2.get(j))){
                    exists = true;
                    j=lista2.size();
                }
            }
            if(!exists)
                auxlist.insertLast(lista1.get(i));
        }
        return auxlist;
    }



    public static MyDoubleLinkedList<Object> agregarOrdenado (MyDoubleLinkedList<Object> lista, Object elem){
        for (int i = 0; i < lista.size(); i++){
            // if(prev > elem) Cómo comparo elementos de cualquier tipo ?
                lista.insertInPos(elem, i);
        }
        return lista;
    }
}
