public class Java_17 {
/*
Text Block
    Vantagens:
        Facilita na criação de Strigs longas, como texto de SQL, JSON ou ate HTML, sem a necessidade de concatenações completas ou uso de caracteres scape.
        Melhor legibilidade, pois o conteúdo fica alinhado como aparece no código:

        //Antes era assim:
            public class ExemploTextBlock {
                public static void main(String[] args){
                    String sql = "SELECT id, name, age FROM users\n"
                        + "WHERE age > 18\n"
                        + "ORDER BY name";

                    System.out.println(sql);
                }
            }
 */
}
class ExemploTextBlock {
    public static void main(String[] args){
        String sql = """
                        SELECT id, name, age FROM users
                        WHERE age > 18
                        ORDER BY name"
                        """;

        System.out.println(sql);
    }
}
/*
Switch Expression
    Pode ser usado como uma expressão que retorna um valor, em vez de apenas como uma declaração. Isso elimina a necessidade de usar variáveis auxiliares:

        //Antes
            public class ExemploSwitch {
                public static void main(String[] args){
                    int dia = 2;
                    String nomeDia;

                    switch (dia){
                        case 1:
                            nomeDia = "Domingo";
                            break;
                        case 2:
                            nomeDia = "Segunda-feira";
                            breal;
                        default:
                            nomeDia  = "Dia inválido";
                            break;
                    }
                    System.out.println(nomeDia);
                }
            }
 */

class ExemploSwitch {
    public static void main(String[] args){
        int dia = 2;

        String nomeDia = switch (dia){
            //A -> substitui o break
            case 1, 7-> "Domingo";
            case 2-> "Segunda-feira";
            default-> "Dia inválido";
        };
        System.out.println(nomeDia);
    }
}

/*
Pattern Matching
    Pode testar e fazer cast de objetos de maneira mais eficiente e com menos código:

        //Antes
            public class ExemploPatternMatching {
                public static void main(String[] args){
                    Object obj = "Texto de exemplo";

                    //Se for uma instancia de uma string
                    if (obj instanceof String) {
                        //Pode fazer o cast para uma string
                        String str = (String)  obj;
                        System.out.println(str);
                    }
                }
            }
 */

class ExemploPatternMatching {
    public static void main(String[] args){
        Object obj = "Texto de exemplo";

        //Ja cria uma variavel que vai receber o valor caso o objeto seja daquele tipo
        if (obj instanceof String str) {
            System.out.println(str);
        }
    }
}

//Quando o met odo equals é sobrescrito em classes:
/*

class Pessoa {
    public static void main(String[] args){
        String nome;

        public Pessoa(String nome) {this.nome = nome;}

        @Override
        public boolean equals(Object obj){

        //Ao verificar se o objeto é uma instancia de uma pessoa, ja converte (faz o cast) automaticamente para essa variavel p
            if (obj instanceof Pessoa p){ //Uso de Pattern Matching no equals
                return this.nome.equals(p.nome);
            }
        }
    }
}
 */

/*
Record (registros)
    Nova forma de definir classes imutáveis de maneira concisa.

    Caracteristicas:

        Imutabilidade: é uma classe final (não pode ser estendida e herdada) com todos os seus atributos também final.
        Sintaxe Concisa: o compilador gera automaticamente o construtor canônico, met odos toString(), equals() e hashCod().
        Acessadores: os met odos para acessar os atributos são gerados automaticamente. Não seguem o padrão get e sim o nome do atributo. Em vez de getNome, somente o met odo Nome.
        Facilidade: não precisa escrever código repetitivo, como getters, setters, toString(), equals(), etc.

        //Antes
        //Para criar dados
            public class Pessoa {
                private String nome;
                private int idade;

                //Construtor
                public Pessoa(String nome, int idade){
                    this.nome = nome;
                    this.idade = idade;
                }

                //Met odos
                public String getNome(){
                    return nome;
                }

                public int getIdade(){
                    return idade;
                }

                @Override
                public String oString(){
                    return "Pessoa{nome='" + nome + "', idade=" + idade + "}";
                }

                @Override
                public boolean equals(Object o){

                //Implementação de equals
                    return true;
                }

                @Override
                public int hashCode(){

                //Implementação de hashCode
                    return 0;
                }
            }
 */
//public
 record Pessoa(String nome, int idade){

    //Construtor adicionar
     public Pessoa(String nome){
         this(nome, 18);
     }
}

/*
Sealed Class (Classes celadas)
    Permitem controlar explicitamente quais classes podem estender uma classe base (controle sobre a herança). Permite definir um conjunto restrito de subclasses, oferecendo um controle mais rigoroso sobre a hierarquia de tipos.

        Caracteristica:
            Não podem ser herdadas ou estendidas livremente

        public class Animal {
            public void fazerSom() {
                System.out.println("Som do animal");
            }
        }

        class Cachorro extends Animal {
            public void fazerSom() {
                System.out.println("Latido");
            }
        }

        class Gato extends Animal {
            public void fazerSom(){
                System.out.println("Miado");
            }
        }
 */
//Indica quais as classes que são permitidas herdarem de animal
//public
sealed class Animal permits Cachorro, Gato {
    public void fazerSom() {
        System.out.println("Som do animal");
    }
}

final class Cachorro extends Animal {
    public void fazerSom() {
        System.out.println("Latido");
    }
}

final class Gato extends Animal {
    public void fazerSom(){
        System.out.println("Miado");
    }
}