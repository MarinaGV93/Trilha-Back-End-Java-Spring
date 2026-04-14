package Aplicando_a_substituição_de_Liskov_L.modelos.contratos;



import Aplicando_a_substituição_de_Liskov_L.enums.Acao;

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


    public abstract void executarAcao(Acao acao);
}
