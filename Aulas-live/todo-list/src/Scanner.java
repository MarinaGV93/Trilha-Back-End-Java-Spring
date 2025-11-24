public class Scanner {
    public static void main(String[] args) {
        System.out.println("Digite o seu nome: ");

        //Para ler o que foi digitado no console
        java.util.Scanner sc = new java.util.Scanner(System.in);

        //Para digitar no console e salvar na variável
        String nome = sc.nextLine();

        System.out.println("Olá " + nome);

        //Fechar o scanner
        sc.close();
    }
}
