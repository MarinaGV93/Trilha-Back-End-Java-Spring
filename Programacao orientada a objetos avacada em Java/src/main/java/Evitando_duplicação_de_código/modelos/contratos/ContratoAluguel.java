package Evitando_duplicação_de_código.modelos.contratos;

import Evitando_duplicação_de_código.enums.Acao;
import O_que_sao_os_principios_SOLID_S.modelos.contratos.interfaces.GerenciadorPessoas;

import java.util.List;

public class ContratoAluguel extends Contrato implements GerenciadorPessoas {
    private String endereco;
    private String tipo;
    private String nome;

    public ContratoAluguel(String endereco, String tipo) {
        super(List.of());
        this.endereco = endereco;
        this.tipo = tipo;
        this.nome = "";
    }

    public ContratoAluguel(String endereco, String casa, List<String> nome) {
        super(nome);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarPessoas(String pessoa) {
        this.pessoasEnvolvidas.add(pessoa);
    }

    @Override
    public String toString() {
        return "ContratoAluguel{" +
                "numeroContrato=" + numeroContrato +
                ", endereco='" + endereco + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                ", pessoasEnvolvidas=" + pessoasEnvolvidas +
                '}';
    }

    // public void executarAcao(Acao acao) {
    //     System.out.println("Ação " + acao.getValor() + " para o contrato de aluguel " + this.numeroContrato + " executada");
    // }

    @Override
    public void executarAcao(Acao acao) {
        System.out.println("Executando ação: " + acao);
    }

    public void rescindirPorJustaCausa() {
        System.out.println("ERRO: Contrato aluguel não pode ser rescindido por justa causa");
    }
}
