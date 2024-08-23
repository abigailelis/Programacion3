package tp1.SimpleLinkedList;

import java.util.Iterator;

public class Main{

    public static void main (String[] args){
		MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<Integer>();
        lista.insertFront(5);
        lista.insertFront(10);
        lista.insertFront(3);
        lista.insertFront(8);

        MySimpleLinkedList<Integer> lista_d = new MySimpleLinkedList<Integer>();
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

        Iterator<Integer> recorrido = lista.iterator();

        while(recorrido.hasNext()){
            int elem = recorrido.next();
            System.out.println(elem);
        }
	}

    //Ejercicio 5
    public static MySimpleLinkedList<Integer> compararListasDesordenadas(MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2){
        MySimpleLinkedList<Integer> auxlist = new MySimpleLinkedList<Integer>();
        
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
    public static MySimpleLinkedList<Integer> diferenceBetweenLists(MySimpleLinkedList<Integer> lista1, MySimpleLinkedList<Integer> lista2){
        MySimpleLinkedList<Integer> auxlist = new MySimpleLinkedList<Integer>();
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


    public static MySimpleLinkedList<Integer> agregarOrdenado (MySimpleLinkedList<Integer> lista, Integer elem){
        for (int i = 0; i < lista.size(); i++){
            // if(prev > elem) Cómo comparo elementos de cualquier tipo ?
        // lista.insertInPos(elem, i);
        }
        return lista;
    }

}
