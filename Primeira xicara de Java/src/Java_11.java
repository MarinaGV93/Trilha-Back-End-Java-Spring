import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Java_11 {
/*
Inferências de tipos
    Características:
        O tipo da variável é inferido pelo compilador com base no valor inicial.
        Não pode ser alterado após a atribuição inicial.
        A tipagem é feita em tempo de compilação, garantindo segurança, como no caso de variáveis explícitas.
 */
    public class ExemploVar {
        public static void main(String[] args){
            var nome = "Marina";
            var idade = 32;
            System.out.println(nome);
            System.out.println(idade);
        }
    }
/*
Mét odos Fábrica para Coleções
    List.of(): Cria uma lista imutável
    Set.of(): Cria um conjunto imutável
    Map.of(): Cria um mapa imutável
 */

    public class ExemploColecoes {
        public static void main(String[] args){

            //Criando uma lista
            List<String> lista = List.of("João", "Maria", "Carlos");
            System.out.println(lista);

            //Criando um conjunto
            Set<Integer> conjunto = Set.of(1, 2, 3, 4, 5);
            System.out.println(conjunto);

            //Criando um mapa
            Map<String, Integer> mapa = Map.of(
                    //Passa 1º a chave e depois o valor
                    "João", 25, "Maria", 30, "Carlos", 35
            );
            System.out.println(mapa);
        }
    }
/*
Cliente HTTP/2
    Facilitar a comunicação distribuída

    Características:
        Suporta HTTP/2 para melhorar a eficiência de redes.
        Permite chamadas assíncronas e síncronas.
        API baseada em Builder Pattern (estilo fluente (pode encadear met odos de maneira simples e elegante)).
 */

    public class ExemploHttpClient {
        public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

            //Criar uma conexao
            HttpClient client = HttpClient.newHttpClient();

            //Fazer uma requisição
            HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://jsonplaceholder.typicode.com/todos/1"))
                    //Construir o request
                    .build();

                    //Enviar o request para a URL
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            //Assíncrono
            //HttpResponse<String> response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());


            //Imprimir o que vai receber da URL
            System.out.println("Resposta: " + response.body());
        }
    }
/*
Mét odos privados em interfaces
    As interfaces permitem mét odos privados. Eles são úteis para refatorar código repetitivo nas implementações de met odos default.
 */

       void metodoDefault() {
            System.out.println("Método default");
            auxiliarPrivado();
        }

        private void auxiliarPrivado() {
            System.out.println("Método privado");
        }

/*

    static class TesteInterface implements ExemploInterface {
        public static void main(String[] args) {
            var obj = new TesteInterface();
            obj.metodoDefault();
        }
    }
 */


}
