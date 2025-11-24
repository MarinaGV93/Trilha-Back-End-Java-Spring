package tech.ada.java.curso_spring.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Transformar a classe em um controlador (recebe as requisições e envia as respostas) atraves do REST
// O @ResponseBody que tem dentro, vai transformar todas respostas em um objeto JSON
@RestController
// Definir qual vai ser o caminho, qua vai digitar na URL, que vai me trazer para esse controlador. Qual o mapeamento da requisição que vai trazer para cá. Define que pe o /, caminho inicial
@RequestMapping("/hello")
public class HelloWorld {

    // Qual o verbo HTTP que vai me trazer para cá
    @GetMapping

    public String hello() {
        return "Hello World";
    }
}
