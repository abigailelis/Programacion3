public class Fibonacci {
    public static void main(String[] args) {
        System.out.print(Fibonacci(10));
    }

    public static int Fibonacci(int n) {
        if(n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return Fibonacci(n-1) +  Fibonacci(n-2);
    }
}
