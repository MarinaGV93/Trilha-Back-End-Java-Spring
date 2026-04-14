package E_se_algo_falhar.excecao;

import E_se_algo_falhar.modelos.contratos.Contrato;

public class ContratoInvalidoException extends RuntimeException{
    public ContratoInvalidoException(Contrato contrato) {
        super("[ERRO] Contrato inválido! Contrato = " + contrato);
    }

    public ContratoInvalidoException(String contratoInválido, Contrato contrato) {
    }
}
