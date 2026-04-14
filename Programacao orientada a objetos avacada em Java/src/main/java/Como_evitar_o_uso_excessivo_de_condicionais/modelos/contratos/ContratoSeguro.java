package Como_evitar_o_uso_excessivo_de_condicionais.modelos.contratos;

import Como_evitar_o_uso_excessivo_de_condicionais.enums.Acao;
import O_que_sao_os_principios_SOLID_S.modelos.pessoas.Pessoa;

import java.util.List;

public abstract class ContratoSeguro extends Contrato {
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

    public abstract void executarAcao(Acao acao);
}
