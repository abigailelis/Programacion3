public class DecimalToBinary{
    public static void main (String [] args){
        decimalToBinary(26);
    }

    public static void decimalToBinary(int dividend){
        if(dividend >= 2)
            decimalToBinary(dividend/2); 
        System.out.print(dividend%2);
    }
}