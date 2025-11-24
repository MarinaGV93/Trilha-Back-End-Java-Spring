import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream_e_Optional {
    /*
Stream

Representa uma sequência de elementos suportam elementos sequenciais e paralelos.
Formam um pipeline (sequencias de operações) de operações que podem ser aplicadas a uma coleção de dados, arrays e tipos númericos. A vantagem de usar essas pipelines é que não é necessário armazenar os resultados intermediários, o que economiza memória e melhora a performance.

    - Operadores intermediários
        São aqueles que produzem uma nova Stream como  resultado de uma operação, sem consumir a Stream original. Podem ser encadeados para formar pipelines de operações.
        T odo operador de uma stream que retorna uma Stream é um operador intermediário:

            filter(): filtra elementos da Stream.
            map(): aplica uma função para transformar os elementos.
            disrinct(): remove elementos duplicados.
            sorted(): ordena os elementos da Stream.
*/
                    public class ExemploIntermediario{
                        public static void main(String[] args) {

                        //Lista de nomes
                            List<String> nomes = List.of("Ana", "Bia", "Carlos", "Daniel", "Ana");

                        //Tranformar em um fluxo de dados (Stream)
                            List<String> nomesFiltrados = nomes.stream()

                            //Filtrar nomes que começam com a letra "A"
                            //Intermediário
                                .filter(nome -> nome.startsWith("A"))

                            //Remover nomes duplicados
                            //Intermediário
                                .distinct()

                            //Ordenar os nomes .toList();
                                .collect(Collectors.toList());

                                System.out.println(nomesFiltrados);
                        }
                    }
/*
    - Operadores terminal
        Aqueles que consomem a Stream e geram um resultado em cima do processamento a Stream.
        Ela não pode ser reutilizada após uma operação terminal.

            collect(): coleta os elementos em uma coleção (como List, Set, Map).
            forEach(): executa uma ação para cada elemento da Stream.
            reduce(): realiza uma redução de todos os elementos da Stream em um único valor.
            */

                    public class ExemploTerminal{
                        public static void main(String[] args) {

                        //Lista de nomes
                            List<String> nomes = List.of("Ana", "Bia", "Carlos", "Daniel", "Ana");

                        //Tranformar em um fluxo de dados (Stream)
                            List<String> nomesFiltrados = nomes.stream()

                            //Filtrar nomes que começam com a letra "A"
                                .filter(nome -> nome.startsWith("A"))

                            //Remover nomes duplicados
                                .distinct()

                            //Ordenar os nomes .toList();
                            //Terminais
                                .collect(Collectors.toList());

                                System.out.println(nomesFiltrados);

                                //Imprimir todos os nomes
                                nomesFiltrados.forEach(System.out::println);

                                //Colocar em uma variavel
                                var lista =

                                //Filtrar
                                //Transformar em um fluxo de dados (Stream)
                                nomes.stream()

                                //Nomes que contém a letra A
                                    .filter(nome -> nome.contains("A"))
                                    .distinct()

                                // Dentro do toSet, não pode ter nomes iguais
                                .collect(Collectors.toList());

                                System.out.println(lista);

                        }
                    }
/*
    - Optional
        Lidar com valores que podem não estar presentes, como null ou valores vazios.
        Evita erros de NullPointerException (NPE), que ocorrem quando tentamos acessar um objeto que é null.
        Para criar:
            Optional.of(valor): cria um Optional com um valor não nulo.
            Optional.empty(): cria um Optional vazio.
            Optional.ofNullable(valor): cria um Optional que pode ser vazio ou conter um valor
*/
                    public class ExemploOptional{
                        public static void main(String[] args) {
                            String nome = "Java";

                            Optional<String> nomeOptional = Optional.of(nome);
                            Optional<String> nomeOptional2 = Optional.empty();

                            System.out.println(nomeOptional.isPresent()); // true
                            System.out.println(nomeOptional2.isPresent()); // false

                            //Criar um Optional que pode ser nulo
                            String nomeVazio = null;
                            Optional<String> nomeVazioOptional = Optional.ofNullable(nomeVazio);

                            System.out.println("**********");

                            // Verificar se o valor está presente. Não imprime nada se estiver vazio
                            nomeVazioOptional.ifPresent(System.out::println);

                            //Se o optional estiver vazio, retorna um valor padrão
                            String nomeOuDefault = nomeOptional.orElse("JAVA 8");
                            System.out.println(nomeOuDefault);

                            //Se o optional estiver vazio, executa uma função para gerar um valor
                            String nomeOuGerado = nomeVazioOptional.orElseGet(() -> "JAVA 11s");
                            System.out.println(nomeOuGerado);


                            //Se o optional estiver vazio, lança uma exceção
                            nomeVazioOptional.orElseThrow(() -> new RuntimeException("JAVA 21"));
                        }
                    }
/*
        - Operações com Optional:
            isPresent(): executa uma ação se o valor estiver presente.
            orElse(): retorna o valor se estiver presente, ou um valor padrão se estiver vazio.
            orElseGet(): retorna o valor se estiver presente, ou executa uma função para gerar um valor se estiver vazio.
            orElseThrow(): retorna o valor se estiver presente, ou lança uma exceção se estiver
*/
}
