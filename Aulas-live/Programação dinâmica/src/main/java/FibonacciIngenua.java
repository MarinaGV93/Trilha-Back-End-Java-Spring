
public class FibonacciIngenua {
    public static void main(String[] args) {
        //Para olhar o tempo de execução do codigo
        //Começou a execução
        long inicio = System.currentTimeMillis();
        //Terminou a execução
        long fim = System.currentTimeMillis();
        int resultado = fibonacci(50);
        System.out.println("Fibonacci = " + resultado+ " |Tempo: " + (fim - inicio) + " ms");
    }

//Usa recursividade simples
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        System.out.println("Calculando fib(" + n + ")...");
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

//fib(5) chama fib(3) 2x
//fib(2) 3x ... explosão exponencial

//Para n = 40, o código faz mais de 300 milhões de chamadas