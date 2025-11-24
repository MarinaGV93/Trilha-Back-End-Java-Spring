import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java_Funcional {
    /*
Paradigma Funcional
Trata as funções como cidadãos de primeira classe: pode passar funções como parâmetros, retorná-las e até armazená-las em variáveis.

    - Principal característica:
        Imutabilidade: uma vez que os dados são criados, eles não podem ser alterados, o que evita efeitos colaterais inesperados.

Interfaces funcionais
Interfaces que possuem APENAS um mét odo público abstrato. Elas são essenciais para o uso de expressões lambda, pois as lambdas implementam essas interfaces de forma concisa.

    @FunctionalInterface é usada para indicar que uma interface é funcional, mas ela não é obrigatória. O importante é que a interface tenha apenas um mét odo abstrato:

        @FunctionalInterface
        public interface Operacao{
            int calcular(int a, int b);
        }

        - Predicate
            Retorna um booleano e recebe como paramêtro um objeto

                @FunctionalInterface
                public interface Predicate<T>{
                    boolean test (T t);
                }
               */

                public class ExemploPredicate{
                    public static void main(String[] args) {
                        Predicate<String> isLong = str -> str.length() > 10;
                        System.out.println(isLong
                            //Teste
                            .test("Uma string"));
                        System.out.println(isLong.test("Uma string longa"));
                    }
                }
/*
        - Consumer
            Recebe um parâmetro e não retorna nada. Utilizada quando for realizar uma ação com os dados. Usa o mét odo accept:

                @FunctionalInterface
                public interface Consumer<T>{
                    void accept(T t);
                }
*/
                    public class ExemploConsumer{
                        public static void main(String[] args) {
                            Consumer<String> imprimirNome = nome -> System.out.println(nome);

                            imprimirNome.accept("Marina");
                        }
                    }
/*
        - Suppplier (fornecer)
            Não recebe nada como parâmetro, mas retorna um valor. Util para gerar valores ou fornecer dados através do mét odo get:

                @FunctionalInterface
                public interface Supplier<T>{
                    T get();
                }
*/
                    public class ExemploSupplier{
                        public static void main(String[] args) {
                            Supplier<String> fornecedor = () -> "Sou programador Java";

                            System.out.println(fornecedor.get());
                        }
                    }
/*
        - Function
            Recebe um valor do tipo T e retorna um valor do tipo R. Util quando aplicar transformações nos dados. O mét odo é o apply

                @FunctionalInterface
                public interface Function<T, R>{
                    //Recebe um valor T e retorna um R
                    R apply(T t);
                }
*/
                    public class ExemploFunction{
                        public static void main(String[] args) {
                            Function<String, Integer> stringSize = str -> str.length();

                            System.out.println(stringSize.apply("Texto"));
                        }
                    }
/*
Expressões Lambda
Maneira compacta de escrever funções anônimas (sem a necessidade de criação de uma classe intermediária):

    (parâmetros) -> expressão ou bloco de código:
    */

        public class ExpressaoLambda{
            public static void main(String[] args) {
                // Operacao soma = (a, b) -> a + b;
                // System.out.println(soma.calcular(5, 3));

                List<String> nomes = Arrays.asList("João", "José", "Maria");
                nomes.forEach(nome -> System.out.println(nome));
            }
        }
}
