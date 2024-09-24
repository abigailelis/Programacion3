public class IndexEqualElement {
    public static void main (String [] args){
        int[] array = {-3, -1, 0, 2, 4, 6, 10};
        if(indexEqualElement(array, 0))
            System.out.println("Existe al menos un elemento cuyo valor es igual a su posición");
        else
            System.out.println("No existe ningun elemento cuyo valor sea igual a su posición");
    }

    public static boolean indexEqualElement(int[] array,  int i){
        if(array[i] != i && i < array.length){
            System.out.print(array[i] + " | ");
            indexEqualElement(array, i+1);
        }
        return i < array.length;
    }
}
