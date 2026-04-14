package Princípio_da_Segregação_de_Interface_I.modelos.contratos;



import Princípio_da_Segregação_de_Interface_I.enums.Acao;

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
