package tp1.SimpleLinkedList;
import java.util.Iterator;

public class Main{

    public static void main (String[] args){
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
        MySimpleLinkedList<Integer> lista_d = new MySimpleLinkedList<Integer>();
        
        lista.insertFront(5);
        lista.insertFront(10);
        lista.insertFront(3);
        lista.insertFront(8);
        
        lista_d.insertFront(3);
        lista_d.insertFront(0);
        lista_d.insertFront(5);
        lista_d.insertFront(1);


        /* O(n*2) porque el metodo get(i) es O(n) * el for que tambien es O(n)*/

        for (int i = 0; i < lista.size(); i++)
            System.out.println(lista.get(i));
        
        
        /* Ejemplo del iterator */

        Iterator<Integer> recorrido = lista.iterator();

        while(recorrido.hasNext()){
            int elem = recorrido.next();
            System.out.println(elem);
        }

        System.out.println("Ejercicio 5");
        System.out.println(compararListasDesordenadas(lista, lista_d));
        System.out.println("Ejercicio 6");
        System.out.println(diferenceBetweenLists(lista, lista_d));
	}

    /* Ejercicio 5.A */

    public static MySimpleLinkedList<Integer> compararListasDesordenadas(MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2){
        MySimpleLinkedList<Integer> auxlist = new MySimpleLinkedList<Integer>();
        
        for(int i=0; i<lista1.size(); i++){
            int elem = lista1.get(i);
            for(int j=0; j<lista2.size(); j++){
                if(elem == lista2.get(j))
                    auxlist.insertLast(elem);
            }
        }
        return auxlist;
    }

    /* Ejercicio 5.B */

    public static MySimpleLinkedList<Integer> compararListasOrdenadas(MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2){
        MySimpleLinkedList<Integer> auxlist = new MySimpleLinkedList<Integer>();
        
        IterableMSLL<Integer> iter1 = (IterableMSLL<Integer>)lista1.iterator();
        IterableMSLL<Integer> iter2 = (IterableMSLL<Integer>)lista2.iterator();

        while (iter1.hasNext() && iter2.hasNext()){
            if(iter2.valor() < iter1.valor())
                iter2.next();
            if(iter1.valor() < iter2.valor())
                iter1.next();
            if(iter1.valor() == iter2.valor()){
                auxlist.insertLast(iter1.valor());
                iter1.next();
                iter2.next();
            }
        }
        return auxlist;
    }


    /* Ejercicio 6 QUEDA PARA MODIFICAR EN CLASE */

    public static MySimpleLinkedList<Integer> diferenceBetweenLists(MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2){
        MySimpleLinkedList<Integer> auxlist = new MySimpleLinkedList<Integer>();
        
        for(int i=0; i<lista1.size(); i++){
            boolean exists = false;
            for(int j=0; j<lista2.size(); j++){
                if(lista1.get(i).equals(lista2.get(j)))
                    exists = true;
            }
            if(!exists)
                auxlist.insertLast(lista1.get(i));
        }
        return auxlist;
    }

}
