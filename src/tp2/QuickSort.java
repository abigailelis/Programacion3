import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int numbers[] = {1, 9, 23, 4, 55, 100, 1, 1, 23};
        System.out.println("Before QS: " + Arrays.toString(numbers));
        quicksort(numbers, 0, numbers.length - 1);
        System.out.println("After QS: " + Arrays.toString(numbers));

    }

    private static int particion(int array[], int left, int right) {
        int pivote = array[left];
        while (true) {
            while (array[left] < pivote) {
                left++;
            }
            while (array[right] > pivote) {
                right--;
            }

            if (left >= right) {

                return right;
            } else {
                int temporal = array[left];
                array[left] = array[right];
                array[right] = temporal;
    
                left++;
                right--;
            }
        }
    }


    // Divide y vencerás
    private static void quicksort(int array[], int left, int right) {
        if (left < right) {
            int indiceParticion = particion(array, left, right);
            quicksort(array, left, indiceParticion);
            quicksort(array, indiceParticion + 1, right);
        }
    }
}