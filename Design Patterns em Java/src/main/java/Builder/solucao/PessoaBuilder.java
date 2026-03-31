package Builder.solucao;

import java.time.LocalDate;

public class PessoaBuilder {

    private String nome;

    private String sobrenome;

    private String documento;

    private String email;

    private String apelido;

    private LocalDate dataNascimento;

    //Métodos

    //Vai retornar PessoaBuilder
    public PessoaBuilder nome(String nome) {
        this.nome = nome;
        //Retorna o próprio objeto
        return this;
    }

    //Vai retornar PessoaBuilder
    public PessoaBuilder sobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        //Retorna o próprio objeto
        return this;
    }

    //Vai retornar PessoaBuilder
    public PessoaBuilder documento(String documento) {
        this.documento = documento;
        //Retorna o próprio objeto
        return this;
    }

    //Vai retornar PessoaBuilder
    public PessoaBuilder email(String email) {
        this.email = email;
        //Retorna o próprio objeto
        return this;
    }

    //Vai retornar PessoaBuilder
    public PessoaBuilder apelido(String apelido) {
        this.apelido = apelido;
        //Retorna o próprio objeto
        return this;
    }

    //Vai retornar PessoaBuilder
    public PessoaBuilder dataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        //Retorna o próprio objeto
        return this;
    }

    /*
    public Pessoa criaPessoa(){
        return new Pessoa(nome, sobrenome, documento, email, apelido, dataNascimento);
    }
     */
}
