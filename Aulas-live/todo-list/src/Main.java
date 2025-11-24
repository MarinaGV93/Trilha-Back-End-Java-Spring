import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean executando = true;

        System.out.println("ToDo List");

        while (executando){

            //Criar menu
            System.out.println();
            System.out.println("=========Menu=========");
            System.out.println("1 - Cadastrar tarefa");
            System.out.println("2 - Listar tarefas pendentes");
            System.out.println("3 - Buscar tarefas por título");
            System.out.println("4 - Marcar tarefa como concluída");
            System.out.println("5 - Remover uma tarefa");
            System.out.println("0 - Sair");
            System.out.println();

            //Pedir para o usuário escolher uma opção
            System.out.println("Escolha uma opção: ");
            Scanner sc = new Scanner(System.in);

            //Ler a opção escolhida
            int opcao = sc.nextInt();

            //Limpar o buffer do teclado
            sc.nextLine();

            System.out.println("Opção escolhida: " + opcao);
            System.out.println();

            //Comparar a opção escolhida com as opções do menu
        /*
        if (opcao == 1) {
            System.out.println("Cadastrar tarefa");
        } else if (opcao == 2) {
            System.out.println("Listar tarefas pendentes");
        } else if (opcao == 3) {
            System.out.println("Buscar tarefas por título");
        } else if (opcao == 4) {
            System.out.println("Marcar tarefa como concluída");
        } else if (opcao == 5) {
            System.out.println("Remover uma tarefa");
        } else if (opcao == 0) {
            System.out.println("Sair");
        } else {
            System.out.println("Opção inválida");
        }
         */

            // Usando switch case (java 14+)
        /*
            switch (opcao) {
            case 1:
                System.out.println("Tarefa cadastrada");
                //Pausar
                break;
            case 2:
                System.out.println("Tarefa listada");
                break;
            case 3:
                System.out.println("Tarefa buscada");
                break;
            case 4:
                System.out.println("Tarefa marcada como concluída");
                break;
            case 5:
                System.out.println("Tarefa removida");
                break;
            case 0:
                System.out.println("Sair");
                break;
            default:
                System.out.println("Opção inválida");
        }
         */

            //switch expression (expressão lambda)
            executando = switch (opcao){
                case 1 -> {
                    System.out.println("Digite o título: ");
                    String tituloEntrada = sc.nextLine();
                    System.out.println("Digite a descrição: ");
                    String descricao = sc.nextLine();
                    System.out.println("Digite a data de entrega (yyyy-MM-dd): ");
                    LocalDate dataEntrega = LocalDate
                            //Transformar a string em LocalDate
                            .parse(sc.nextLine());
                    System.out.println("Tarefa cadastrada");

                    //Criar um objeto da classe Tarefa
                    Tarefa novaTarefa = new Tarefa(tituloEntrada, descricao, dataEntrega);
                    System.out.println(novaTarefa);

                    //Pausar a execução por um momento antes de continuar o loop
                    yield true;
                }
                case 2 -> {
                    System.out.println("Tarefa listada");
                    yield true;
                }
                case 3 -> {
                    System.out.println("Tarefa buscada");
                    yield true;
                }
                case 4 -> {
                    System.out.println("Tarefa marcada como concluída");
                    yield true;
                }
                case 5 -> {
                    System.out.println("Tarefa removida");
                    yield true;
                }
                case 0 -> false;
                default -> {
                    System.out.println("Opção inválida");
                    yield true;
                }
            };
        }
    }
}
