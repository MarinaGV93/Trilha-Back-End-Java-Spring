/*
Vantagem:
    Construir objetos mais legiveis.
 */
package Builder.solucao;

import Builder.Pessoa;

import java.time.LocalDate;

public class TestePessoaBuilder {
    public static void main(String[] args) {
        Pessoa pessoa =  new Pessoa.PessoaBuilder()
                //Fluência de mét odo -> quando da para chamar um met odo atras do outro, pq cada met odo retorna o próprio objeto
                //Pode colocar em qualquer ordem
                .nome("Marina")
                .documento("123456789")
                .sobrenome("Ferreira")
                .email("marina@ada.com")
                .apelido("mari")
                .dataNascimento(LocalDate.of(1993, 1, 1))
                .build();

        System.out.println(pessoa);

        //Permite trabalhar em cima de outra string
        StringBuilder sb = new StringBuilder().append("palavra 1")
                .append("palavra 2");

        System.out.println(sb);

    }
}
