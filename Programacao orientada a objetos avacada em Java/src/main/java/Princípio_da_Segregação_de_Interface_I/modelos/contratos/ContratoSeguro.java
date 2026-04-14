package Princípio_da_Segregação_de_Interface_I.modelos.contratos;

import O_que_sao_os_principios_SOLID_S.modelos.pessoas.Pessoa;
import Princípio_da_Segregação_de_Interface_I.enums.Acao;

import java.util.List;

public class ContratoSeguro extends Contrato {
    private Double valorSeguro;
    private List<Pessoa> pessoas;

    public ContratoSeguro(Double valorSeguro, List<String> nomesPessoas) {
        super(nomesPessoas);
        this.valorSeguro = valorSeguro;
        this.pessoas = nomesPessoas.stream()
                .map(Pessoa::new)
                .toList();
    }

    @Override
    public String toString() {
        return "ContratoSeguro{" +
                "valorSeguro=" + valorSeguro +
                ", pessoas=" + pessoas +
                '}';
    }

    @Override
    public void executarAcao(Acao acao) {
        System.out.println("Ação " + acao.getValor() + " para o contrato de seguro " + this.numeroContrato + " executada");
    }

    public void rescindirPorJustaCausa() {
        System.out.println("Contrato de seguro rescindido por justa causa");
    }
}
