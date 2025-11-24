package tech.ada.java.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class JsonReaderDemo {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        lerComScanner();
        lerComHttpClient();
    }

    private static void lerComHttpClient() {
        try (
                // Estancia o objeto HttpClient com o builder
                HttpClient client = HttpClient.newBuilder().build()) {
            //Monta a requisição com base na URL
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://dummyjson.com/posts/1")).build();

            // Na hora de enviar a requisição, envia uma requisição assincrona
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    // Ao chegar a resposta
                    .thenApply(stringHttpResponse ->
                            // Aplicar uma conversão para Post
                            convertJsonToPost(stringHttpResponse.body()))
                    // Aceita no final e vai esperar (por ser assincrono)
                    .thenAccept(
                            // Imprime o objeto convertido
                            // System.out::println).join();

                    // Mudar para lambda para ver só o título
                            (post -> System.out.println(post.getTitle())));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void lerComScanner() {
        try (Scanner scanner = new Scanner(new URL("https://dummyjson.com/posts/1")
                // Abrir o Stream de entrada
                .openStream())) {

            // Ler o JSON
            String json = scanner.nextLine();

            // Criar um metodo para fazer a leitura
            Post post = convertJsonToPost(json);

            // Imprimir
            System.out.println(json);

            System.out.println(post);

            // Imprime só o título
            // System.out.println(post.getTitle());
        } catch (IOException ex)  {
            System.err.println(ex.getMessage());
        }
    }

    // Adiciona Throws
    @SneakyThrows
    private static Post convertJsonToPost(String json) {
        //Le o valor e joga no class
        return mapper.readValue(json, Post.class);
    }
}

// Converter para objeto Java

// Mapeando os atributos do JSON (precisa ser escrito exatamente igual ao site
class Post {
    private Long id;
    private String title;
    private String body;
    private Long userId;
    private Long views;

    // Array
    private String[] tags;

    // Objeto. Esta com {}
    private Reaction reactions;
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Reaction {
    private Long likes;
    private Long dislikes;
}
