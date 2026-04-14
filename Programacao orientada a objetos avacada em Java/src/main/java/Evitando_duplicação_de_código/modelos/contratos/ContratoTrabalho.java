package Evitando_duplicação_de_código.modelos.contratos;

import Evitando_duplicação_de_código.enums.Acao;

import java.util.List;

public class ContratoTrabalho extends Contrato {
    private String cargo;
    public ContratoTrabalho(List<String> pessoasEnvolvidas) {
        super(pessoasEnvolvidas);
    }

    @Override
    public void executarAcao(Acao acao) {
        System.out.println("Executando ação: " + acao);
    }

    public void rescindirPorJustaCausa() {
        System.out.println("Contrato de trabalho rescindido por justa causa");
    }

    @Override
    public String toString() {
        return "ContratoTrabalho{" +
                "cargo='" + cargo + '\'' +
                ", numeroContrato=" + numeroContrato +
                ", pessoasEnvolvidas=" + pessoasEnvolvidas +
                '}';
    }
}
