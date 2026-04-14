package Princípio_da_Inversão_de_Dependência_D.modelos.contratos;

import Princípio_da_Inversão_de_Dependência_D.enums.Acao;

import java.util.List;

public class ContratoTrabalho extends Contrato {
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
}
