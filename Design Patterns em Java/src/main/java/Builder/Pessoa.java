package Builder;

import java.time.LocalDate;

public class Pessoa {

    private String nome;

    private String sobrenome;

    private String documento;

    private String email;

    private String apelido;

    private LocalDate dataNascimento;

    //Não pode ser instanciada fora da classe
    private Pessoa(String nome, String sobrenome, String documento, String email, String apelido, LocalDate dataNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.email = email;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", apelido='" + apelido + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }

    public  static class PessoaBuilder {

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

        public Pessoa build(){
            return new Pessoa(nome, sobrenome, documento, email, apelido, dataNascimento);
        }
    }
}
