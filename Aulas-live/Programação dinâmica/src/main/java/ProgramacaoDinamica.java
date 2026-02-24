//Solução com memorização (top-down)

import java.util.HashMap;
import java.util.Map;

//O crescimento é diretamente proporcional ao tamanho da entrada. Se tem n = 50, vai ter 50 interações

public class ProgramacaoDinamica {

    public static void main(String[] args) {
        //Vai ter uma chave e um valor
        Map<
                //Valor que esta chamando
                Integer,
                //Valor da chave
                Long> memo = new HashMap<>();

        //Para olhar o tempo de execução do codigo
        //Começou a execução
        long inicio = System.currentTimeMillis();
        //Terminou a execução
        long fim = System.currentTimeMillis();
        int resultado = fibonacciMemo(10, memo);
        System.out.println("Fibonacci = " + resultado+ " |Tempo: " + (fim - inicio) + " ms");
    }

    public static int fibonacciMemo(int n, Map<Integer, Long> memo) {
        if (n <= 1) return n;
        //Checa se já tem a chave
        if (memo.containsKey(n))
            //Se sim, retorna ela
            return memo.get(n).intValue();
        System.out.println("Calculando fib(" + n + ")...");

        //Se nao, aplica a recursão e coloca o resultado dentro de um variavel
        int result = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        memo.put(
                //Passa o valor da chave
                n,
                //Passa o resultado
                (long) result);
        return result;
    }

//O crescimento é diretamente proporcional ao tamanho da entrada. Se tem n = 50, vai ter 50 interações
}
