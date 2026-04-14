package Introducao_a_POO.contratos_herança_interface;

import Como_evitar_o_uso_excessivo_de_condicionais.enums.Acao;

import java.util.ArrayList;
import java.util.List;

public abstract class Contrato {
    private static int contadorNumeroContrato = 0;
    public Integer numeroContrato;
    private List<String> pessoasEnvolvidas;

    public Contrato(List<String> pessoasEnvolvidas) {
        this.numeroContrato = ++contadorNumeroContrato;
        this.pessoasEnvolvidas = new ArrayList<String>();
    }

    public Contrato() {
        this.numeroContrato = ++contadorNumeroContrato;
        this.pessoasEnvolvidas = new ArrayList<String>();
    }

    public abstract void assinar();

    public abstract void cancelar();

    public static int getContadorNumeroContrato() {
        return contadorNumeroContrato;
    }

    public static void setContadorNumeroContrato(int contadorNumeroContrato) {
        Contrato.contadorNumeroContrato = contadorNumeroContrato;
    }

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public List<String> getPessoasEnvolvidas() {
        return pessoasEnvolvidas;
    }

    public void setPessoasEnvolvidas(List<String> pessoasEnvolvidas) {
        this.pessoasEnvolvidas = pessoasEnvolvidas;
    }


    public void executarAcao(Acao acao){
        System.out.println("Ação " + acao.getValor() + " para o contrato " + this.numeroContrato + " executada");
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "numeroContrato=" + numeroContrato +
                ", pessoasEnvolvidas=" + pessoasEnvolvidas +
                '}';
    }
}
