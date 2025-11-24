//import static java.lang.StringTemplate.STR;

import java.util.List;
import java.util.SequencedCollection;

public class Java_21 {
/*
String Template
    Caracteristicas:
        Suporta expressoes dinamicas dentro das Strings.
        Permite a personalização do processador de strings
        O recurso esta em preview (pode ser modificado em versões futuras)

        //Antes
        public class ExemploStringTemplate {
                public static void main(String[] args){
                    String nome = "João";
                    int idade = 30;
                    String texto = "Nome: " + nome + ", Idade: " + idade;
                    System.out.println(texto);
                }
            }
 */
public class ExemploStringTemplate {
    public static void main(String[] args){
        String nome = "João";
        int idade = 30;
        //String texto = STR."Nome: \{nome} Idade: \{idade}";
        //System.out.println(texto);
    }
}
/*
Record Pattern
    Melhoria do Pattern Matching
    Permite um desestruturamento de records atraves do destructuring
    É uma forma de combinar padrões com objetos.
    Permite que use os atributos de um Record diretamente sem precisar acessar cada atributo de maneira explicita.

    Caracteristicas:
        A facilidade da extração de atributos de um record
        Uma versao prévia
 */

public record Pessoa(String nome, int idade){

}

class ExemploRecordPattern{
    public static void main() {
        //Instancia uma nova pessoa
        Pessoa pessoa = new Pessoa("João", 30);

        //Desestruturar a pessoa em variaveis separadas
        if (pessoa instanceof Pessoa(String nome, int idade)){
            System.out.println(nome);
            System.out.println(idade);
        }
    }
}

/*
Sequenced Collections (coleções sequenciais)
    Uma abstração de coleções

    Caracteristicas:
        Permite adicionar ou remover elementos nas duas pontas da coleção
        Oferece met odos para acesso eficiente ao primeiro e ao último elemento
        Oferece suporte para inversão da coleção

 */

public class ExemploSequencedCollections{
    public static void main(String[] args) {
        SequencedCollection<String> nomes = List.of("João", "Maria", "Carlos");

        //Primeiro elemento
        System.out.println(nomes.getFirst());

        //Último elemento
        System.out.println(nomes.getLast());

        //Reverter a lista
        System.out.println(nomes.reversed());
    }
}

}
