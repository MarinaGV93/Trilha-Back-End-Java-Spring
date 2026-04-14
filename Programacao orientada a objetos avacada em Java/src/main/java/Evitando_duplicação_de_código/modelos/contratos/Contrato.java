package Evitando_duplicação_de_código.modelos.contratos;



import Evitando_duplicação_de_código.enums.Acao;

import java.util.ArrayList;
import java.util.List;

public abstract class Contrato {

    private static int contadorNumeroContrato = 0;
    public Integer numeroContrato;
    protected List<String> pessoasEnvolvidas;

    public Contrato(List<String> pessoasEnvolvidas) {
        this.numeroContrato = ++contadorNumeroContrato;
        this.pessoasEnvolvidas = new ArrayList<String>();
    }

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

    public abstract void executarAcao(Acao acao);
}
