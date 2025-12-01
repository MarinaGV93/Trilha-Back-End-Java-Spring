package com.ada.aula_todo_list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//A junção de 3 aplicações (@Configuration = Diz que essa classe contém configuralções. @EnableAutoConfiguration = Pede para o Spring Configurar automaticamente tudo que for necessário a partir das dependências do pom.xml. @ComentScan = Indica que o Spring deve procurar classes anotadas com: @RestController, @Sevice, @Reposity, @Component... dentro do pacote principal do projeto.). Quando for rodar o projeto, vai pegar todas as anotações para saber o que ele vai fazer no ambiente
@SpringBootApplication
public class AulaTodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(AulaTodoListApplication.class, args);
	}

}
