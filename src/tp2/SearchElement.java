public class SearchElement {
    public static void main(String [] args){
        int [] sortArray = {1,4,7,9,10,25,27,30,30};

        int position = searchElement(sortArray, 4, 0, sortArray.length-1);
        System.out.println("The element is in position number: " + position);

    }

    /**
     * Ejercicio 2
     * Implemente un algoritmo recursivo para buscar un element en un arreglo ordenado ascendentemente.
     */

    public static int searchElement(int[] array, int element, int ini, int fin){
        int middle;
        if(ini > fin)
            return -1;
        else{
            middle = (ini + fin) / 2;
            if(element < array[middle])
                return searchElement(array, element, ini, middle-1);
            else if(element > array[middle])
                return searchElement(array, element, middle+1, fin);
            else
                return middle;
        }
   }
}
